# SPRING-CACHING

This module configure the spring cache implementation. More info at 

	<https://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html> 
	<https://spring.io/guides/gs/caching/>

## Technologies

*   spring-boot-starter-cache. Add cache interfaces from spring.
*   caffeine. By default we use caffeine cache (before called Guava).

## Profiles maven to select the cache implementation

Whe have in pom.xml some profiles with needed dependencies to change the cache implementation. The profile caffeine is active by default but you can compile with other profile to get other implementation.

Sample maven execution:

	mvn clean install -Pinfinispan
	
The base of this module is an spring-boot-sample from Github 

	<https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-cache>

If you change the implementation, do you need add to your application.properties the specific properties. Yo can find this properties at 
	
	<https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html>

## Disabling cache

If you need to disable the cache add to application.properties this line:

	spring.cache.type=none
	
## Our caffeine configurations cache

We have 2 beans with caffeine configuration now. One with one day and one with 30 minutes. The name of cacheManager are cacheManagerHalfAndHour and cacheManagerOneDay. By default spring are using cacheManagerHalfAndHour.

If you need to use other add "cacheManager" in your method:

Sample:

    @Cacheable(keyGenerator = "sampleKeyGenerator",  cacheManager = "cacheManagerOneDay")