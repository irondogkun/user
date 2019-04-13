package com.pgleon.user;

import com.pgleon.mallspringboot.BaseApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication extends BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
