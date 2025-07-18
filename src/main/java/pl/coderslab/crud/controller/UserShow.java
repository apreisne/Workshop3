package pl.coderslab.crud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static pl.coderslab.crud.controller.UserUpdate.USER_DAO;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Long id = null;

        try {
            id = Long.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            request.setAttribute("notFound", true);
        }

        if (id != null) {

            var user = USER_DAO.read(id);
            user.ifPresent(value -> request.setAttribute("user", value));
        } else {
            request.setAttribute("notFound", true);
        }

        getServletContext().getRequestDispatcher("/users/user-show.jsp").forward(request, response);

    }


}