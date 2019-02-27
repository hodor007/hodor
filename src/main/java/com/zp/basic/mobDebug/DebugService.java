/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import org.springframework.stereotype.Component;

/**
 * Description:
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
@Component
public class DebugService {

    public  String get(StudentEntity studentEntity){
       return "get";
    }
}
