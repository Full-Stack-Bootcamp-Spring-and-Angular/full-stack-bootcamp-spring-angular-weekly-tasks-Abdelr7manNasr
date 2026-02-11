package com.hibernate;

import com.hibernate.entity.Answer;
import com.hibernate.entity.Question;
import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Question.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Question question = new Question("Question 1");
//            List<Answer> answers = new ArrayList<>();
//            answers.add(new Answer("A1"));
//            answers.add(new Answer("A2"));
//            question.setAnswers(answers);
//            session.save(question);

//            Instructor instructor = new Instructor("Abdelrhman");
//            List<Course> courses =new ArrayList<>();
//            Collections.addAll(courses, new Course("java"), new Course("cpp"));
//            instructor.setCourses(courses);
//            session.save(instructor);

            Instructor instructor = new Instructor("Abdelrhman");
            List<Course> courses = new ArrayList<>();
            Collections.addAll(courses, new Course("java"), new Course("cpp"));
            for (Course c : courses) {
                c.setInstructor(instructor);
            }

            instructor.setCourses(courses);
            session.save(instructor);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
