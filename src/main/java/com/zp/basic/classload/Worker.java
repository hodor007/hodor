package com.zp.basic.classload;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @Auther: zhengpeng
 * @Date: 2019/3/26 16:54
 * @Description:
 */
public class Worker {

    public static void main(String[] args) throws Exception {
        for (; ; ) {
            try {
                JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
                int status = javac.run(null, null, null, "-d", "/Users/zhengpeng/space/git/hodor/out/production/classes", "/Users/zhengpeng/space/git/hodor/src/main/java/com/zp/basic/classload/SimpleA.java");
                HotreplaceLoader loader = new HotreplaceLoader();
                Class<?> cls = loader.loadClass("com.zp.basic.classload.SimpleA");
//                Class cls =Class.forName("com.zp.basic.classload.SimpleA");  // 值不变，应该是之前加载过，如果加载过直接返回字节码
//                Object aService = cls.newInstance();
//                Method m = aService.getClass().getMethod("add", new Class[]{int.class, int.class});
//                Object count = m.invoke(aService, new Object[]{1, 1});
                ISimpleA as = (ISimpleA) cls.newInstance(); //不用接口会有类型转换异常,毕竟不是一个类加载器加载的
                int count = as.add(1, 1);
                System.out.println(String.valueOf(count));
            } catch (Exception e) {

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
