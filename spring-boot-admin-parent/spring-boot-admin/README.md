# Spring Boot Admin
## Admin Server Setup
1. To configure mail notification, required add to `application.properties` this information:
    ```
    spring.mail.host=smtp.xxxx.com
    spring.mail.port=XXXX
    spring.mail.username=user@user.com
    spring.mail.password=password
    spring.boot.admin.notify.mail.from=from@from.com
    spring.boot.admin.notify.mail.to=to@to.com
    spring.boot.admin.notify.mail.subject=(id:#{application.id}) is #{to.status}
    spring.boot.admin.notify.mail.text=(id:#{application.id})\nstatus changed from #{from.status} to #{to.status}\n\n#{application.healthUrl}
    
    ```
    SpEL-expressions are supported to `spring.boot.admin.notify.mail.subject` and `spring.boot.admin.notify.mail.text`
2. To configure custom port , add to `application.properties` `server.port=9089` , this application has for default 9089.
3. Custom interval in ms to update status of application or invoked /health-enpoints , at default both define 300000ms.
    ```
    spring.boot.admin.monitor.period=300000
    spring.boot.admin.monitor.status-lifetime=300000
    ```
4. Exist others configurations , like send slack notification , options to spring boot admin server, etc... For learn more about 
spring boot admin server, [tutorial 1](http://codecentric.github.io/spring-boot-admin/1.5.5/#getting-started),
[tutorial 2](http://www.baeldung.com/spring-boot-admin), [Spring boot Admin git repository](https://github.com/codecentric/spring-boot-admin).
##Setting Up a Client
 For default SPRING has active client to register at Spring boot Admin. 
 1. For add new service to Spring boot admin, required add dependency at local if no has like parent `springboot-samples-tools`
     ```
     <dependency>
         <groupId>de.codecentric</groupId>
         <artifactId>spring-boot-admin-starter-client</artifactId>
         <version>1.5.4</version>
     </dependency>
     ```
     Now add to `application.properties` , `spring.boot.admin.url=http://url-or-ip:port` this is a url where 
     Spring boot admin is deployed and `management.security.enabled=false`.
     
     
## Default active services to Spring boot Admin server and client
1. Mail notifications to your@mail.com
2. port 8090
 