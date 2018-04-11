package net.chemodurov.productfromthemanufacturer.dao;

import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateManufacturerDAOImpl implements ManufacturerDAO {
    private SessionFactory sessionFactory;

    public HibernateManufacturerDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void add(Manufacturer entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
        sessionFactory.close();
    }

    public Manufacturer getById(Long id) {
        Session session = sessionFactory.openSession();
        Manufacturer manufacturer = (Manufacturer) session.get(Manufacturer.class, id);
        session.close();
        sessionFactory.close();
        return manufacturer;
    }

    public void update(Manufacturer entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
        sessionFactory.close();
    }

    public void delete(Long id) {
        Session  session = sessionFactory.openSession();
        session.beginTransaction();
        Manufacturer manufacturer = (Manufacturer) session.get(Manufacturer.class, id);
        session.delete(manufacturer);
        session.flush();
        session.close();
        sessionFactory.close();
    }

    public Set<Manufacturer> getAll() {
        Set<Manufacturer> manufacturers;
        Session session = sessionFactory.openSession();
        manufacturers = new HashSet<Manufacturer>(session.createQuery("FROM Manufacturer").list());
        session.close();
        sessionFactory.close();
        return manufacturers;
    }
}
