package com.trainreservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainreservation.dao.BookingDAO;

@WebServlet("/CancelTicketServlet")
public class CancelTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String pnr = request.getParameter("pnr");

        BookingDAO dao = new BookingDAO();

        boolean status = dao.cancelBooking(pnr);
        
        
        if(status) {

            response.getWriter().println(
                "<script>" +
                "alert('Ticket Cancelled Successfully');" +
                "window.location='myBookings.jsp';" +
                "</script>"
            );

        } else {

            response.getWriter().println(
                "<script>" +
                "alert('Ticket Cancellation Failed');" +
                "window.location='myBookings.jsp';" +
                "</script>"
            );
        }

        response.setContentType("text/html");

        if(status) {

            response.getWriter().println(

            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset='UTF-8'>" +
            "<title>Cancel Ticket</title>" +

            "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>" +

            "</head>" +

            "<body style='background:#f4f6f9;'>" +

            "<div class='container mt-5'>" +

            "<div class='alert alert-success text-center shadow'>" +

            "<h2> Ticket Cancelled Successfully</h2>" +

            "<p>Your booking has been removed.</p>" +

            "<a href='MyBookingsServlet' class='btn btn-primary m-2'>" +
            "View My Bookings" +
            "</a>" +

            "<a href='dashboard.jsp' class='btn btn-success m-2'>" +
            "Dashboard" +
            "</a>" +

            "</div>" +

            "</div>" +

            "</body>" +
            "</html>"
            );

        } else {

            response.getWriter().println(

            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset='UTF-8'>" +
            "<title>Cancel Ticket</title>" +

            "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>" +

            "</head>" +

            "<body style='background:#f4f6f9;'>" +

            "<div class='container mt-5'>" +

            "<div class='alert alert-danger text-center shadow'>" +

            "<h2>Ticket Not Found</h2>" +

            "<a href='MyBookingsServlet' class='btn btn-primary m-2'>" +
            "Back" +
            "</a>" +

            "</div>" +

            "</div>" +

            "</body>" +
            "</html>"
            );
        }
    }
}