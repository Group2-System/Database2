package com.mycompany.attendancesystem;

import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class NewClass {

    public static String readRFID() {
        // Get available serial ports
        SerialPort[] ports = SerialPort.getCommPorts();
        if (ports.length == 0) {
            System.out.println("No COM ports found.");
            return null;
        }

        // Choose the first available COM port
        SerialPort comPort = ports[0]; 
        comPort.setBaudRate(9600);  // Match the baud rate with your RFID reader
        comPort.setNumDataBits(8);  // Set data bits to 8
        comPort.setNumStopBits(1);  // Set stop bits to 1
        comPort.setParity(SerialPort.NO_PARITY);  // Set parity to none

        // Open the port
        if (!comPort.openPort()) {
            System.out.println("Failed to open the COM port.");
            return null;
        }

        System.out.println("Waiting for RFID input...");

        InputStream inputStream = comPort.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String rfidTag = null;

        try {
            // Read the RFID tag from the serial input stream
            rfidTag = reader.readLine().trim();  // Read a line and trim it
            System.out.println("RFID Tag: " + rfidTag);
        } catch (Exception e) {
            System.out.println("Error while reading RFID tag: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (reader != null) {
                    reader.close();
                }
                comPort.closePort();
            } catch (Exception e) {
                System.out.println("Error while closing resources: " + e.getMessage());
            }
        }

        return rfidTag;
    }

    public static void main(String[] args) {
        String rfid = readRFID();
        if (rfid != null) {
             System.out.println("RFID tag read: " + rfid);
        } else {
            System.out.println("No RFID tag detected.");
        }
    }
}