package pl.coderslab.crud.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.crud.dao.UserDao;
import pl.coderslab.crud.entity.User;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserUpdate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/form/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var userDao = UserDao.getInstance();
        var user = new User();

        user.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setId(Long.valueOf(request.getParameter("id")));

        userDao.updateUser(user);
        response.sendRedirect("/user/list");

    }
}