/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.tuniu.zfz.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zp.tuniu.zfz.query.QueryReq;
import com.zp.tuniu.zfz.query.QueryResp;
import com.zp.tuniu.zfz.query.another.QueryAnoReq;
import com.zp.tuniu.zfz.query.another.QueryAnoResp;
import com.zp.tuniu.zfz.query.execute.IService;

/**
 * TODO: description
 * Date: 2019-07-18
 *
 * @author zhengpeng
 */
@RestController
@RequestMapping("/tuniu")
public class Controller {


    @Autowired
    private IService iService;

    @RequestMapping("/execute")
    public QueryResp execute() {
        return iService.queryResource(new QueryReq());
    }

    @RequestMapping("/execute1")
    public QueryAnoResp execute1() {
        return iService.queryResource(new QueryAnoReq("name"));
    }
}
