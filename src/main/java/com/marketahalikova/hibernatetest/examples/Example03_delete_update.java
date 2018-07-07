package com.marketahalikova.hibernatetest.examples;

import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Example03_delete_update {
    public static void main(String[] args) {
        ExampleUtils.createData();

        List<Font> fontsCrit = getAllFonts_criteria();
        deleteFont(fontsCrit.get(0));
        fontsCrit = getAllFonts_criteria();
        System.out.println("size after delete: " + fontsCrit.size());

        //update font name
        String originalFontName = fontsCrit.get(0).getFontName();
        fontsCrit.get(0).setFontName("new name");
        System.out.println("original name: " + originalFontName);
        updateFont(fontsCrit.get(0));
        Font font = getFontById_criteria(fontsCrit.get(0).getId());
        System.out.println("font with new name: " + font);
        System.out.println(" number of fonts: " + fontsCrit.size());

        //calling update method with new font without id in parameter
        Font newFont = new Font("Times");
        //newFont.setProjectId(2L);
        updateFont(newFont);
        System.out.println(" number of fonts: " + getAllFonts_criteria().size());

        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();
    }


    private static void deleteFont(Font font) {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        session.beginTransaction();
        session.delete(font);
        session.getTransaction().commit();
        session.close();
    }


    private static void updateFont(Font font) {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(font);
        session.getTransaction().commit();
        session.close();
    }

    private static List<Font> getAllFonts_criteria() {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Font.class);
        List<Font> result = criteria.list();
        session.close();
        return result;
    }

    private static Font getFontById_criteria(Long id) {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Font.class);
        criteria.add(Restrictions.eq("id", id));
        Font result = (Font) criteria.uniqueResult();
        session.close();
        return result;
    }
}
