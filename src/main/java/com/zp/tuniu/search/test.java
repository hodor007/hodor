/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.search;

/**
 * TODO: description
 * Date: 2019-09-27
 *
 * @author zhengpeng
 */
public class test {

    public static void main(String[] args) {
        SearchListRequestDO searchListRequestDO = new SearchListRequestDO();
        searchListRequestDO.setName("哈哈");
        searchListRequestDO.setKey("key");
        SearchListRequest searchListRequest = SearchRequestBuilder.createBuilder(searchListRequestDO).build((UserRequestResolver<SearchListRequestDO>) (userRequest, searchListRequest1) -> {
            searchListRequest1.setKey(userRequest.getKey());
            return searchListRequest1;
        });
        System.out.println(searchListRequest);
    }

}
