package com.marketahalikova.hibernatetest.examples;

import com.marketahalikova.hibernatetest.HibernateJavaConfigAnnUtils;
import com.marketahalikova.hibernatetest.model.Font;
import com.marketahalikova.hibernatetest.model.Project;
import com.marketahalikova.hibernatetest.model.Triplet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Example06_many_to_many {

    public static void main(String[] args) {
        ExampleUtils.createData();

        Font font = saveFontWithTriplets();

        Font found = getFontWithTriplesById(font.getId());
        System.out.println("found font with triplets: " + found);

        HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().close();
    }


    private static Font saveFontWithTriplets() {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Font font = new Font("Helvetica");
        Font font1 = new Font("Arial");
        Triplet triplet1 = new Triplet("triplet1");
        Triplet triplet2 = new Triplet("triplet2");
        Triplet triplet3 = new Triplet("triplet3");
        Triplet triplet4 = new Triplet("triplet4");
        font.getTriplets().add(triplet1);
        font.getTriplets().add(triplet2);
        font.getTriplets().add(triplet3);
        font1.getTriplets().add(triplet1);
        font1.getTriplets().add(triplet4);

        session.beginTransaction();
        session.save(font);
        session.save(font1);
        session.save(triplet1);
        session.save(triplet2);
        session.save(triplet3);
        session.save(triplet4);
        session.getTransaction().commit();
        session.close();
        return font;
    }


    private static Font getFontWithTriplesById(Long id) {
        Session session = HibernateJavaConfigAnnUtils.getSessionJavaConfigFactory().openSession();
        Criteria criteria = session.createCriteria(Font.class);
        criteria.add(Restrictions.eq("id", id));
        Font result = (Font) criteria.uniqueResult();
        session.close();
        return result;
    }

}
