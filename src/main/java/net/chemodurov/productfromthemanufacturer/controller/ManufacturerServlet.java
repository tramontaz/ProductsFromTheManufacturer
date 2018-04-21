package net.chemodurov.productfromthemanufacturer.controller;

import net.chemodurov.productfromthemanufacturer.dao.HibernateManufacturerDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.ManufacturerDAO;
import net.chemodurov.productfromthemanufacturer.model.Manufacturer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class ManufacturerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
        HashSet<Manufacturer> manufacturers = new HashSet<>(manufacturerDAO.getAll());
        request.setAttribute("manufacturers", manufacturers);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/manufacturers.jsp");
        dispatcher.forward(request, response);
    }
}
