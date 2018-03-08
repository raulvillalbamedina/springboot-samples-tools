package es.rvillalba.spring.unittest.context;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Getter;
import lombok.Setter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationToContextWithMongo.class,
                webEnvironment = WebEnvironment.RANDOM_PORT)
@Getter
@Setter
public abstract class AbstractSpringWithMongoContext {

    @LocalServerPort
    private int randomPort;

    @Autowired
    private TestRestTemplate testRestTemplate;
}
