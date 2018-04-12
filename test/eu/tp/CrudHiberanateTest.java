package eu.tp;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

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
		fail("Not yet implemented");
	}

}
