package com.example.demo.service.impl;

import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

/***
 *  @auther xiadongming
 *  @date 2020/9/24
 *  @描述：
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private Executor asyncServiceExecutor;

    @Async
    @Override
    public String getPoolName() {
        String threadName = Thread.currentThread().getName();
        //System.out.println("threadName= " + threadName);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return threadName;
    }


    @Override
    public String getPoolName2() {
        asyncServiceExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("通过execute()方法调用：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return "success";
    }

    @Override
    public String getPoolName3() {
        return "success";
    }
}
