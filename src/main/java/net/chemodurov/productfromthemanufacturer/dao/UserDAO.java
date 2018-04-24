package net.chemodurov.productfromthemanufacturer.dao;

import net.chemodurov.productfromthemanufacturer.model.User;

public interface UserDAO extends GenericDAO<User, Long> {
    boolean validate(String name, String password);
    boolean checkName(String name);
}
