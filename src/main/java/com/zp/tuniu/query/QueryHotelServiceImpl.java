/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.query;

import org.springframework.stereotype.Service;

import com.zp.tuniu.RequestDecorator;
import com.zp.tuniu.ResponseDecorator;
import com.zp.tuniu.query.vo.QueryHotelReq;
import com.zp.tuniu.query.vo.QueryHotelResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@Service
public class QueryHotelServiceImpl implements IQueryService<QueryHotelReq, QueryHotelResp> {
    @Override
    public RequestDecorator<QueryReq, QueryHotelReq> requestDecorator() {
        return QueryReq::getQueryHotelReq;
    }

    @Override
    public QueryHotelResp handle(QueryHotelReq queryHotelReq) {
        return new QueryHotelResp("hotel");
    }

    @Override
    public ResponseDecorator<QueryHotelResp, QueryResp> responseDecorator() {
        return (queryHotelResp, queryResp) -> queryResp.setQueryHotelResp(queryHotelResp);
    }
}
