/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.Jdk1d8;

/**
 * Description:
 * Date: 2019-02-20
 *
 * @author zhengpeng
 */
public class TestMain extends AssignUtil {

    public static void main(String[] args) {
        Request request = new Request("tony", "男");
        Response response = new Response();
        TestMain testMain = new TestMain();
        //java8 Lambda表达式
        testMain.invokeFunction(request.getName(),response::setName);
//        testMain.invokeFunction(request.getName(),(String name)->response.setName(name));
        //匿名内部类
//        testMain.invokeFunction1(request.getName(), new Function<String>() {
//            @Override
//            public void invoke(String s) {
//                response.setName(request.getName());
//            }
//        });
        System.out.println(response.getName());
    }

    private static class Request {
        private String name;
        private String gender;

        public Request(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    private static class Response {
        private String name;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

}
