package com.github.s1mplecc.gof.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyHandler implements InvocationHandler {
    private static final Logger log = LoggerFactory.getLogger(JdkDynamicProxyHandler.class);
    private Object proxied;

    public JdkDynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public static void main(String[] args) {
        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(
                IDBQuery.class.getClassLoader(),
                new Class[]{IDBQuery.class},
                new JdkDynamicProxyHandler(new DBQuery()));
        proxy.query();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Dynamic proxy {} class {}() method.", proxied.getClass().getSimpleName(), method.getName());
        Object invoke = method.invoke(proxied, args);
        log.info("result is {}.", invoke);
        return invoke;
    }
}
