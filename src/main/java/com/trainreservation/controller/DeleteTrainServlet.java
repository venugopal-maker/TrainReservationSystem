package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainreservation.dao.TrainDAO;

@WebServlet("/DeleteTrainServlet")
public class DeleteTrainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int trainId =
        Integer.parseInt(
        request.getParameter("id"));

        TrainDAO dao =
        new TrainDAO();

        boolean status =
        dao.deleteTrain(trainId);

        if(status) {

            response.sendRedirect(
            "ViewTrainsServlet");

        } else {

            response.getWriter().println(
            "<h2>Train Delete Failed</h2>");
        }
    }
}