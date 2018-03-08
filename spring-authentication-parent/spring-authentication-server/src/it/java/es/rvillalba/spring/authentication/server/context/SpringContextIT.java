package es.rvillalba.spring.authentication.server.context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.rvillalba.spring.authentication.server.Oauth2AuthenticationServerApplication;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Oauth2AuthenticationServerApplication.class,
                webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringContextIT {

    @LocalServerPort
    private int randomPort;

    @Test
    public void testCallWithOAuth2RestTemplate() {
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        // curl -XPOST -k spring:springsecret@localhost:8080/oauth/token -d grant_type=password -d username=springTest -d password=springtestsecret
        resourceDetails.setUsername("springTest");
        resourceDetails.setPassword("springtestsecret");
        resourceDetails.setAccessTokenUri(String.format("http://localhost:%d/oauth/token", randomPort));
        resourceDetails.setClientId("spring");
        resourceDetails.setClientSecret("springsecret");
        resourceDetails.setGrantType("password");
        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        String user = restTemplate.getForObject(String.format("http://localhost:%d/authentication/user", randomPort), String.class);
        Assert.assertTrue(user.contains("tokenValue"));
    }
}
