package com.trainreservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.UserDAO;
import com.trainreservation.model.User;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO dao = new UserDAO();

        ArrayList<User> users =
        dao.getAllUsers();

        request.setAttribute("users", users);

        request.getRequestDispatcher(
        "viewUsers.jsp")
        .forward(request, response);
    }
}