package com.mycompany.attendancesystem;

import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class rffid {

    // Static method to read the RFID tag
    public static String readRFID() {
        SerialPort[] ports = SerialPort.getCommPorts();
        if (ports.length == 0) {
            System.out.println("No COM ports found.");
            return null;
        }

        SerialPort comPort = ports[0];  // Use the first available COM port
        comPort.setBaudRate(9600);  // Set the baud rate to match your RFID reader
        comPort.openPort();

        InputStream inputStream = comPort.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String rfidTag = null;

        try {
            rfidTag = reader.readLine().trim();  // Read the RFID tag and trim any extra spaces
            System.out.println("RFID Tag: " + rfidTag);
        } catch (Exception e) {
            System.out.println("Error while reading RFID tag: " + e.getMessage());
            e.printStackTrace();
        } finally {
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
}
