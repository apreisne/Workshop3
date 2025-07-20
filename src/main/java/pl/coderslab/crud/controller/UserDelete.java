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
        var id = Long.valueOf(request.getParameter("id"));

        userDao.delete(id);
        request.getSession().setAttribute("success", "User removed successfully!");
        response.sendRedirect("/user/list");
    }
}