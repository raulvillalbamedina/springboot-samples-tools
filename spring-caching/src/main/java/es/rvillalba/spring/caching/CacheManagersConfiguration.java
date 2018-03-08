package es.rvillalba.spring.caching;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.benmanes.caffeine.cache.CaffeineSpec;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "spring.cache.caffeines")
@Data
@EnableCaching
public class CacheManagersConfiguration {

    private HashMap<String, String> configurations = new HashMap<>();

    @Primary
    @Bean
    public CacheManager cacheManagerHalfAndHour() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setAllowNullValues(false);
        cacheManager.setCaffeineSpec(CaffeineSpec.parse(configurations.get("halfandhour")));
        return cacheManager;
    }

    @Bean
    public CacheManager cacheManagerOneDay() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setAllowNullValues(false);
        cacheManager.setCaffeineSpec(CaffeineSpec.parse(configurations.get("oneday")));
        return cacheManager;
    }
}
