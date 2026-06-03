package com.trainreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.trainreservation.model.Train;
import com.trainreservation.util.DBConnection;

public class TrainDAO {

    // Get All Trains
    public ArrayList<Train> getAllTrains() {

        ArrayList<Train> trains = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM trains";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Train train = new Train();

                train.setTrainId(rs.getInt("train_id"));
                train.setTrainNo(rs.getString("train_no"));
                train.setTrainName(rs.getString("train_name"));
                train.setSource(rs.getString("source"));
                train.setDestination(rs.getString("destination"));
                train.setDepartureTime(rs.getString("departure_time"));
                train.setArrivalTime(rs.getString("arrival_time"));
                train.setFare(rs.getDouble("fare"));

                trains.add(train);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return trains;
    }

    // Get Train By ID
    public Train getTrainById(int trainId) {

        Train train = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT * FROM trains WHERE train_id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1, trainId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                train = new Train();

                train.setTrainId(rs.getInt("train_id"));
                train.setTrainNo(rs.getString("train_no"));
                train.setTrainName(rs.getString("train_name"));
                train.setSource(rs.getString("source"));
                train.setDestination(rs.getString("destination"));
                train.setDepartureTime(rs.getString("departure_time"));
                train.setArrivalTime(rs.getString("arrival_time"));
                train.setFare(rs.getDouble("fare"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return train;
    }

    // Update Train
    public boolean updateTrain(Train train) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "UPDATE trains SET train_no=?, train_name=?, source=?, destination=?, departure_time=?, arrival_time=?, fare=? WHERE train_id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, train.getTrainNo());
            ps.setString(2, train.getTrainName());
            ps.setString(3, train.getSource());
            ps.setString(4, train.getDestination());
            ps.setString(5, train.getDepartureTime());
            ps.setString(6, train.getArrivalTime());
            ps.setDouble(7, train.getFare());
            ps.setInt(8, train.getTrainId());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Delete Train
    public boolean deleteTrain(int trainId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "DELETE FROM trains WHERE train_id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1, trainId);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    //add
    public boolean addTrain(Train train) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO trains(train_no,train_name,source,destination,departure_time,arrival_time,fare) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, train.getTrainNo());
            ps.setString(2, train.getTrainName());
            ps.setString(3, train.getSource());
            ps.setString(4, train.getDestination());
            ps.setString(5, train.getDepartureTime());
            ps.setString(6, train.getArrivalTime());
            ps.setDouble(7, train.getFare());

            int rows = ps.executeUpdate();

            if(rows > 0){
                status = true;
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
}