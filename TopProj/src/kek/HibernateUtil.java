package kek;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static final SessionFactory factory;
	static {
		ServiceRegistry serviceRegistry = null;
		Configuration configuration = new Configuration();
		try {
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.configure().getProperties()).build();
		} catch (HibernateException ex) {
			System.out.println("CFG ERROR" + ex);
			System.exit(0);
		}
		factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
    public static SessionFactory getFactory() {
        return factory;
    }
}
