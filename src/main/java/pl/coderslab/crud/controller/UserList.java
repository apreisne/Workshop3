package pl.coderslab.crud.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.crud.dao.UserDao;
import pl.coderslab.crud.entity.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var userDao = UserDao.getInstance();
        List<User> users = userDao.findAll();

        request.setAttribute("users", users);
        request.setAttribute("usersNumber", users.size());

        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    }


}