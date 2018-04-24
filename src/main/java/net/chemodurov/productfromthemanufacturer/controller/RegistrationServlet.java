package net.chemodurov.productfromthemanufacturer.controller;

import net.chemodurov.productfromthemanufacturer.dao.HibernateUserDAOImpl;
import net.chemodurov.productfromthemanufacturer.dao.UserDAO;
import net.chemodurov.productfromthemanufacturer.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new HibernateUserDAOImpl();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();

        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);

        if (userDAO.checkName(username)) {
            String message = "User with that name is already exist!";
            request.setAttribute("message", message);
            RequestDispatcher rs = request.getRequestDispatcher("registration.jsp");
            rs.forward(request, response);
        } else {
            userDAO.add(user);
            String message = "You have successfully registered.";
            request.setAttribute("message", message);
            RequestDispatcher rs = request.getRequestDispatcher("registration.jsp");
            rs.forward(request, response);
        }

    }
}
