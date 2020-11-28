package com.oocl.cultivation;

public class UnrecognizedParkingTicketException extends Throwable {
    public UnrecognizedParkingTicketException() {
        super("Unrecognized Parking Ticket");
    }
}
