package net.chemodurov.productfromthemanufacturer;

import net.chemodurov.productfromthemanufacturer.dao.*;
import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import net.chemodurov.productfromthemanufacturer.model.Product;
import net.chemodurov.productfromthemanufacturer.model.User;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {

      public static void main(String[] args) {
          userDAOTest();

      }

    private static void userDAOTest() {
        UserDAO userDAO = new HibernateUserDAOImpl();
        System.out.println(userDAO.validate("user", "password"));

        User user = new User();
        user.setName("user");
        user.setPassword("password");
        userDAO.add(user);
        System.out.println(userDAO.validate("user", "password"));
    }

    private static void hibernateTest() {
        ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
        ProductDAO productDAO = new HibernateProductDAOImpl();

//        Manufacturer abus = new Manufacturer();
//        abus.setName("Abus");
//
//        Product lock = new Product();
//        lock.setName("Abus Lock");
//        lock.setPrice(new BigDecimal(12000));
//        lock.setManufacturer(abus);
//        System.out.println("product: " + lock);
//
//        Product chain = new Product();
//        chain.setName("Abus Chain");
//        chain.setPrice(new BigDecimal(18000));
//        chain.setManufacturer(abus);
//        System.out.println("product: " + chain);
//
//        Set<Product> products = new HashSet<>();
//        products.add(lock);
//        products.add(chain);
//
//        abus.setProducts(products);
//        System.out.println("manufacturer: " + abus);
//
//        manufacturerDAO.add(abus);
//        logger.info("manufacturer successful added.");


        manufacturerDAO.delete(6L);

        Manufacturer man = manufacturerDAO.getById(6L);
        System.out.println("Manufacturer id: " + man.getId() + "\n" +
                "Manufacturer name: " + man.getName() + "\n" +
                "manufacturer's products: " + man.getProducts() + "\n");
    }
}
