package cn.zyz.demo01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerInfo {
    public static void main(String[] args) throws Exception{
        //1.服务端监听8888端口
        ServerSocket socket = new ServerSocket(8888);
        //2.等待连接。。。
        Socket accept = socket.accept();
        //获取socket输入流，将图片从管道中读出
        BufferedInputStream inputStream = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("sgg_juc\\2.jpg"));
        byte[] bytes = new byte[1024];
        int len =0;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0,len);
        }
        outputStream.close();

        inputStream.close();
        accept.close();
        socket.close();
    }
}
