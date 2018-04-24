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
        ProductDAO productDAO = new HibernateProductDAOImpl();
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

//        for (Product product : manufacturerDAO.getById(12L).getProducts()) {
//            System.out.println(product.getName());
//        }
//
//        Set<Product> products = manufacturerDAO.getById(12L).getProducts();
//        Iterator<Product> iterator = products.iterator();
//        while (iterator.hasNext()) {
//            Product element = iterator.next();
//            if (element.getId() == 11L) {
//                iterator.remove();
//            }
//        }
//        manufacturerDAO.getById(12L).setProducts(products);
//
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }
//
//        Manufacturer fakeManuf = new Manufacturer();
//        fakeManuf.setName("fake");
//
//        Product ppp = new Product();
//        ppp.setName("PPP");
//        ppp.setPrice(new BigDecimal(1000));
//        ppp.setManufacturer(fakeManuf);
//
//        Product zzz = new Product();
//        zzz.setName("ZZZ");
//        zzz.setPrice(new BigDecimal(100));
//        zzz.setManufacturer(fakeManuf);
//
//        Set<Product> fakeProd = new HashSet<>();
//        fakeProd.add(ppp);
//        fakeProd.add(zzz);
//
//        fakeManuf.setProducts(fakeProd);
//        manufacturerDAO.add(fakeManuf);

        Product delProd = productDAO.getById(15L);
        productDAO.delete(15L);
//        manufacturerDAO.getById(14L).getProducts().remove(delProd);


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
