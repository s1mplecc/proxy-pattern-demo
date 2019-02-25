package com.github.s1mplecc.gof.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理
 */
public class DBQueryProxy implements IDBQuery {
    private static final Logger log = LoggerFactory.getLogger(DBQueryProxy.class);
    private DBQuery dbQuery;

    public static void main(String[] args) {
        DBQueryProxy proxy = new DBQueryProxy();
        proxy.query();
    }

    @Override
    public String query() {
        if (dbQuery == null) {
            dbQuery = new DBQuery();
            log.info("Create database connection.");
        }
        String result = dbQuery.query();
        log.info("Query response is {}.", result);
        return result;
    }
}
