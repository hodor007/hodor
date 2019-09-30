/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.search;

import lombok.Data;

/**
 * TODO: description
 * Date: 2019-09-27
 *
 * @author zhengpeng
 */
public class SearchListRequest {

    private String name;

    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
