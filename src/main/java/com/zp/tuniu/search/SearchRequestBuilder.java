/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.search;

/**
 * description: requestDO->request的转换
 * Date: 2019-09-26
 *
 * @author zhengpeng
 */
public class SearchRequestBuilder<T extends UserRequest> {

    private SearchListRequest searchListRequest;

    private T userRequest;

    private SearchRequestBuilder(T userRequest) {
        this.userRequest = userRequest;
        searchListRequest = new SearchListRequest();
        init(userRequest);
    }

    private void init(T userRequest) {
        searchListRequest.setName(userRequest.getName());
    }

    public static <T extends UserRequest> SearchRequestBuilder createBuilder(T userRequest) {
        return new SearchRequestBuilder<>(userRequest);
    }

    public SearchRequestBuilder<T> addProductSearchSupport(int currentPage, int limit) {
//        searchListRequest.setCurrentPage
//        searchListRequest.setLimit
        return this;
    }

    public SearchListRequest build(UserRequestResolver<T> resolver) {
        if (resolver == null) {
            return searchListRequest;
        }
        return resolver.build(userRequest,searchListRequest);
    }

}
