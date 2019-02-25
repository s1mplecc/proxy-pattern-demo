package com.github.s1mplecc.gof.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(
                IDBQuery.class.getClassLoader(),
                new Class[]{IDBQuery.class},
                new DynamicProxyHandler(new DBQuery()));
        proxy.query();
    }
}
