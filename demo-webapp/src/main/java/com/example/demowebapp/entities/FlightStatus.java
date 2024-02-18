package com.example.demowebapp.entities;

public enum FlightStatus {

    ONTIME("On time"),
    DELAYED("Delayed"),
    CANCELLED("Cancelled");
    private String status;
    private FlightStatus(String a) {
        this.status = a;
    }

    public static boolean isValidFlightStatus(String str) {
        try {
            FlightStatus.valueOf(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return status;
    }
}