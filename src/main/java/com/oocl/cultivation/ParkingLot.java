package com.oocl.cultivation;


public class ParkingLot {
    private int capacity;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (this.capacity <= 0) {
            return null;
        }
        this.capacity--;
        return new Ticket(car);
    }

    public Car fetchCar(Ticket ticket) {
        return null;
    }
}
