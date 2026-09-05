package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Studet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Studet.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            List<Studet> studets =new ArrayList<>();
//            List<Course>courses = new ArrayList<>();
//            Collections.addAll(courses,new Course("java"),new Course("c++"),new Course("python"));
//            Collections.addAll(studets,new Studet("Abdelrhman"),new Studet("Sherouk"),new Studet("tafeda"));
//            for (Studet studet :studets){
//                studet.setCourses(courses);
//                session.save(studet);
//            }
//            for (Course course :courses){
//                course.setStudets(studets);
//                session.save(course);
//            }
//            session.getTransaction().commit();

            int id = 2;
            Studet studet = session.get(Studet.class,id);
            System.out.println("Student All info is :" +studet);
            System.out.println("Courses is:" + studet.getCourses());

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
