/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 * Date: 2019-01-08
 *
 * @author zhengpeng
 */
//@ComponentScan(basePackages = { "com.zp.spring" })  默认com.zp
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
