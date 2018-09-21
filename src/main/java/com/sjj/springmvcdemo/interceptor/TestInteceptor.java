package com.sjj.springmvcdemo.interceptor;


import com.sjj.springmvcdemo.other.ConcurrentLimit;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TestInteceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        if (handlerMethod.getMethod().isAnnotationPresent(ConcurrentLimit.class)) {
            System.out.println("is concurrentlimit preXXXXXX");
        }
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        if (handlerMethod.getMethod().isAnnotationPresent(ConcurrentLimit.class)) {
            System.out.println("is cocurrentlimit postXXXXXXXX");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        if (handlerMethod.getMethod().isAnnotationPresent(ConcurrentLimit.class)) {
            System.out.println("is cocurrentlimit afterCompletion");
        }
    }
}
