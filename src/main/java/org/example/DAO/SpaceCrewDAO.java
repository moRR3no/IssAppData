package org.example.DAO;

import org.example.model.SpaceCrew;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SpaceCrewDAO {

    private static SessionFactory sessionFactory;

    public SpaceCrewDAO() {
        sessionFactory = DBConnector.getInstance().getSessionFactory();
    }

    public void create(SpaceCrew spaceCrew) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(spaceCrew);
        transaction.commit();
        session.close();
    }

    public void create(SpaceCrew[] spaceCrew) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (SpaceCrew crew : spaceCrew) {
            session.save(crew);
        }
        transaction.commit();
        session.close();
    }

    public List<SpaceCrew> loadSpaceCrew() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<SpaceCrew> spaceCrewList = session
                .createQuery("from SpaceCrew", SpaceCrew.class)
                .getResultList();
        transaction.commit();
        session.close();
        return spaceCrewList;
    }
}
