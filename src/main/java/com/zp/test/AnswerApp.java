package com.zp.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author :  pengzheng
 * create at:  2020-10-20  10:30
 * @description:
 */
public class AnswerApp {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        System.out.println("修改前...");
        System.out.println(Entity.MODEL_NAME);
        System.out.println(Entity.nums);
        Entity entity = new Entity("Answer");
        System.out.println(entity.getName());
        System.out.println();

        Field[] fields = Entity.class.getDeclaredFields();
        for (Field field : fields) {
            // 通过反射修改常量值
            if ("MODEL_NAME".equals(field.getName())) {
                Field modifiers = Field.class.getDeclaredField("modifiers");
                modifiers.setAccessible(true);
                modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(null, 520);
            }

            // 通过反射修改静态变量值
            else if ("nums".equals(field.getName())) {
                field.set(null, 98);
            }

            // 通过反射修改对象属性值
            else if ("name".equals(field.getName())) {
                field.setAccessible(true);
                field.set(entity, "AnswerAIL");
            } else {
                System.out.println(field.getName());
            }
        }

        System.out.println("修改后...");
        System.out.println(Entity.MODEL_NAME);
        System.out.println(Entity.nums);
        System.out.println(entity.getName());
    }

}