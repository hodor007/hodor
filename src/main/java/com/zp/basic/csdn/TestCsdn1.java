package com.zp.basic.csdn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhengpeng
 * @Date: 2019/3/20 22:08
 * @Description:
 */
public class TestCsdn1 {

    //存代理ip，无效剔除，不足补充，多线程同步刷csdn

    private static ExecutorService executorService = new ThreadPoolExecutor(32, 64, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
    ;


    public static void main(String[] args) {

        executorService.execute(new ProxyUtil());
        while (true) {
            if (ProxyUtil.proxys != null) {
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("开始刷");
        for (int i = 1; i < 6; i++) {
            execute(i);
        }

    }

    private static void execute(int temp) {
        try {
            Thread.sleep(temp * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    IpProxy ipProxy = (IpProxy) ProxyUtil.proxys.poll();
                    String address = "https://blog.csdn.net/m0_37300406/article/details/87204742";
                    System.setProperty("http.maxRedirects", "50");
                    System.getProperties().setProperty("proxySet", "true");
                    System.getProperties().setProperty("http.proxyHost", ipProxy.getIp());
                    System.getProperties().setProperty("http.proxyPort", ipProxy.getPort());
                    Document doc = null;
                    try {
                        doc = Jsoup.connect(address)
                                .userAgent("Mozilla")
                                .cookie("auth", "token")
                                .timeout(3000)
                                .get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (doc != null) {
                        System.out.println("ok");
                        ProxyUtil.proxys.offer(ipProxy);
                    }
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

}
