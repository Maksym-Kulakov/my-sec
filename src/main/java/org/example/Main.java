package org.example;

import org.example.config.AppConfig;
import org.example.model.User;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        User max = new User();
        max.setName("max");
        max.setAge(30);
        max.setPassword("1234");
        max.setEmail("max@gmail.com");
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.create(max);
    }
}
