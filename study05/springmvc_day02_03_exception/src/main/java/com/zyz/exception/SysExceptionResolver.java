package com.zyz.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 11:30
 **/

//异常处理器
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
     SysException ex = null;
     if (e instanceof SysException){
         ex=(SysException)e;
     }else {
         ex = new SysException("系统正在维护...");
     }
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.addObject("errorMsg",ex.getMessage());
     modelAndView.setViewName("error");
     return modelAndView;
    }
}



