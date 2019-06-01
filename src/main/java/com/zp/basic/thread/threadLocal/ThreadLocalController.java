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
    public String testHello(HttpServletRequest request) {
        ThreadLocalTest.setThreadLocal("好的？");
        String result = ThreadLocalTest.getThreadLocal();
        ThreadLocalTest1.setThreadLocal("不好");
        String result1 = ThreadLocalTest1.getThreadLocal();
        return result + "==" + result1;
    }

}
