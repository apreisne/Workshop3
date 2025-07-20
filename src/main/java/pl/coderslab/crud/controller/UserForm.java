package pl.coderslab.crud.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.crud.dao.UserDao;
import pl.coderslab.crud.entity.User;

import java.io.IOException;

@WebServlet("/user/add")
public class UserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/form/add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var userDao = UserDao.getInstance();
        var user = new User();

        var username = request.getParameter("username");
        var password = request.getParameter("password");
        var email = request.getParameter("email");

        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);

        userDao.create(user);

        request.getSession().setAttribute("success", "User created successfully!");
        response.sendRedirect("/user/list");

    }

}