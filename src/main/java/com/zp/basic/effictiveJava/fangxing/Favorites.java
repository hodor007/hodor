package com.zp.basic.effictiveJava.fangxing;

import java.util.*;

/**
 * @author :  pengzheng
 * create at:  2020-06-01  15:37
 * @description:  effective java -- 33
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(List.class, Collections.singletonList("11"));
        List list = favorites.getFavorite(List.class);
        System.out.println(list);
    }

}