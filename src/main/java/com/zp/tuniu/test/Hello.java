/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.test;

/**
 * TODO: description
 * Date: 2019-10-27
 *
 * @author zhengpeng
 */
public class Hello {
    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        hello.sayHello("word. bingo!");
    }

    public void sayHello(String word) {
        System.out.println("hello, " + word);
    }
}
