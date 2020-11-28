package com.oocl.cultivation;


import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private final HashMap<Ticket, Car> ticketCarHashMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.ticketCarHashMap = new HashMap<>();
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        if (this.capacity <= ticketCarHashMap.size()) {
            throw new NotEnoughPositionException();
        }
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car fetchedCar = ticketCarHashMap.get(ticket);
        ticketCarHashMap.remove(ticket);
        if (fetchedCar == null) {
            throw new UnrecognizedParkingTicketException();
        }
        return fetchedCar;
    }

    public int getNumEmptyPositions() {
        return capacity - this.ticketCarHashMap.size();
    }
}
