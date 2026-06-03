package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.UserDAO;
import com.trainreservation.model.User;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        HttpSession session =
        request.getSession();

        User user =
        (User)session.getAttribute("user");

        String oldPassword =
        request.getParameter("oldPassword");

        String newPassword =
        request.getParameter("newPassword");

        UserDAO dao =
        new UserDAO();

        boolean status =
        dao.changePassword(
        user.getEmail(),
        oldPassword,
        newPassword);

        if(status) {

            response.getWriter().println(
            "<script>" +
            "alert('Password Changed Successfully');" +
            "window.location='dashboard.jsp';" +
            "</script>");

        } else {

            response.getWriter().println(
            "<script>" +
            "alert('Old Password Incorrect');" +
            "window.location='changePassword.jsp';" +
            "</script>");
        }
    }
}