package com.example.hellowrold.controller;


import com.example.hellowrold.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

//这个类的所有方法返回的数据直接写给浏览器，（如果是对象转为json数据）
/*@ResponseBody
@Controller*/
@RestController
@Validated
@Slf4j
public class HelloController {


    @RequestMapping("/hello")
    public String hello() {
        return "hello world quick!";
    }


    @RequestMapping("validate")
    public String validateTest(@NotBlank(message = "地址不能为空！") String address) {
        return "success";
    }

    @RequestMapping("add")
    public String add(@Valid User user, BindingResult result) {
        log.info("user={}", user);
        return "success";
    }

    @RequestMapping("addTwo")
    // public String add(@Valid User user, BindingResult result) {
    public String addTwo(@Validated(User.Insert.class) User user, BindingResult bindingResult) {
        log.info("user={}", user);
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            log.info("errorMsg={}", errorMsg);
            return errorMsg;
        }
        return "success";
    }


    @RequestMapping("update")
    public String update(@Validated({User.Update.class}) User user,BindingResult result){
        log.info("user={}",user);
        if (result.hasErrors()) {
            String errorMsg = result.getFieldError().getDefaultMessage();
            log.info("errorMsg={}", errorMsg);
            return errorMsg;
        }
        return "success";
    }



}
