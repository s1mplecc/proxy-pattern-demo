package com.github.s1mplecc.gof.proxy;

public class DBQuery implements IDBQuery {
    public DBQuery() {
        try {
            Thread.sleep(1000); // create datebase connection
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String query() {
        return "query result";
    }
}
