package com.trainreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trainreservation.model.Booking;
import com.trainreservation.model.Passenger;
import com.trainreservation.util.DBConnection;

public class BookingDAO {

    
    // SAVE BOOKING
    public boolean saveBooking(Booking booking) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO bookings(pnr,passenger_name,age,gender,train_name,source,destination,journey_date,fare) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, booking.getPnr());
            ps.setString(2, booking.getPassengerName());
            ps.setInt(3, booking.getAge());
            ps.setString(4, booking.getGender());
            ps.setString(5, booking.getTrainName());
            ps.setString(6, booking.getSource());
            ps.setString(7, booking.getDestination());
            ps.setString(8, booking.getJourneyDate());
            ps.setDouble(9, booking.getFare());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    
    // SAVE BOOKING + PASSENGERS
   
    public boolean saveBookingWithPassengers(
            Booking booking,
            List<Passenger> passengers) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            // Save Main Booking
            String bookingSql =
            		"INSERT INTO bookings(pnr,passenger_name,age,gender,train_name,source,destination,journey_date,fare) VALUES(?,?,?,?,?,?,?,?,?)";
            
            
            PreparedStatement bookingPs =
            con.prepareStatement(bookingSql);

            bookingPs.setString(1, booking.getPnr());
            bookingPs.setString(2, booking.getPassengerName());
            bookingPs.setInt(3, booking.getAge());
            bookingPs.setString(4, booking.getGender());
            bookingPs.setString(5, booking.getTrainName());
            bookingPs.setString(6, booking.getSource());
            bookingPs.setString(7, booking.getDestination());
            bookingPs.setString(8, booking.getJourneyDate());
            bookingPs.setDouble(9, booking.getFare());

            int bookingRows =
            bookingPs.executeUpdate();

            // Save Passenger Details
            String passengerSql =
            "INSERT INTO passenger_details(pnr,passenger_name,age,gender,coach,seat_no,berth) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement passengerPs =
            con.prepareStatement(passengerSql);

            for(Passenger p : passengers) {

                passengerPs.setString(1, booking.getPnr());
                passengerPs.setString(2, p.getPassengerName());
                passengerPs.setInt(3, p.getAge());
                passengerPs.setString(4, p.getGender());
                passengerPs.setString(5, p.getCoach());
                passengerPs.setInt(6, p.getSeatNo());
                passengerPs.setString(7, p.getBerth());

                passengerPs.executeUpdate();
            }

            if(bookingRows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    
    // GET ALL BOOKINGS
    
    public ArrayList<Booking> getAllBookings() {

        ArrayList<Booking> list =
        new ArrayList<>();

        try {

            Connection con =
            DBConnection.getConnection();

            String sql =
            "SELECT * FROM bookings";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery();

            while(rs.next()) {

                Booking booking =
                new Booking();

                booking.setPnr(
                rs.getString("pnr"));

                booking.setPassengerName(
                rs.getString("passenger_name"));

                booking.setAge(
                rs.getInt("age"));

                booking.setGender(
                rs.getString("gender"));

                booking.setTrainName(
                rs.getString("train_name"));

                booking.setSource(
                rs.getString("source"));

                booking.setDestination(
                rs.getString("destination"));

                booking.setJourneyDate(
                rs.getString("journey_date"));

                booking.setFare(
                rs.getDouble("fare"));

                list.add(booking);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    // CANCEL BOOKING
   
    public boolean cancelBooking(String pnr) {

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            // Delete Passenger Records
            String passengerSql =
            "DELETE FROM passenger_details WHERE pnr=?";

            PreparedStatement passengerPs =
            con.prepareStatement(passengerSql);

            passengerPs.setString(1, pnr);

            passengerPs.executeUpdate();

            // Delete Booking Record
            String bookingSql =
            "DELETE FROM bookings WHERE pnr=?";

            PreparedStatement bookingPs =
            con.prepareStatement(bookingSql);

            bookingPs.setString(1, pnr);

            int rows =
            bookingPs.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            System.out.println("ERROR FOUND:");
            e.printStackTrace();
        }

        return status;
    }
    
    public Booking getBookingByPnr(String pnr) {

        Booking booking = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT * FROM bookings WHERE pnr=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, pnr);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                booking = new Booking();

                booking.setPnr(rs.getString("pnr"));
                booking.setPassengerName(rs.getString("passenger_name"));
                booking.setAge(rs.getInt("age"));
                booking.setGender(rs.getString("gender"));
                booking.setTrainName(rs.getString("train_name"));
                booking.setSource(rs.getString("source"));
                booking.setDestination(rs.getString("destination"));
                booking.setJourneyDate(rs.getString("journey_date"));
                booking.setFare(rs.getDouble("fare"));
            }
            
            

        } catch(Exception e) {
            e.printStackTrace();
        }

        return booking;
    }
    
    public ArrayList<Passenger> getPassengersByPnr(String pnr) {

        ArrayList<Passenger> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT * FROM passenger_details WHERE pnr=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, pnr);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Passenger p = new Passenger();

                p.setPassengerName(
                rs.getString("passenger_name"));

                p.setAge(
                rs.getInt("age"));

                p.setGender(
                rs.getString("gender"));

                p.setCoach(
                rs.getString("coach"));

                p.setSeatNo(
                rs.getInt("seat_no"));

                p.setBerth(
                rs.getString("berth"));

                list.add(p);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}