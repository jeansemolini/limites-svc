package br.com.coffeeandit.limitessvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LimitesSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitesSvcApplication.class, args);
    }

}
