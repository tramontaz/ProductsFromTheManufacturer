package net.chemodurov.productfromthemanufacturer.dao;

import net.chemodurov.productfromthemanufacturer.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class HibernateUserDAOImpl implements UserDAO {
    @Override
    public void add(User entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(entity);
        session.close();
    }

    @Override
    public User getById(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        User product = session.get(User.class, id);
        session.close();
        return product;
    }

    @Override
    public void update(User entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        User product = session.get(User.class, id);
        session.delete(product);
        session.flush();
        session.close();
    }

    @Override
    public Set<User> getAll() {
        Set<User> products;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        products = new HashSet<User>(session.createQuery("FROM User").list());
        session.close();
        return products;
    }

    @Override
    public boolean validate(String name, String password) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from User where name=:username and password=:password");
        query.setParameter("username", name);
        query.setParameter("password", password);
        boolean result = !query.list().isEmpty();
        session.close();
        return result;
    }
}
