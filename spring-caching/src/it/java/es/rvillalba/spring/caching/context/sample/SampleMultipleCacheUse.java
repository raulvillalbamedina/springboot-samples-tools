package es.rvillalba.spring.caching.context.sample;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@CacheConfig(cacheNames = "sampleMultipleCacheUse")
@Data
public class SampleMultipleCacheUse {

    private int cacheManagerOneDay = 0;

    private int cacheManagerHalfAndHour = 0;

    @Cacheable(cacheManager = "cacheManagerHalfAndHour")
    public String methodHalfAndHour(String param) {
        System.out.println("cacheManagerHalfAndHour");
        cacheManagerHalfAndHour = cacheManagerHalfAndHour + 1;
        return "yes";
    }

    @Cacheable(cacheManager = "cacheManagerOneDay")
    public String methodOneDay(String param) {
        System.out.println("cacheManagerOneDay");
        cacheManagerOneDay = cacheManagerOneDay + 1;
        return "yes";
    }
}
