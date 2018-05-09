package eu.tp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import eu.tp.model.Employee;

class CrudHiberanateTest {

	private EmbeddedDatabase db;

	@BeforeEach
	void setUp() throws Exception {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
	    		.addScript("classpath:testdb/schema.sql")
			.addScript("classpath:testdb/data.sql").build();
	}

	@AfterEach
	void tearDown() throws Exception {
		db.shutdown();
	}

	@Test
	void test() {
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Employee.class).buildSessionFactory()) {
			
			int PEPSI_ID = 103;
			
			// CREATE
			try (Session session = factory.getCurrentSession()) {
				
				List<Employee> empList = new ArrayList<Employee>();
				empList.add(new Employee(101, "All", "Bundy", "Coca-Cola"));
				empList.add(new Employee(102, "Tom", "Me", "Coca-Cola"));
				empList.add(new Employee(PEPSI_ID, "Mike", "Nord", "Pepsi"));

				session.beginTransaction();
				// Before
				int size = session.createQuery("from Employee").getResultList().size();
				Assert.assertEquals(21, size);
				
				// Create
				empList.forEach(session::save);
				//
				size = session.createQuery("from Employee").getResultList().size();
				Assert.assertEquals(24, size);
				
				session.getTransaction().commit();
			}
			
			// UPDATE
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				
				int size = session.createQuery("from Employee where company = 'Apple'").getResultList().size();
				Assert.assertEquals(0, size);
				size = session.createQuery("from Employee where company = 'Coca-Cola'").getResultList().size();
				Assert.assertEquals(19, size);
				
				// Update
				session.createQuery("update Employee set company = 'Apple' where company = 'Coca-Cola'")
						.executeUpdate();
				
				size = session.createQuery("from Employee where company = 'Apple'").getResultList().size();
				Assert.assertEquals(19, size);
				size = session.createQuery("from Employee where company = 'Coca-Cola'").getResultList().size();
				Assert.assertEquals(0, size);
				// HQL reads objects from Entities not directly from DB as before commit
				// for example first row should be the Apple but is still Coca-Cola in DB
				Employee empl = session.get(Employee.class, 1);
				Assert.assertNotEquals("Apple", empl.getCompany());
				Assert.assertEquals("Coca-Cola", empl.getCompany());
				
				session.getTransaction().commit();
			}
			
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				
				int size = session.createQuery("from Employee where company = 'Apple'").getResultList().size();
				Assert.assertEquals(19, size);
				size = session.createQuery("from Employee where company = 'Coca-Cola'").getResultList().size();
				Assert.assertEquals(0, size);
				
				// or with session.get()
				Employee empl = session.get(Employee.class, 1);
				Assert.assertEquals("Keri", empl.getFirstName());
				Assert.assertEquals("Lee", empl.getLastName());
				Assert.assertEquals("Apple", empl.getCompany());
				
				empl.setFirstName("Tomasz");
				empl.setLastName("Pierzchała");
				Assert.assertNotEquals("Keri", empl.getFirstName());
				Assert.assertNotEquals("Lee", empl.getLastName());
	
				session.getTransaction().commit();
			}
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
			
				// test last update commit
				Employee empl = session.get(Employee.class, 1);
				Assert.assertEquals("Tomasz", empl.getFirstName());
				Assert.assertEquals("Pierzchała", empl.getLastName());
				Assert.assertEquals("Apple", empl.getCompany());
				session.getTransaction().commit();
			}
			
			// READ
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				
				// Read (from ... where)
				int size = session.createQuery("from Employee where company = 'Apple'").getResultList().size();
				Assert.assertEquals(19, size);

				size = session.createQuery("from Employee where company = 'Pepsi'").getResultList().size();
				Assert.assertEquals(1, size);
				
				size = session.createQuery("from Employee where company = 'Google'").getResultList().size();
				Assert.assertEquals(4, size);
				
				size = session.createQuery("from Employee where company = 'Google' and company='Pepsi'").getResultList().size();
				Assert.assertEquals(0, size);
				
				// session.get
				int ID  = 13;
				Employee empl_hsql = (Employee) session.createQuery("from Employee where id = " + ID).getSingleResult();
				Assert.assertEquals(ID, empl_hsql.getId());
				
				Employee empl_sessionGet = session.get(Employee.class, ID);
				Assert.assertEquals(empl_hsql, empl_sessionGet);
				
				session.getTransaction().commit();
			}
			
			// DELETE
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				
				int BEFORE = session.createQuery("from Employee").getResultList().size();
				
				// Delete
				session.createQuery("delete from Employee where company = 'Pepsi'").executeUpdate();
				int size = session.createQuery("from Employee").getResultList().size();
				Assert.assertEquals(BEFORE-1, size);
				
				// before commit transaction deleted record is still in DB
				Employee shouldBeDeleted = session.get(Employee.class, PEPSI_ID);
				Assert.assertNotNull(shouldBeDeleted);
				
				session.getTransaction().commit();
			}
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
			
				Employee shouldBeDeleted = session.get(Employee.class, PEPSI_ID);
				// after tr.commit deleted record not exists in DB
				Assert.assertNull(shouldBeDeleted);
				
				session.getTransaction().commit();
			}
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
			
				// delete by id
				int SOME_RECORD_ID = 10;
				Employee exists = session.get(Employee.class, SOME_RECORD_ID);
				
				Assert.assertNotNull(exists);
				session.delete(exists);
				
				Employee nonExists = session.get(Employee.class, SOME_RECORD_ID);
				Assert.assertNull(nonExists);
				
				session.getTransaction().commit();
			}
		}
	}

}
