/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query.another;

import org.springframework.stereotype.Service;

import com.zp.tuniu.zfz.RequestDecorator;
import com.zp.tuniu.zfz.ResponseDecorator;
import com.zp.tuniu.zfz.query.vo.QueryHotelReq;
import com.zp.tuniu.zfz.query.vo.QueryHotelResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@Service
public class QueryAnoHotelServiceImpl implements IAnoQueryService<QueryHotelReq, QueryHotelResp> {

    @Override
    public RequestDecorator<QueryAnoReq, QueryHotelReq> requestDecorator() {
        return queryAnoReq -> new QueryHotelReq(queryAnoReq.getName());
    }

    @Override
    public QueryHotelResp handle(QueryHotelReq queryHotelReq) {
        return new QueryHotelResp(queryHotelReq.getName());
    }

    @Override
    public ResponseDecorator<QueryHotelResp, QueryAnoResp> responseDecorator() {
        return (queryHotelResp, queryAnoResp) -> queryAnoResp.setHotelName("hotel == " + queryHotelResp.getName());
    }
}
