package es.rvillalba.spring.unittest.context;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "es.rvillalba.spring",
                       exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class, MongoAutoConfiguration.class})
@EnableWebMvc
@EnableAsync
@ActiveProfiles("dev")
@RestController
public class ApplicationToContext {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationToContext.class, args);
    }

    @RequestMapping("/")
    public String sampleRest() {
        return "success (id: " + UUID.randomUUID().toString().toUpperCase() + ")";
    }
}
