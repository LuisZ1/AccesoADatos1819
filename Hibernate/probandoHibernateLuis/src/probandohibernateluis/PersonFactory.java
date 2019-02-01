/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandohibernateluis;

/**
 *
 * @author lzumarraga
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersonFactory {
    private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory;
 
    static {
        try {
            Configuration configuration=new Configuration()
            .configure(); // configures settings from hibernate.cfg.xml

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

            // If you miss the below line then it will complaing about a missing dialect setting
            serviceRegistryBuilder.applySettings(configuration.getProperties());

            serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

