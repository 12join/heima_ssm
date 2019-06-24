package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Syslog;
import cn.itcast.ssm.service.SyslogService;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

//配置日志的类
@Component
@Aspect//表示当前类是一个切面类
public class LogAop {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SyslogService syslogService;
    //访问的时间
     private Date visitTime;
   //访问的ip
    private String ip;

    @Before("execution(*  cn.itcast.ssm.controller.*.*(..))")
    public void before(JoinPoint jp){
        //获取当前时间
        visitTime=new Date();
        //获取ip地址
         ip = request.getRemoteAddr();
    }

    @After("execution(*  cn.itcast.ssm.controller.*.*(..))")
    public void after(JoinPoint jp) throws Exception {
        //获取执行的时间
        long executionTime=new Date().getTime()-  visitTime.getTime();
        //获取访问uri
        String url = request.getRequestURI();
        //获取访问的方法
        MethodSignature signature = (MethodSignature) jp.getSignature();
        String method = signature.getName();
        //获取用户名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Syslog syslog=new Syslog();
        syslog.setVisitTime(visitTime);
        syslog.setUsername(username);
        syslog.setIp(ip);
        syslog.setUrl(url);
        syslog.setExecutionTime(executionTime);
        syslog.setMethod(method);

        //保存日志
        syslogService.save(syslog);
    }

}
