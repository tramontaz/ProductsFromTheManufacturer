package net.chemodurov.productfromthemanufacturer.dao;

import java.util.Set;

public interface GenericDAO<T, ID> {
    void add(T entity);
    T getById(ID id);
    void update(T entity);
    void delete(ID id);
    Set<T> getAll();
}
