package net.chemodurov.productfromthemanufacturer.controller;

import net.chemodurov.productfromthemanufacturer.dao.HibernateManufacturerDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.HibernateProductDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.ManufacturerDAO;
import net.chemodurov.productfromthemanufacturer.dao.ProductDAO;
import net.chemodurov.productfromthemanufacturer.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        response.setContentType("text/html;charset=UTF-8");

        ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
        HashSet<Product> products = new HashSet<>(manufacturerDAO.getById(id).getProducts());

        request.setAttribute("products", products);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/products.jsp");
        dispatcher.forward(request, response);
    }
}
