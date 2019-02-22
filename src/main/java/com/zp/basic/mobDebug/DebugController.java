/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.basic.mobDebug;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Date: 2019-02-22
 *
 * @author zhengpeng
 */
@RestController
public class DebugController {

    @RequestMapping("/debug/**")
    public String debug(HttpServletRequest request, HttpServletResponse response){
            String uri = request.getRequestURI();
        String realPath = uri.replaceFirst(".*debug", "");
        try {
            request.getRequestDispatcher(realPath).forward(request, response);
        } catch (Exception e) {

        }
        return  realPath;
    }

    @RequestMapping("/testDebug")
    public String testDebug(int id){

        return "";
    }
}
