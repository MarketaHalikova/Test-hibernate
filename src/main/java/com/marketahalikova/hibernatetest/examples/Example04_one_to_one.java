package com.marketahalikova.hibernatetest.examples;

import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import com.marketahalikova.hibernatetest.model.Info;
import com.marketahalikova.hibernatetest.model.Maven;
import com.marketahalikova.hibernatetest.model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * project ma s maven vazbu one to one jednosmernou - maven nema ulozeno k jakemu projektu patri
 * project ma s info vazbu one to one obousmernou - info vi k jakemu projektu patri
 *
 */
public class Example04_one_to_one {
    public static void main(String[] args) {
        saveMaven();
        System.out.println("Maven count: " + getAllMavens().size());

        Project project = saveProjectWithMaven();
        System.out.println("Maven count: " + getAllMavens().size());

        Project foundProject = readProjectWithMavenById(project.getId());
        System.out.println("found project: " + foundProject);

        Project projectInfo = saveProjectWithInfo();
        Project projectInfoDtb = readProjectWithMavenById(projectInfo.getId());
        System.out.println("found project with info: " + projectInfoDtb);

        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();
    }


    private static void saveMaven() {
        Maven maven = new Maven("group1", "artifact1", "version1" );
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        session.beginTransaction();
        session.save(maven);
        session.getTransaction().commit();
        session.close();
    }


    private static List<Maven> getAllMavens() {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Maven.class);
        List<Maven> result = criteria.list();
        session.close();
        return result;
    }

    private static Project saveProjectWithMaven() {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Maven maven = new Maven("group2", "artifact2", "version2" );
        Project project = new Project("Project2", "url2");
        project.setMaven(maven);
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
        session.close();
        return project;
    }


    private static Project readProjectWithMavenById(Long id) {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.eq("id", id));
        Project result = (Project) criteria.uniqueResult();
        session.close();
        return result;
    }

    private static Project saveProjectWithInfo() {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Info info1 = new Info("Info1");
        Info info2 = new Info("Info2");
        Project project = new Project("Project3", "url3");
        project.setInfo(info2);
        //info2.setProject(project);
        session.beginTransaction();
        session.save(info1);
        // poradi je dulezite
        session.save(project);
        //session.save(info2);
        session.getTransaction().commit();
        session.close();
        return project;
    }
}
