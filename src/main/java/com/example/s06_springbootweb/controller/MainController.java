package com.example.s06_springbootweb.controller;

import com.example.s06_springbootweb.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @Value("${test.name}")
    String name;

    @RequestMapping("/login")
    public String login(HttpSession session){
        // 新增输出字段
        MDC.put("reqId", session.getId());

        // 1.使用slf4j的Logger：LoggerFactory方式，切记这里不需要new，直接使用
        Logger logger = LoggerFactory.getLogger(MainController.class);
        logger.info("使用LoggerFactory方式：有人访问了Login页面");
        // 使用@Slf4j注解方式
        log.info("使用注解方式：有人访问了Login页面");
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/student")
    @ResponseBody
    public Student student(){
        Student student = new Student();
        student.setName("小明");
        student.setSex("男");
        student.setSid(10);
        return student;
    }
}
