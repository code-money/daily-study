package com.zyz.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-02 22:27
 **/

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String filename = req.getParameter("filename");

        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型
        String mimeType = servletContext.getMimeType(filename);//获取文件mime类型
        resp.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式
        resp.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流数据写出到输出流
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[2048];
        int len=0;
        while ((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}



