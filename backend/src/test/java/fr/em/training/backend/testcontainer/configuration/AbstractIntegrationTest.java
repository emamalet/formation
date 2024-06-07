package fr.em.training.backend.testcontainer.configuration;

import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class AbstractIntegrationTest {

	static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"));

	static {
		postgres.start();
	}

	@BeforeAll
	static void beforeAll() {
		System.setProperty("spring.datasource.url", "jdbc:tc:postgresql:16:///test");
		System.setProperty("spring.datasource.username", postgres.getUsername());
		System.setProperty("spring.datasource.password", postgres.getPassword());
	}

}
