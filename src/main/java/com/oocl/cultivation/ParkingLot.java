package com.oocl.cultivation;


import java.util.HashMap;

public class ParkingLot {
    private int capacity;
    private HashMap<Ticket, Car> ticketCarHashMap;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.ticketCarHashMap = new HashMap<>();
    }

    public Ticket park(Car car) {
        if (this.capacity <= ticketCarHashMap.size()) {
            return null;
        }
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        return ticketCarHashMap.get(ticket);
    }
}
