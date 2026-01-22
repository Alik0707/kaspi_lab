package com.example.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

// com.example.product.config.AsyncConfig.java
@Configuration
public class AsyncConfig {

    @Bean(name = "productAsyncExecutor")
    public Executor productAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);          // базовое количество потоков
        executor.setMaxPoolSize(20);          // максимум при перегрузке
        executor.setQueueCapacity(150);       // очередь перед созданием доп. потоков
        executor.setThreadNamePrefix("Prod-Async-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
