package com.marketahalikova.hibernatetest;

import com.marketahalikova.hibernatetest.model.User;
import org.hibernate.Session;


public class HibernateXmlMain {

    public static void main(String[] args) {
        User user = new User("lha", "12345");

        Session session = HibernateXmlUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("user id: " + user.getId());
        HibernateXmlUtils.getSessionFactory().close();

    }


}
