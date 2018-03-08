package es.rvillalba.spring.authentication.client;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.context.request.RequestContextListener;

import lombok.extern.slf4j.Slf4j;

@ConditionalOnProperty(name = "security.oauth2.resource.userInfoUri",
                       matchIfMissing = false)
@EnableWebSecurity
@EnableResourceServer
@Slf4j
public class AuthenticationClientConfig {

    @PostConstruct
    public void post() {
        log.info("Oauth2 Authentication client enabled!!!");
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
