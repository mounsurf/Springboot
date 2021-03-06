package com.learn.springbootdemo.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常返回信息
 */
public class CustomizeExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        String msg = ex.getMessage();
        try {
            response.addHeader("Content-Type", "text/html; charset=UTF-8");

            if (ex instanceof NoHandlerFoundException) {
                //需要配合application.properties中的spring.mvc.throw-exception-if-no-handler-found=true使用
                response.getWriter().append("自定义异常处理!!! \n").append("找不到路由").flush();
            } else {
                response.getWriter().append("自定义异常处理!!! \n").append(msg).flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
