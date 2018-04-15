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
			try (Session session = factory.getCurrentSession()) {

				
				List<Employee> empList = new ArrayList<Employee>();
				empList.add(new Employee("All", "Bundy", "Coca-Cola"));
				empList.add(new Employee("Tom", "Me", "Coca-Cola"));
				empList.add(new Employee("Mike", "Nord", "Pepsi"));

				session.beginTransaction();
				int size = session.createQuery("from Employee").getResultList().size();
				Assert.assertEquals(21, size);
				
				// Create
				empList.forEach(session::save);
				//
				size = session.createQuery("from Employee").getResultList().size();
				Assert.assertEquals(24, size);

				// Update
				session.createQuery("update Employee set company = 'Coca-Cola' where company = 'Apple'")
						.executeUpdate();

				
				// Read (from ... where)
				size = session.createQuery("from Employee where company = 'Pepsi'").getResultList().size();
				Assert.assertEquals(1, size);
				
				// Delete
				// session.createQuery("delete from Employee").executeUpdate();
				// empList.forEach(session::save);

			}
		}
	}

}
