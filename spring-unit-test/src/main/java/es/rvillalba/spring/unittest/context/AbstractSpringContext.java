package es.rvillalba.spring.unittest.context;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationToContext.class,
                webEnvironment = WebEnvironment.RANDOM_PORT)
@Getter
@Setter
@Slf4j
public abstract class AbstractSpringContext {

    @LocalServerPort
    private int randomPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseUrl = "http://localhost:";

    @PostConstruct
    public void initBaseUrl() {
        String baseurl = System.getProperty("baseurl");
        if (baseurl != null) {
            baseUrl = baseurl;
        } else if (!baseUrl.contains(":" + randomPort)) {
            baseUrl = baseUrl + randomPort;
        }
        log.info("BaseUrl used:" + baseUrl);
    }
}
