package cn.zyz.demo01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ClientInfo {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("sgg_juc\\1.jpg"));
        //获取socket输出流，将图片写入到通道中
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len =0;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.flush();
        bis.close();
        socket.shutdownOutput();
        bos.close();
        socket.close();
    }
}
