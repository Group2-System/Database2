/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.attendancesystem;


import java.sql.*;

/**
 *
 * @author sharon
 */
public class rfidDB {
    
    
    private static final String DB_PATH = "jdbc:ucanaccess://C;//Users//sharon//Documents//Database2.accdb"; // Replace with actual path

    // Method to connect and insert RFID data
    public static void insertRFID(String tagCode) {
        String url = "jdbc:ucanaccess://" + DB_PATH;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO RFID  (TagCode) VALUES (?)")) {

            pstmt.setString(1, tagCode);
            pstmt.executeUpdate();
            System.out.println("RFID inserted: " + tagCode);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
