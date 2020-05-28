package com.zp.ymm.JavaPoet;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

/**
 * @author :  pengzheng
 * create at:  2020-05-18  10:14
 * @description:
 */
public class HowToJavaPoetDemo {

    public static void main(String[] args) {
        // `JavaFile` 代表 Java 文件
        JavaFile javaFile = JavaFile.builder("com.zp.ymm.JavaPoet",
                // TypeSpec 代表一个类
                TypeSpec.classBuilder("Clazz")
                        // 给类添加一个属性
                        .addField(FieldSpec.builder(int.class, "mField", Modifier.PRIVATE)
                                .build())
                        // 给类添加一个方法
                        .addMethod(MethodSpec.methodBuilder("method")
                                .addModifiers(Modifier.PUBLIC)
                                .returns(void.class)
                                .addStatement("System.out.println(str)")
                                .build())
                        .build())
                .build();

        System.out.println(javaFile.toString());
    }

}