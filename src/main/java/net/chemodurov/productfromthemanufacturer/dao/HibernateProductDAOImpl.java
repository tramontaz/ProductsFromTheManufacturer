package net.chemodurov.productfromthemanufacturer.dao;

import net.chemodurov.productfromthemanufacturer.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateProductDAOImpl implements ProductDAO {

    public void add(Product entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.persist(entity);
        session.close();
    }

    public Product getById(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }

    public void update(Product entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
    }

    public void delete(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        session.delete(product);
        session.flush();
        session.close();
    }

    public Set<Product> getAll() {
        Set<Product> products;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        products = new HashSet<Product>(session.createQuery("FROM Product ").list());
        session.close();
        return products;
    }
}
