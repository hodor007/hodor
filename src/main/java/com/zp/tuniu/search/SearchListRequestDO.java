/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.search;

import lombok.Data;

/**
 * TODO: description
 * Date: 2019-09-26
 *
 * @author zhengpeng
 */
public class SearchListRequestDO extends UserRequest {

    private int bookCity;

    private String key;

    public int getBookCity() {
        return bookCity;
    }

    public void setBookCity(int bookCity) {
        this.bookCity = bookCity;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SearchListRequestDO{" +
                "bookCity=" + bookCity +
                ", key='" + key + '\'' +
                '}';
    }
}
