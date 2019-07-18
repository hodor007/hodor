/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.designMode.decorator;

/**
 * TODO: description
 * Date: 2019-07-12
 *
 * @author zhengpeng
 */
public class Test {

    public static void main(String[] args) {
        new NewDecorator(new ConcretComponent()).biu();
    }

}
