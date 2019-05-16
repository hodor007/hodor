package com.zp.basic.csdn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JSONUtil {


    /**
     * 通过网络访问json并读取文件
     *
     * @param url:http://127.0.0.1:80/dashboard/dept_uuid.json
     * @return:json文件的内容
     */
    public static String loadJson(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 通过本地文件访问json并读取
     *
     * @param path：E:/svn/05.Hospital/templatedept_uuid.json
     * @return：json文件的内容
     */
    public static String ReadFile(String path) {
        String laststr = "";
        File file = new File(path);// 打开文件
        BufferedReader reader = null;
        try {
            FileInputStream in = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));// 读取文件
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException el) {
                }
            }
        }
        return laststr;
    }

    public static long isIPOK(String proxyHost, int proxyPort) throws Exception {
        try {
            long startTime = System.currentTimeMillis();
            URL url = new URL("http://weixin.sogou.com/");
            // 创建代理服务器
            InetSocketAddress addr = new InetSocketAddress(proxyHost, proxyPort);
            java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, addr); // http 代理
            // 如果我们知道代理server的名字, 可以直接使用
            URLConnection conn;
            conn = url.openConnection(proxy);
            // conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible;
            // MSIE 5.0; Windows NT; DigExt)");
            InputStream in = conn.getInputStream();
            /*
             * byte[] bytes = new byte[0]; bytes = new byte[in.available()];
             * in.read(bytes); String str = new String(bytes);
             * System.out.println(str);
             */
//			System.out.println(proxyHost + ":" + proxyPort + "-------OK");
            long endTime = System.currentTimeMillis();
//            System.out.println("完成时间"+(endTime - startTime)/1000);
            return (endTime - startTime) / 1000;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
//			System.out.println(proxyHost + ":" + proxyPort + "-------ERR");
            return 1000;
        }

    }

}
