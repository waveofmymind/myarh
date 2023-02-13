package wave.myarh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@EnableScheduling
public class MyarhApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MyarhApplication.class, args);

	}

}
