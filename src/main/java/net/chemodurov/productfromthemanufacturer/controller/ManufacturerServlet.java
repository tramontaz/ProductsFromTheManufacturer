package net.chemodurov.productfromthemanufacturer.controller;

import net.chemodurov.productfromthemanufacturer.dao.HibernateManufacturerDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.ManufacturerDAO;
import net.chemodurov.productfromthemanufacturer.model.Manufacturer;
import net.chemodurov.productfromthemanufacturer.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;

public class ManufacturerServlet extends HttpServlet {
    private ManufacturerDAO manufacturerDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        manufacturerDAO = new HibernateManufacturerDAOImpl();
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
                insertManufacturer(request, response);
                break;
            case "delete":
                deleteManufacturer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            default:
                listManufacturers(request, response);
                break;
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        manufacturer.setName(name);
        manufacturerDAO.update(manufacturer);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        PrintWriter out = response.getWriter();
        out.println(id);
        Manufacturer manufacturer = manufacturerDAO.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manufacturer.jsp");
        request.setAttribute("book", manufacturer);
        dispatcher.forward(request, response);
    }

    private void deleteManufacturer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        manufacturerDAO.delete(id);
        response.sendRedirect("/manufacturers?action=list");
    }

    private void insertManufacturer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");

        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName(name);
        newManufacturer.setProducts(new HashSet<Product>());
        manufacturerDAO.add(newManufacturer);
        response.sendRedirect("/manufacturers?action=list");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("manufacturer.jsp");
        dispatcher.forward(request, response);
    }

    private void listManufacturers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashSet<Manufacturer> manufacturers = new HashSet<>(manufacturerDAO.getAll());
        request.setAttribute("manufacturers", manufacturers);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/manufacturers.jsp");
        dispatcher.forward(request, response);
    }
}
