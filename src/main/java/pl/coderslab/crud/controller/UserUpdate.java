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
    public static final String USER_NOT_FOUND = "User not found";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var param = request.getParameter("id");

        if (param == null) {
            setErrorAttribute(request);
            getServletContext().getRequestDispatcher("/form/edit.jsp").forward(request, response);
            return;
        }

        try {
            var id = Long.valueOf(param);
            Optional<User> user = USER_DAO.read(id);

            if (user.isPresent()) {
                request.setAttribute("user", user.get());
            } else {
                setErrorAttribute(request);
            }

        } catch (NumberFormatException e) {
            setErrorAttribute(request);
        }


        getServletContext().getRequestDispatcher("/form/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var user = new User();

        user.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setId(Long.valueOf(request.getParameter("id")));

        USER_DAO.updateUser(user);

        request.getSession().setAttribute("success", "User updated successfully!");
        response.sendRedirect("/user/list");

    }

    private static void setErrorAttribute(HttpServletRequest request) {
        request.setAttribute("error", USER_NOT_FOUND);
    }
}