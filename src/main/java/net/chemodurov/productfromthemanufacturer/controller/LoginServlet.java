package net.chemodurov.productfromthemanufacturer.controller;

import net.chemodurov.productfromthemanufacturer.dao.HibernateUserDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        UserDAO userDAO = new HibernateUserDAOImpl();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if (userDAO.validate(username, password)) {
            RequestDispatcher rs = request.getRequestDispatcher("/manufacturers?action=list");
            rs.forward(request, response);
        }
        else {
            out.println("Access denied!");
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);
        }
    }
}
