package es.rvillalba.spring.async;

import java.util.concurrent.Executor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.Data;

@RefreshScope
@Configuration
@ConfigurationProperties("async.executor")
@Data
public class AsyncExecutorConfiguration {

    private Integer corePoolSize;

    private Integer maxPoolSize;

    private Integer queueCapacity;

    private String threadNamePrefix;

    @Bean
    @Primary
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }
}
