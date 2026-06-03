package com.trainreservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainreservation.dao.BookingDAO;
import com.trainreservation.model.Booking;

@WebServlet("/ViewAllBookingsServlet")
public class ViewAllBookingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BookingDAO dao = new BookingDAO();

        ArrayList<Booking> bookings =
        dao.getAllBookings();

        request.setAttribute("bookings", bookings);

        request.getRequestDispatcher(
        "viewAllBookings.jsp")
        .forward(request, response);
    }
}