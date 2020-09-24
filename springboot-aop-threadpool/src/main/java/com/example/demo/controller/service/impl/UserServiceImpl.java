package com.example.demo.controller.service.impl;

import com.example.demo.controller.service.IUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/***
 *  @auther xiadongming
 *  @date 2020/9/24
 *  @描述：
 **/
@Service
public class UserServiceImpl implements IUserService {
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
}
