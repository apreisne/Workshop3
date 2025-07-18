package pl.coderslab.crud.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.crud.dao.UserDao;
import pl.coderslab.crud.entity.User;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/user/edit")
public class UserUpdate extends HttpServlet {

    public static final UserDao USER_DAO = UserDao.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Optional<User> user = USER_DAO.read(Long.valueOf(request.getParameter(("id"))));

        user.ifPresent(value -> request.setAttribute("user", value));

        getServletContext().getRequestDispatcher("/form/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var user = new User();

        user.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setId(Long.valueOf(request.getParameter("id")));

        USER_DAO.updateUser(user);
        response.sendRedirect("/user/list");

    }
}