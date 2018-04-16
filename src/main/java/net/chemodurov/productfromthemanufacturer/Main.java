package net.chemodurov.productfromthemanufacturer;

import net.chemodurov.productfromthemanufacturer.dao.HibernateManufacturerDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.HibernateProductDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.ManufacturerDAO;
import net.chemodurov.productfromthemanufacturer.dao.ProductDAO;
import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import net.chemodurov.productfromthemanufacturer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {
  private static Logger logger = LoggerFactory.getLogger(Main.class);

      public static void main(String[] args) {
          hebernateTest();
    }

    private static void hebernateTest() {
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
