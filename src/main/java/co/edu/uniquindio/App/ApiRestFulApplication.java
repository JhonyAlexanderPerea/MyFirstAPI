package co.edu.uniquindio.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("co.edu.uniquindio")
@EntityScan("co.edu.uniquindio.model")
@EnableJpaRepositories("co.edu.uniquindio.repository")
public class ApiRestFulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestFulApplication.class, args);
	}

}
