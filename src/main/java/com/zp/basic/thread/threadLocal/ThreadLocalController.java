package com.zp.basic.thread.threadLocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: zhengpeng
 * @Date: 2019/5/16 11:11
 * @Description:
 */
@RestController
@RequestMapping("/thread")
public class ThreadLocalController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testHello(HttpServletRequest request){
        String result = ThreadLocalTest.getThreadLocal();
        ThreadLocalTest.setThreadLocal("好的");
        result = ThreadLocalTest.getThreadLocal();
        return result;
    }

}
