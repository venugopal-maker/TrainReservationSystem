package com.trainreservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.TrainDAO;
import com.trainreservation.model.Train;

@WebServlet("/ViewTrainsServlet")
public class ViewTrainsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        TrainDAO dao = new TrainDAO();

        ArrayList<Train> trains =
        dao.getAllTrains();

        request.setAttribute("trains", trains);

        request.getRequestDispatcher(
        "viewTrains.jsp")
        .forward(request, response);
    }
}