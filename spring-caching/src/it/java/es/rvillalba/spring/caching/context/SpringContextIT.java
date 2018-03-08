package es.rvillalba.spring.caching.context;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

import es.rvillalba.spring.caching.context.sample.SampleMultipleCacheUse;
import es.rvillalba.spring.unittest.context.AbstractSpringContext;

import lombok.Data;

@Data
@EnableCaching
public class SpringContextIT extends AbstractSpringContext {

    @Autowired
    private SampleMultipleCacheUse sampleMultipleCacheUse;

    @Autowired
    private CacheManager cacheManagerHalfAndHour;

    @Autowired
    @Qualifier("cacheManagerOneDay")
    private CacheManager cacheManagerOneDay;

    @Test
    public void testOneDayCache() {
        System.out.println("init" + sampleMultipleCacheUse.toString());
        sampleMultipleCacheUse.methodOneDay("a");
        System.out.println("one" + sampleMultipleCacheUse.toString());
        sampleMultipleCacheUse.methodOneDay("a");
        sampleMultipleCacheUse.methodOneDay("a");
        System.out.println("three" + sampleMultipleCacheUse.toString());
    }

    @Test
    public void testHalfAndHourCache() {
        System.out.println("init" + sampleMultipleCacheUse.toString());
        sampleMultipleCacheUse.methodHalfAndHour("a");
        System.out.println("one" + sampleMultipleCacheUse.toString());
        sampleMultipleCacheUse.methodHalfAndHour("a");
        sampleMultipleCacheUse.methodHalfAndHour("a");
        System.out.println("three" + sampleMultipleCacheUse.toString());
    }
}
