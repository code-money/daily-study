package cn.zyz.controller;

import cn.zyz.entity.SysLog;
import cn.zyz.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-03 19:50
 **/


//配置切面
@Component
@Aspect
public class LogAop {


    private Date visitTime; //开始时间
    private Class clazz;  //访问的类
    private Method method;   //访问的方法


    @Autowired
    HttpServletRequest request;

    @Autowired
    SysLogService service;


    //配置切点(要增强的方法)
    @Pointcut("execution(* cn.zyz.controller.*.*(..))")
    public void pt1(){}


    @Before("pt1()")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //获取当前的时间
        visitTime=new Date();
        //获取当前增强的类对象
        clazz=jp.getTarget().getClass();
        //获取访问的方法
        String methodName = jp.getSignature().getName();
        //获取方法的参数
        Object[] args = jp.getArgs();


        if (args.length==0 || args==null){
            //方法无参数
             method = clazz.getMethod(methodName);
        }else {
            //将方法的参数封装
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i]=args[i].getClass();
            }
            method=clazz.getMethod(methodName,classArgs);
        }
    }

    @After("pt1()")
    public void doAfter(JoinPoint jp){
        //获取访问的时长
        long time =new Date().getTime()-visitTime.getTime();

        String url = "";

        //获得url
        if (clazz!=null && method!=null&&clazz!=LogAop.class){
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping clazzAnnotation =(RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation!=null){
                //获取类上的路径
                String[] classValue = clazzAnnotation.value();
                //获取方法上的路径
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();

                    //获取完整的uri
                    url=classValue[0]+methodValue[0];
                    //获取访问的ip
                    String ip = request.getRemoteAddr();

                    //获取当前登陆的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    //获取当前登陆的对象
                    User user = (User)context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将相关信息封装到sysLog对象中
                    SysLog sysLog = new SysLog();
                    sysLog.setVisitTime(visitTime);
                    sysLog.setUsername(username);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setExecutionTime(time);
                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());

                    //调用Service完成操作
                    service.save(sysLog);
                }
            }
        }


    }
}



