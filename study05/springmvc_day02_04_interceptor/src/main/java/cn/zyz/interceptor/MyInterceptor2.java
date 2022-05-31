package cn.zyz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 12:00
 **/

public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 预处理   controller方法执行前执行
     * return true 放行，执行下一个拦截器，如果没有，执行controller中的方法
     * return false 不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了...前222");
        return true;
    }

    /**
     * 后处理方法  controller执行完再执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器执行了...后222");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }


    /**
     * 前端相应成功后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器执行了...after222");

    }
}



