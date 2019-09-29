/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query;

import com.zp.tuniu.zfz.query.vo.QueryHotelReq;
import com.zp.tuniu.zfz.query.vo.QueryPlaneReq;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
public class QueryReq {

    private QueryHotelReq queryHotelReq;

    private QueryPlaneReq queryPlaneReq;

    public QueryHotelReq getQueryHotelReq() {
        return queryHotelReq;
    }

    public void setQueryHotelReq(QueryHotelReq queryHotelReq) {
        this.queryHotelReq = queryHotelReq;
    }

    public QueryPlaneReq getQueryPlaneReq() {
        return queryPlaneReq;
    }

    public void setQueryPlaneReq(QueryPlaneReq queryPlaneReq) {
        this.queryPlaneReq = queryPlaneReq;
    }
}
