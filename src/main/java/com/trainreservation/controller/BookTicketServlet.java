package com.trainreservation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainreservation.dao.BookingDAO;
import com.trainreservation.model.Booking;
import com.trainreservation.model.Passenger;

@WebServlet("/BookTicketServlet")
public class BookTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println("BookTicketServlet Working");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String journeyDate = request.getParameter("journeyDate");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String trainName = request.getParameter("trainName");
        String fare = request.getParameter("fare");
        String coachType = request.getParameter("coachType");

        int passengerCount = Integer.parseInt(request.getParameter("passengerCount"));

        String pnr = "PNR" + (int) (Math.random() * 1000000);

        double baseFare = Double.parseDouble(fare);

        if (coachType.equals("3A")) {
            baseFare += 300;
        } else if (coachType.equals("2A")) {
            baseFare += 600;
        } else if (coachType.equals("1A")) {
            baseFare += 1000;
        }

        double totalFare = baseFare * passengerCount;

        String coach;
        if (coachType.equals("SL")) {
            coach = "S" + (int) (Math.random() * 8 + 1);
        } else {
            coach = "A" + (int) (Math.random() * 4 + 1);
        }

        int startSeatNo = (int) (Math.random() * 60 + 1);

        List<Passenger> passengers = new ArrayList<>();
        String passengerDetails = "";

        for (int i = 1; i <= passengerCount; i++) {

            String pName = request.getParameter("passengerName" + i);
            String pAge = request.getParameter("age" + i);
            String pGender = request.getParameter("gender" + i);
            String pBerth = request.getParameter("berth" + i);

            Passenger p = new Passenger();
            p.setPassengerName(pName);
            p.setAge(Integer.parseInt(pAge));
            p.setGender(pGender);
            p.setCoach(coach);
            p.setSeatNo(startSeatNo + i - 1);
            p.setBerth(pBerth);

            passengers.add(p);

            passengerDetails +=
            		"<tr>" +
            		"<td>" + i + "</td>" +
            		"<td>" + pName + "</td>" +
            		"<td>" + pAge + "</td>" +
            		"<td>" + pGender + "</td>" +
            		"<td>" + coach + "</td>" +
            		"<td>" + (startSeatNo + i - 1) + "</td>" +
            		"<td>" + pBerth + "</td>" +
            		"</tr>";
        }

        String passengerName = request.getParameter("passengerName1");
        String age = request.getParameter("age1");
        String gender = request.getParameter("gender1");

        Booking booking = new Booking();
        booking.setPnr(pnr);
        booking.setPassengerName(passengerName);
        booking.setAge(Integer.parseInt(age));
        booking.setGender(gender);
        booking.setTrainName(trainName);
        booking.setSource(source);
        booking.setDestination(destination);
        booking.setJourneyDate(journeyDate);
        booking.setFare(totalFare);

        BookingDAO dao = new BookingDAO();
        boolean status = dao.saveBookingWithPassengers(booking, passengers);

        if (!status) {
            response.getWriter().println("Booking Failed");
            return;
        }

        response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Ticket Confirmation</title>" +
                "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>" +
                "</head>" +
                "<body style='background:#f4f6f9;'>" +

                "<div class='container mt-5'>" +
                "<div class='card shadow'>" +

                "<div class='card-header bg-success text-white text-center'>" +
                "<h2>Ticket Booked Successfully</h2>" +
                "</div>" +

                "<div class='card-body'>" +

                "<div class='alert alert-success text-center'>" +
                "<h3>Booking Successful!</h3>" +
                "<p>Your ticket has been confirmed.</p>" +
                "</div>" +

                "<table class='table table-bordered table-striped'>" +
                "<tr class='table-dark'><th>PNR Number</th><td>" + pnr + "</td></tr>" +
                "<tr class='table-primary'><th>Train Name</th><td>" + trainName + "</td></tr>" +
                "<tr class='table-info'><th>Source</th><td>" + source + "</td></tr>" +
                "<tr class='table-warning'><th>Destination</th><td>" + destination + "</td></tr>" +
                "<tr class='table-success'><th>Journey Date</th><td>" + journeyDate + "</td></tr>" +
                "<tr class='table-secondary'><th>Total Passengers</th><td>" + passengerCount + "</td></tr>" +
                "<tr class='table-primary'><th>Coach Type</th><td>" + coachType + "</td></tr>" +
                "<tr class='table-warning'><th>Coach</th><td>" + coach + "</td></tr>" +
                "<tr class='table-danger'><th>Total Fare</th><td>Rs. " + totalFare + "</td></tr>" +
                "</table>" +

				"<h4 class='mt-4'>Passenger Details</h4>" +
				"<table class='table table-bordered table-striped'>" +
				"<tr>" +
				"<th>S.No</th>" +
				"<th>Name</th>" +
				"<th>Age</th>" +
				"<th>Gender</th>" +
				"<th>Coach</th>" +
				"<th>Seat No</th>" +
				"<th>Berth Preference</th>" +
				"</tr>" +

                passengerDetails +

                "</table>" +

                "<a href='SearchTrainServlet' class='btn btn-primary'>Book Another Ticket</a> " +
                "<a href='dashboard.jsp' class='btn btn-success ms-2'>Dashboard</a> " +
                "<button onclick='window.print()' class='btn btn-danger ms-2'>Print Ticket</button>" +

                "</div>" +
                "</div>" +
                "</div>" +

                "</body>" +
                "</html>");
    }
}