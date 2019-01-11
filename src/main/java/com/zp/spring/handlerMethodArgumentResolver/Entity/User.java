/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.spring.handlerMethodArgumentResolver.Entity;

/**
 * Description:
 * Date: 2019-01-11
 *
 * @author zhengpeng
 */
public class User {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
