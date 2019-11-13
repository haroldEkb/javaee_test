package com.harold.util;

import javax.interceptor.InvocationContext;

public class Logger {
    public Object printLog(InvocationContext context) throws Exception {
        System.out.println("[LOG]: User used method " + context.getMethod().getName());
        return context.proceed();
    }
}
