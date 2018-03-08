package es.rvillalba.spring.unittest.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "es.rvillalba.spring",
                       exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
@EnableWebMvc
@EnableAsync
@ActiveProfiles("dev")
public class ApplicationToContextWithMongo {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationToContextWithMongo.class, args);
    }
}
