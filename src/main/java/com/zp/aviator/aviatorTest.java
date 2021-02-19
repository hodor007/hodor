package com.zp.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;

/**
 * @author :  pengzheng
 * create at:  2021-02-05  17:40
 * @description:
 */
public class aviatorTest {

    public static void main(String[] args) {
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        HashMap paramMap= new HashMap();
        paramMap.put("a",100.3);
        paramMap.put("b",45);
        paramMap.put("c",-199.100);
        Boolean result = (Boolean) compiledExp.execute(paramMap);
        System.out.println(result);
    }

}