/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query.another;

import org.springframework.stereotype.Service;

import com.zp.tuniu.zfz.RequestDecorator;
import com.zp.tuniu.zfz.ResponseDecorator;
import com.zp.tuniu.zfz.query.vo.QueryPlaneReq;
import com.zp.tuniu.zfz.query.vo.QueryPlaneResp;

/**
 * TODO: description
 * Date: 2019-07-19
 *
 * @author zhengpeng
 */
@Service
public class QueryAnoPlaneServiceImpl implements IAnoQueryService<QueryPlaneReq, QueryPlaneResp> {
    @Override
    public RequestDecorator<QueryAnoReq, QueryPlaneReq> requestDecorator() {
        return queryAnoReq -> new QueryPlaneReq(queryAnoReq.getName());
    }

    @Override
    public QueryPlaneResp handle(QueryPlaneReq queryPlaneReq) {
        return new QueryPlaneResp(queryPlaneReq.getName());
    }

    @Override
    public ResponseDecorator<QueryPlaneResp, QueryAnoResp> responseDecorator() {
        return (queryPlaneResp, queryAnoResp) -> queryAnoResp.setPlaneName("plane == "+queryPlaneResp.getName());
    }
}
