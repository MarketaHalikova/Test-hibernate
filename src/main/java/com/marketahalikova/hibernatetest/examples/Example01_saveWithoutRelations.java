package com.marketahalikova.hibernatetest.examples;

import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import com.marketahalikova.hibernatetest.model.Project;
import com.marketahalikova.hibernatetest.model.User;
import org.hibernate.Session;

/**
 * Creating new tables at the beginning of a session. Saving data into tables.
 * Tables dont have any relations between them yet.
 * In class Project is necessary to disable List of Fonts for each project
 */

public class Example01_saveWithoutRelations {

    public static void main(String[] args) {
        saveUser();
        saveProject();
        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();
    }

    private static void saveProject() {

        Project project = new Project("Project1", "url1");
        Font font = new Font("Helvetica");
        Font font1 = new Font("Arial");

        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().getCurrentSession();
        session.beginTransaction();
        session.save(project);
        session.save(font);
        session.save(font1);
        session.getTransaction().commit();
        System.out.println("Project name: " + project.getName());
        System.out.println("Font name: " + font.getFontName());
        System.out.println("Font1 name: " + font1.getFontName());


    }

    public static void saveUser(){
        User user = new User("gha", "12345");

        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Annotation user id: " + user.getId());
    }
}
