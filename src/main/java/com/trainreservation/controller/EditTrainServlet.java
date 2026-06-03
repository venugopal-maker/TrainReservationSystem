package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.TrainDAO;
import com.trainreservation.model.Train;

@WebServlet("/EditTrainServlet")
public class EditTrainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
        Integer.parseInt(request.getParameter("id"));

        TrainDAO dao = new TrainDAO();

        Train train =
        dao.getTrainById(id);

        request.setAttribute("train", train);

        request.getRequestDispatcher(
        "editTrain.jsp")
        .forward(request, response);
    }
}