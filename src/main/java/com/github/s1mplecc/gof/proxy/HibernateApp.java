package com.github.s1mplecc.gof.proxy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        User user = session.load(User.class, 1);
        System.out.println("Class name: " + user.getClass().getName());
        System.out.println("Superclass name: " + user.getClass().getSuperclass().getName());
        for (Class<?> anInterface : user.getClass().getInterfaces()) {
            System.out.println("Interface name: " + anInterface.getName());
        }

        System.out.println(user.getName());
    }
}
