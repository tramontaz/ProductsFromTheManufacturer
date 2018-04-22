package net.chemodurov.productfromthemanufacturer;

import net.chemodurov.productfromthemanufacturer.dao.*;
import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import net.chemodurov.productfromthemanufacturer.model.Product;
import net.chemodurov.productfromthemanufacturer.model.User;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
//
//        Manufacturer albatros = new Manufacturer();
//        albatros.setName("Albatros");
//
//        Product albatrosLock = new Product();
//        albatrosLock.setName("Albatros Lock");
//        albatrosLock.setPrice(new BigDecimal(2000));
//        albatrosLock.setManufacturer(albatros);
//        System.out.println("product: " + albatrosLock);
//
//        Product albatrosChain = new Product();
//        albatrosChain.setName("Albatros Chain");
//        albatrosChain.setPrice(new BigDecimal(8000));
//        albatrosChain.setManufacturer(albatros);
//        System.out.println("product: " + albatrosChain);
//
//        Set<Product> albatrosProducts = new HashSet<>();
//        albatrosProducts.add(albatrosLock);
//        albatrosProducts.add(albatrosChain);
//
//        albatros.setProducts(albatrosProducts);
//
//        manufacturerDAO.add(albatros);


//        ProductDAO productDAO = new HibernateProductDAOImpl();
//        Manufacturer manufacturer = manufacturerDAO.getById(11L);
//
//        Iterator<Product> i = manufacturer.getProducts().iterator();
//        while(i.hasNext()){
//            Product product = i.next();
//            for (Iterator<Product> it = manufacturer.getProducts().iterator()) {
//                if (product.getId() == it.next().getId()) {
//                    it.remove(); // this removes the child from the underlying collection
//                }
//            }
//        }
//        for (Product product : manufacturerDAO.getById(11L).getProducts()) {
//            System.out.println(product.getName());
//        }


    }

    private static void userDAOTest() {
        UserDAO userDAO = new HibernateUserDAOImpl();
        System.out.println(userDAO.validate("user", "password"));

        User user = new User();
        user.setName("user");
        user.setPassword("password");
        userDAO.add(user);
        System.out.println(userDAO.validate("user", "password"));
        HibernateSessionFactory.shutdown();
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
