package com.hibernte;

import com.hibernte.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(user.class).buildSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
//        user user1 =new user(1,"Abdelrhman","Ash@gmail.com","Ash@@2528");
//        session.save(user1);
//        session.getTransaction().commit();

//        user user1 = session.get(user.class,1);
//        System.out.println(user1);

//        user user1 = session.get(user.class,1);
//        user1.setEmail("ash257281@outlook.com");
//        session.save(user1);
//        session.getTransaction().commit();

//        user user1 = session.get(user.class,1);
//        session.delete(user1);
//        session.getTransaction().commit();

        user user1 =new user(7,"Abdelrhman","abdoo.nasr22@gmail.com","Ash@@2528");
        user user2 =new user(1,"Sherouk","sherouk.mohmed22@gmail.com","Ash@@257281");
        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();


    }
}
