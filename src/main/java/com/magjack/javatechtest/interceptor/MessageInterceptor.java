package com.magjack.javatechtest.interceptor;

import com.magjack.javatechtest.services.ReportPrinterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class MessageInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ReportPrinterService reporter;

    int messageCountDown = 50;
    boolean acceptMessgage = true;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        log.info("In PreHandle Method");

        return acceptMessgage;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex)
            throws Exception {

       messageCountDown--;

       log.info(String.valueOf(messageCountDown)+ " Messages to go");

       if(messageCountDown % 10 == 0){
           reporter.reportSales();
       }

       if(messageCountDown == 0){
           acceptMessgage=false;
           log.info("No more messages will be accepted");
           reporter.reportAdjustments();
       }

    }


}
