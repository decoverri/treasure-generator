package org.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration cfg = new Configuration();
	    
	    cfg.addAnnotatedClass(model.CoinReward.class);
	    
	    cfg.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
	    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}

    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();
    }

}
