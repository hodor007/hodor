/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
@Component
public class DebugService1 {

    @Autowired
    DebugService debugService;
    public  String test(StudentEntity studentEntity){
        debugService.get(studentEntity);
        return "test";
    }
}
