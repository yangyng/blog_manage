package com.yangy.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author yangy
 */
@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class BlogManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogManageApplication.class, args);
    }

}
