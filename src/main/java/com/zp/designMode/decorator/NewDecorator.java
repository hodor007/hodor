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
public class NewDecorator extends Decorator {


    public NewDecorator(Component component) {
        super(component);
    }

    public void biu() {
        System.out.println("biubiubiu");
        component.biu();
    }

}
