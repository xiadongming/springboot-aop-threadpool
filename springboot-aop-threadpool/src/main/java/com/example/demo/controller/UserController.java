package com.example.demo.controller;

import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 *  @auther xiadongming
 *  @date 2020/9/24
 *  @描述：
 **/
@RestController
@RequestMapping("/dev")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/pool", method = RequestMethod.GET)
    public String webController() {
        System.out.println("controller线程= " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getPoolName();
    }


    @RequestMapping(value = "/pool2", method = RequestMethod.GET)
    public String webController2() {
        return userService.getPoolName2();
    }
}
