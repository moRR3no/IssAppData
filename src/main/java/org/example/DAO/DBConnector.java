package org.example.DAO;

import org.example.model.ISSLocation;
import org.example.model.ISSVelocity;
import org.example.model.SpaceCrew;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnector {

    private static DBConnector instance;
    private SessionFactory sessionFactory;

    private DBConnector() {
        connect();
    }

    static DBConnector getInstance(){
        if (instance == null){
            instance = new DBConnector();
        }
        return instance;
    }

    SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private void connect(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(SpaceCrew.class);
        configuration.addAnnotatedClass(ISSLocation.class);
        configuration.addAnnotatedClass(ISSVelocity.class);
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
}
