package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/***
 *  @auther xiadongming
 *  @date 2020/9/24
 *  @描述：
 **/
@EnableAsync
@Configuration
public class ThreadPool {

    @Bean
    public Executor asyncServiceExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//配置核心线程数
        executor.setMaxPoolSize(15);//配置最大线程数
        executor.setQueueCapacity(8);//配置队列大小
        executor.setThreadNamePrefix("threadpool-servece-");//线程的名称前缀
        //Caller_runs:不在新线程中执行任务，而是在调用者所在线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
