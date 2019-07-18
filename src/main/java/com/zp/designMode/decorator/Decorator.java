/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.designMode.decorator;

/**
 * description:装饰类  一个声明
 * Date: 2019-07-12
 *
 * @author zhengpeng
 */
public class Decorator implements Component {

    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void biu() {
        this.component.biu();
    }
}
