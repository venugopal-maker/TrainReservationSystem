package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.TrainDAO;
import com.trainreservation.model.Train;

@WebServlet("/UpdateTrainServlet")
public class UpdateTrainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Train train = new Train();

        train.setTrainId(
        Integer.parseInt(request.getParameter("trainId")));

        train.setTrainNo(
        request.getParameter("trainNo"));

        train.setTrainName(
        request.getParameter("trainName"));

        train.setSource(
        request.getParameter("source"));

        train.setDestination(
        request.getParameter("destination"));

        train.setDepartureTime(
        request.getParameter("departureTime"));

        train.setArrivalTime(
        request.getParameter("arrivalTime"));

        train.setFare(
        Double.parseDouble(request.getParameter("fare")));

        TrainDAO dao =
        new TrainDAO();

        dao.updateTrain(train);

        response.sendRedirect(
        "ViewTrainsServlet");
    }
}