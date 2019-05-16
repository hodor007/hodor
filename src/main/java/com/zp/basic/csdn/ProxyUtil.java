package com.zp.basic.csdn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class ProxyUtil  implements  Runnable{

    public static ConcurrentLinkedQueue proxys;


    public static void init() {
        System.out.println("初始化开始");
        String jsonRes = "[" + JSONUtil.loadJson("https://raw.githubusercontent.com/fate0/proxylist/master/proxy.list").replace("}", "},") + "]";
        JSONArray jsonArray = JSONArray.fromObject(jsonRes);
        List<Object> os = Arrays.asList(jsonArray.toArray());
        List<IpProxy> list = os.stream().map(o -> {
            JSONObject jsonObj = JSONObject.fromObject(o);
            return new IpProxy(jsonObj.get("port").toString(), jsonObj.get("host").toString());
        }).collect(Collectors.toList());
        proxys = new ConcurrentLinkedQueue(list);
        System.out.println("初始化结束");
//        int threadCounts = 3;
////		 启动线程池
//        ExecutorService exec = Executors.newFixedThreadPool(threadCounts);
//        List<Callable<Object>> callList = new ArrayList<Callable<Object>>();
////		分割list
//        int len = os.size() / threadCounts;
//        for (int i = 0; i < threadCounts; i++) {
//            final List<Object> subOs = os.subList(i * len, len * (i + 1) > os.size() ? os.size() : len * (i + 1));
//            callList.add(new Callable<Object>() {
//                public Object call() throws Exception {
//                    for (int i = 0; i < subOs.size(); i++) {
//                        JSONObject jsonObj = JSONObject.fromObject(subOs.get(i));
////                        isIpOk(jsonObj.get("host").toString(), jsonObj.get("port").toString(), 1);
//                    }
//                    return 0;
//                }
//
//            });
//        }
//        try {
//            List<Future<Object>> futureList = exec.invokeAll(callList);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
////		 等待所有线程结束shutdown
//        exec.shutdown();
//        System.out.println("初始化结束");
    }

    @Override
    public void run() {
        while (true){
            if(proxys==null || proxys.size()<=50){
                init();
            }
        }
    }


//    public long ipTime(String proxyHost, int proxyPort) throws Exception {
//        try {
//            long startTime = System.currentTimeMillis();
//            URL url = new URL("http://weixin.sogou.com/");
//            // 创建代理服务器
//            InetSocketAddress addr = new InetSocketAddress(proxyHost, proxyPort);
//            java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, addr); // http 代理
//            // 如果我们知道代理server的名字, 可以直接使用
//            URLConnection conn;
//            conn = url.openConnection(proxy);
//            // conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible;
//            // MSIE 5.0; Windows NT; DigExt)");
//            InputStream in = conn.getInputStream();
//            /*
//             * byte[] bytes = new byte[0]; bytes = new byte[in.available()];
//             * in.read(bytes); String str = new String(bytes);
//             * System.out.println(str);
//             */
////			System.out.println(proxyHost + ":" + proxyPort + "-------OK");
//            long endTime = System.currentTimeMillis();
////            System.out.println("完成时间"+(endTime - startTime)/1000);
//            return (endTime - startTime) / 1000;
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            // e.printStackTrace();
////			System.out.println(proxyHost + ":" + proxyPort + "-------ERR");
//            return 1000;
//        }
//
//    }


}
