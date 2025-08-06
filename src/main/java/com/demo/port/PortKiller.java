package com.demo.port;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PortKiller {

    public static void freePort(int port) {
        try {
            // Find the process using netstat
            Process p1 = Runtime.getRuntime().exec("netstat -ano | findstr :" + port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line;
            int pid = -1;

            while ((line = reader.readLine()) != null) {
                String[] cols = line.trim().split("\\s+");
                pid = Integer.parseInt(cols[cols.length - 1]);
                break;
            }

            if (pid > 0) {
                Runtime.getRuntime().exec("taskkill /F /PID " + pid);
                System.out.println("Killed process " + pid + " on port " + port);
            } else {
                System.out.println("No process found on port " + port);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        freePort(8080);
    }
}
