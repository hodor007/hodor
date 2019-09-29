/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query;

import org.springframework.stereotype.Service;

import com.zp.tuniu.zfz.RequestDecorator;
import com.zp.tuniu.zfz.ResponseDecorator;
import com.zp.tuniu.zfz.query.vo.QueryPlaneReq;
import com.zp.tuniu.zfz.query.vo.QueryPlaneResp;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@Service
public class QueryPlaneServiceImpl implements IQueryService<QueryPlaneReq, QueryPlaneResp> {
    @Override
    public RequestDecorator<QueryReq, QueryPlaneReq> requestDecorator() {
        return QueryReq::getQueryPlaneReq;
    }

    @Override
    public QueryPlaneResp handle(QueryPlaneReq queryPlaneReq) {
        return new QueryPlaneResp("plane");
    }

    @Override
    public ResponseDecorator<QueryPlaneResp, QueryResp> responseDecorator() {
        return (queryPlaneResp, queryResp) -> queryResp.setQueryPlaneResp(queryPlaneResp);
    }
}
