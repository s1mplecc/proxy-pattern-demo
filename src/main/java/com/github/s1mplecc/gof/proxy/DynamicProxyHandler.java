package com.github.s1mplecc.gof.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private static final Logger log = LoggerFactory.getLogger(DynamicProxyHandler.class);
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Dynamic proxy {} class {}() method.", proxied.getClass().getSimpleName(), method.getName());
        Object invoke = method.invoke(proxied, args);
        log.info("result is {}.",invoke);
        return invoke;
    }
}
