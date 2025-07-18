package pl.coderslab.crud.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.crud.dao.UserDao;

import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var userDao = UserDao.getInstance();
        Long id = Long.valueOf(request.getParameter("id"));

        userDao.delete(id);
        response.sendRedirect("/user/list");

    }
}