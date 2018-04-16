package net.chemodurov.productfromthemanufacturer.dao;

import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateManufacturerDAOImpl implements ManufacturerDAO {

    public void add(Manufacturer entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.save(entity);
        session.close();
    }

    public Manufacturer getById(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        session.close();
        return manufacturer;
    }

    public void update(Manufacturer entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.flush();
        session.close();
    }

    public void delete(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        session.delete(manufacturer);
        session.flush();
        session.close();
    }

    public Set<Manufacturer> getAll() {
        Set<Manufacturer> manufacturers;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        manufacturers = new HashSet<Manufacturer>(session.createQuery("FROM Manufacturer").list());
        session.close();
        return manufacturers;
    }
}
