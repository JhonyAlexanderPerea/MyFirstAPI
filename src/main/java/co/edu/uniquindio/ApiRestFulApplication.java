package co.edu.uniquindio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("co.edu.uniquindio")
//@EntityScan("co.edu.uniquindio.model")
//@EnableJpaRepositories("co.edu.uniquindio.repository")
public class ApiRestFulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestFulApplication.class, args);
	}

}
