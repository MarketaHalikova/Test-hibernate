package com.marketahalikova.hibernatetest.examples;

import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import com.marketahalikova.hibernatetest.model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Example05_one_to_many {
    public static void main(String[] args) {
        Project project = saveProjectWithFonts();

        Project foundProject = getProjectWithFontById(project.getId());
        System.out.println("found project with fonts: " + foundProject);

        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();
    }


    private static Project saveProjectWithFonts() {
        Project project = new Project("ProjectFonts", "url1");
        Font font = new Font("Helvetica");
        Font font1 = new Font("Arial");
        project.addFont(font);
        project.addFont(font1);

        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        session.beginTransaction();
        session.save(project);
        session.save(font);
        session.save(font1);
        session.getTransaction().commit();
        return project;
    }

    private static Project getProjectWithFontById(Long id) {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.eq("id", id));
        Project result = (Project) criteria.uniqueResult();
        session.close();
        return result;
    }
}
