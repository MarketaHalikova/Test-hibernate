package com.marketahalikova.hibernatetest.examples;


import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import com.marketahalikova.hibernatetest.model.Project;
import com.marketahalikova.hibernatetest.model.User;
import org.hibernate.Session;

/**
 * class for filling database
 */
public class ExampleUtils {

    public static void createData(){
        saveProject();
        saveUser();
    }

    public static void saveProject() {

        Project project = new Project("Project1", "url1");
        Font font = new Font("Helvetica");
        Font font1 = new Font("Arial");

        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().getCurrentSession();
        session.beginTransaction();
        session.save(project);
        session.save(font);
        session.save(font1);
        session.getTransaction().commit();
    }

    public static void saveUser(){
        User user = new User("gha", "12345");

        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}
