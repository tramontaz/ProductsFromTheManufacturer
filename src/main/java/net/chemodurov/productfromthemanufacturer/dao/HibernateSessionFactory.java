package net.chemodurov.productfromthemanufacturer.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.DriverManager;

public class HibernateSessionFactory {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

//    private static final SessionFactory sessionFactory;
//
//    static {
//        try {
//            StandardServiceRegistry standardRegistry =
//                    new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//            Metadata metaData =
//                    new MetadataSources(standardRegistry).getMetadataBuilder().build();
//            sessionFactory = metaData.getSessionFactoryBuilder().build();
//        } catch (Throwable th) {
//
//            System.err.println("SessionFactory creation failed" + th);
//            throw new ExceptionInInitializerError(th);
//
//        }
//    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void shutdown() {
//        //close caches and connections pools
//        getSessionFactory().close();
//    }
}
