package net.chemodurov.productfromthemanufacturer.dao;

import net.chemodurov.productfromthemanufacturer.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateProductDAOImpl implements ProductDAO {
    private SessionFactory sessionFactory;

    public HibernateProductDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void add(Product entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
        sessionFactory.close();
    }

    public Product getById(Long id) {
        Session session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        sessionFactory.close();
        return product;
    }

    public void update(Product entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
        sessionFactory.close();
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        session.delete(product);
        session.flush();
        session.close();
        sessionFactory.close();
    }

    public Set<Product> getAll() {
        Set<Product> products;
        Session session = sessionFactory.openSession();
        products = new HashSet<Product>(session.createQuery("FROM Product ").list());
        session.close();
        sessionFactory.close();
        return products;
    }
}
