package org.example.DAO;

import org.example.model.ISSLocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ISSLocationDAO {

    private static SessionFactory sessionFactory;

    public ISSLocationDAO() {
        sessionFactory = DBConnector.getInstance().getSessionFactory();
    }

    public void create(ISSLocation issLocation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(issLocation);
        transaction.commit();
        session.close();
    }

    public List<ISSLocation> loadISSLocation() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ISSLocation> issLocationList = session
                .createQuery("from ISSLocation", ISSLocation.class)
                .getResultList();
        transaction.commit();
        session.close();
        return issLocationList;
    }

    public ISSLocation loadNthFromEndISSLocation(int n) {
        List<ISSLocation> issLocationList;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        issLocationList = session
                .createQuery("from ISSLocation order by iss_id DESC", ISSLocation.class)
                .setMaxResults(n)
                .getResultList();
        transaction.commit();
        session.close();
        try {
            return issLocationList.get(n - 1);
        } catch (IndexOutOfBoundsException e) {
            return loadNthFromEndISSLocation(n - 1);
        }
    }
}
