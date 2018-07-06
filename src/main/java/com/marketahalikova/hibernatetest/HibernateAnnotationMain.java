package com.marketahalikova.hibernatetest;

import com.marketahalikova.hibernatetest.model.User;
import org.hibernate.Session;


public class HibernateAnnotationMain {

    public static void main(String[] args) {
        User user = new User("oha", "12345");

        Session session = HibernateAnnotationUtils.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Annotation user id: " + user.getId());
        HibernateAnnotationUtils.getSessionAnnotationFactory().close();

    }


}
