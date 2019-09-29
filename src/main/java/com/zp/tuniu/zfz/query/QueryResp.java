/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query;

import com.zp.tuniu.zfz.query.vo.QueryHotelResp;
import com.zp.tuniu.zfz.query.vo.QueryPlaneResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
public class QueryResp {

    private QueryHotelResp queryHotelResp;

    private QueryPlaneResp queryPlaneResp;

    public QueryHotelResp getQueryHotelResp() {
        return queryHotelResp;
    }

    public void setQueryHotelResp(QueryHotelResp queryHotelResp) {
        this.queryHotelResp = queryHotelResp;
    }

    public QueryPlaneResp getQueryPlaneResp() {
        return queryPlaneResp;
    }

    public void setQueryPlaneResp(QueryPlaneResp queryPlaneResp) {
        this.queryPlaneResp = queryPlaneResp;
    }
}
