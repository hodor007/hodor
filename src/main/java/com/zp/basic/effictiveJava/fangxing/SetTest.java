package com.zp.basic.effictiveJava.fangxing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :  pengzheng
 * create at:  2020-05-28  17:13
 * @description:
 */
public class SetTest {

//    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
//        Set<E> result = new HashSet<>(s1);
//        result.addAll(s2);
//        return result;
//    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }


//    public static void swap(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i)));
//    }

    public static void main(String[] args) {
        Set<Integer>  integers =  new HashSet<>();
        Set<Double>   doubles  =  new HashSet<>();
        Set<Number>   numbers  =  union(integers, doubles);
    }

}