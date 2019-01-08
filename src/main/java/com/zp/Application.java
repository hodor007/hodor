/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * Date: 2019-01-08
 *
 * @author zhengpeng
 */
//@ComponentScan(basePackages = { "com.zp.spring" })
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
