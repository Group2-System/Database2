package com.mycompany.attendancesystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;




/**
 *
 * @author sharon
 */
public class RFID2 {
     private static final String DB_URL = "jdbc:ucanaccess://C;//Users//sharon//Documents//Database2.accdb";

    public static void main(String[] args) {
        // Simulate reading RFID data
        String tagId = readRFID(); // Replace with actual RFID reading logic

         if (tagId != null && !tagId.isEmpty()) {
            insertRFIDData(tagId);
        } else {
            System.out.println("Invalid Tag ID. Please try again.");
       
        }
}

private static String readRFID() {
        // Implement your RFID reading logic here
        // For demonstration, returning a dummy RFID tag
        return "0011778618";
        
    }
  private static void insertRFIDData(String tagId) {
        String insertSQL = "INSERT INTO RFID (TagID, Timestamp) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, tagId);
            pstmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}