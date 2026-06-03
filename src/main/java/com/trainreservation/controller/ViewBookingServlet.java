package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainreservation.dao.BookingDAO;
import com.trainreservation.model.Booking;

@WebServlet("/ViewBookingServlet")
public class ViewBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String pnr = request.getParameter("pnr");

        BookingDAO dao = new BookingDAO();

        Booking booking = dao.getBookingByPnr(pnr);
        
        
        java.util.ArrayList<com.trainreservation.model.Passenger>
        passengers = dao.getPassengersByPnr(pnr);

        String passengerRows = "";

        for(com.trainreservation.model.Passenger p : passengers){

            passengerRows +=

            "<tr>" +
            "<td>" + p.getPassengerName() + "</td>" +
            "<td>" + p.getAge() + "</td>" +
            "<td>" + p.getGender() + "</td>" +
            "<td>" + p.getCoach() + "</td>" +
            "<td>" + p.getSeatNo() + "</td>" +
            "<td>" + p.getBerth() + "</td>" +
            "</tr>";
        }

        response.setContentType("text/html");

        if (booking == null) {

            response.getWriter().println(
                "<h2>Booking Not Found</h2>" +
                "<a href='myBookings.jsp'>Back</a>"
            );

            return;
        }

        response.getWriter().println(

        "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<meta charset='UTF-8'>" +
        "<title>Booking Details</title>" +
        "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>" +
        "</head>" +

        "<body style='background:#f4f6f9;'>" +

        "<div class='container mt-5'>" +

        "<div class='card shadow'>" +

        "<div class='card-header bg-primary text-white text-center'>" +
        "<h2>Ticket Details</h2>" +
        "</div>" +

        "<div class='card-body'>" +

        "<table class='table table-bordered table-striped'>" +

        "<tr><th>PNR Number</th><td>" + booking.getPnr() + "</td></tr>" +
        "<tr><th>Passenger Name</th><td>" + booking.getPassengerName() + "</td></tr>" +
        "<tr><th>Train Name</th><td>" + booking.getTrainName() + "</td></tr>" +
        "<tr><th>Source</th><td>" + booking.getSource() + "</td></tr>" +
        "<tr><th>Destination</th><td>" + booking.getDestination() + "</td></tr>" +
        "<tr><th>Journey Date</th><td>" + booking.getJourneyDate() + "</td></tr>" +
        "<tr><th>Fare</th><td>Rs. " + booking.getFare() + "</td></tr>" +
        
		"<h4>Passenger Details</h4>" +
		
		"<table class='table table-bordered'>" +
		
		"<tr>" +
		"<th>Name</th>" +
		"<th>Age</th>" +
		"<th>Gender</th>" +
		"<th>Coach</th>" +
		"<th>Seat No</th>" +
		"<th>Berth</th>" +
		"</tr>" +
		
		passengerRows +
		
		

        "</table>" +
        
        

        "<a href='myBookings.jsp' class='btn btn-secondary'>Back</a> " +

        "<button onclick='window.print()' class='btn btn-success'>" +
        "Print Ticket" +
        "</button>" +

        "</div>" +
        "</div>" +
        "</div>" +

        "</body>" +
        "</html>"
        );
    }
}