/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

/**
 * Description:
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
public class LogSoldier {

    public static RequestLogs getRequestLogs() {
        RequestLogs result;
        try {
            result = SpringTool.getApplicationContext().getBean("requestLogs", RequestLogs.class);
        } catch (Exception e) {
            result = null;
        }
            return result;
    }
}
