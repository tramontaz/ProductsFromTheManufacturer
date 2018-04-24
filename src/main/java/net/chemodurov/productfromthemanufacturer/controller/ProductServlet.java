package net.chemodurov.productfromthemanufacturer.controller;

import net.chemodurov.productfromthemanufacturer.dao.HibernateManufacturerDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.HibernateProductDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.ManufacturerDAO;
import net.chemodurov.productfromthemanufacturer.dao.ProductDAO;
import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import net.chemodurov.productfromthemanufacturer.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashSet;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    private ManufacturerDAO manufacturerDAO;
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        manufacturerDAO = new HibernateManufacturerDAOImpl();
        productDAO = new HibernateProductDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);

        productDAO.update(product);
        response.sendRedirect("/products?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Product product = productDAO.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        request.setAttribute("product", product);
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long manufacturer_id = Long.parseLong(request.getParameter("manufacturer_id"));
        long id = Long.parseLong(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/products?action=list&id=" + manufacturer_id);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        long manufacturer_id = Long.parseLong(request.getParameter("manufacturer_id"));
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setManufacturer(manufacturerDAO.getById(manufacturer_id));
        productDAO.add(newProduct);
        response.sendRedirect("/products?action=list&id=" + manufacturer_id + "&manufacturer_name=" + manufacturerDAO.getById(manufacturer_id).getName());
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long manufacturer_id = Long.parseLong(request.getParameter("manufacturer_id"));
        request.setAttribute("manufacturer_id", manufacturer_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        response.setContentType("text/html;charset=UTF-8");

        HashSet<Product> products = new HashSet<>(manufacturerDAO.getById(id).getProducts());

        request.setAttribute("products", products);
        request.setAttribute("manufacturer_id", id);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/products.jsp");
        dispatcher.forward(request, response);
    }
}
