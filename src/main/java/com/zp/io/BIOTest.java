package com.zp.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author :  pengzheng
 * create at:  2021-05-12  22:43
 * @description:
 *
 * 阻塞：accept、clientSocket.getInputStream().read
 * 一次只能处理一个连接，第一个一个连接处理未处理完，第二个客户端连接暂时处理不了
 *
 */
public class BIOTest {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接。。");
            //阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了。。");
            handler(clientSocket);

            /*new  Thread(new  Runnable()  {

            @Override
            public  void  run()  {
            try  {
            handler(clientSocket);
            }  catch  (IOException  e) {
            e.printStackTrace();
            }
            }
            }).start();*/
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];

        System.out.println("准备read。。");
//接收客户端的数据，阻塞方法，没有数据可读时就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕。。");
        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("HelloClient".getBytes());
        clientSocket.getOutputStream().flush();
    }


}
