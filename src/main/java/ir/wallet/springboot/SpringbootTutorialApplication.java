package ir.wallet.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ir.wallet.springboot.persistence.repo")
@EntityScan("ir.wallet.springboot.persistence.model")
public class SpringbootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTutorialApplication.class, args);
	}

}
