package com.zp;

/**
 * @author :  pengzheng
 * create at:  2020-03-07  17:20
 * @description:
 */
public class Test {

    public static void main(String[] args) {
////        System.out.println(1 << 2);
//        B b = new B();
//        System.out.println(b.getAge());
        String occupyTruckLength = "9.6";
        System.out.println( occupyTruckLength.length() - 1);
    }

    public static class A {
        private int age = 1;

        public int getAge() {
            return age;
        }

    }

    public static class B extends A {
        private int age = 2;

        public int getAge() {
            return age;
        }
    }

}