package com.marketahalikova.hibernatetest;

import com.marketahalikova.hibernatetest.model.User;
import org.hibernate.Session;


public class HibernateJavaConfigAnnMain {

    public static void main(String[] args) {
        User user = new User("gha", "12345");

        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Annotation user id: " + user.getId());
        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();

    }


}
