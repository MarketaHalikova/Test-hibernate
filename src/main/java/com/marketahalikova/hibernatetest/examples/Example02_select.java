package com.marketahalikova.hibernatetest.examples;

import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Example02_select {
    public static void main(String[] args) {
        ExampleUtils.createData();


        //Hibernate Query Language (HQL)
        List<Font> fonts = getAllFonts_hql();
        System.out.println("font count:" + fonts.size());
        Font fontById = getFontById_hql(fonts.get(0).getId());
        System.out.println(fontById);

        //Get gata using SQL
        List<Font> fontsSql = getAllFonts_sql();
        System.out.println("font count:" + fontsSql.size());
        Font fontByIdSql = getFontById_sql(fontsSql.get(0).getId());
        System.out.println(fontByIdSql);

        //Criteria
        List<Font> fontsCrit = getAllFonts_criteria();
        System.out.println("font count:" + fontsCrit.size());
        Font fontByIdCrit = getFontById_criteria(fontsCrit.get(0).getId());
        System.out.println(fontByIdCrit);

        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();
    }


    private static List<Font> getAllFonts_hql() {
        String hql = "FROM Font";
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        List<Font> result = session.createQuery(hql).list();
        session.close();
        return result;
    }

    private static Font getFontById_hql(Long id) {
        String hql = "FROM Font F WHERE F.id =" + id;
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Font result = (Font) session.createQuery(hql).uniqueResult();
        session.close();
        return result;
    }

    private static Font getFontById_sql(Long id) {
        String sql = "SELECT * FROM Font WHERE id = :id";
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Font.class);
        sqlQuery.setParameter("id", id);
        Font font = (Font) sqlQuery.uniqueResult();
        session.close();
        return font;
    }

    private static List<Font> getAllFonts_sql() {
        String sql = "SELECT * FROM Font";
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Font.class);
        List<Font> result = sqlQuery.list();
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

    private static List<Font> getAllFonts_criteria() {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Font.class);
        List<Font> result = criteria.list();
        session.close();
        return result;
    }

}
