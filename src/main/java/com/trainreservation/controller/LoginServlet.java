package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainreservation.dao.UserDAO;
import com.trainreservation.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        User user = dao.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();

            session.setAttribute("user", user);

            if("STATION_MASTER".equals(user.getRole())){

                response.sendRedirect("stationMasterDashboard.jsp");

            }else{

                response.sendRedirect("dashboard.jsp");
            }

        
        } else {

            response.getWriter().println(
                    "<h2>Invalid Email or Password</h2>");
        }
    }
}