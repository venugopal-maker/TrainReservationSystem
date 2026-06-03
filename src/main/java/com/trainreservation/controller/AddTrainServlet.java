package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.TrainDAO;
import com.trainreservation.model.Train;

@WebServlet("/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Train train = new Train();

        train.setTrainNo(
        request.getParameter("trainNo"));

        train.setTrainName(
        request.getParameter("trainName"));

        train.setSource(
        request.getParameter("source"));

        train.setDestination(
        request.getParameter("destination"));

        train.setDepartureTime(
        request.getParameter("departure"));

        train.setArrivalTime(
        request.getParameter("arrival"));

        train.setFare(
        Double.parseDouble(
        request.getParameter("fare")));

        TrainDAO dao = new TrainDAO();

        boolean status =
        dao.addTrain(train);

        if(status){

            response.sendRedirect(
            "ViewTrainsServlet");

        }else{

            response.getWriter().println(
            "<h2>Train Add Failed</h2>");
        }
    }
}