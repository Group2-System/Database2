/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.attendancesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sharon
 */
public class DATABASE_1 {
    
    
    
/**
 *
 * @author sharon
 */
public class ConnectMsAccess {
    
    public static Connection conn () {

        try{
        String url = "jdbc:ucanaccess://C;//Users//sharon//Documents//Database2.accdb";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return null;    
    }
}
}
