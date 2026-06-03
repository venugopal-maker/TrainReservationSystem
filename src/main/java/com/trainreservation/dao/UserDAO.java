package com.trainreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.trainreservation.model.User;
import com.trainreservation.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.trainreservation.model.User;
import com.trainreservation.util.DBConnection;

public class UserDAO {

    // Registration

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO users(name,email,password,mobile) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getMobile());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Login

    public User loginUser(String email, String password) {

        User user = null;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

            	user = new User();

            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	user.setPassword(rs.getString("password"));
            	user.setMobile(rs.getString("mobile"));
            	user.setRole(rs.getString("role"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    //password change
    public boolean changePassword(
            String email,
            String oldPassword,
            String newPassword) {

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            String sql =
            "UPDATE users SET password=? WHERE email=? AND password=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.setString(3, oldPassword);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public ArrayList<User> getAllUsers() {

        ArrayList<User> list =
        new ArrayList<User>();

        try {

            Connection con =
            DBConnection.getConnection();

            String sql =
            "SELECT * FROM users";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery();

            while(rs.next()) {

                User user =
                new User();

                user.setId(
                rs.getInt("id"));

                user.setName(
                rs.getString("name"));

                user.setEmail(
                rs.getString("email"));

                user.setMobile(
                rs.getString("mobile"));

                user.setRole(
                rs.getString("role"));

                list.add(user);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}