package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car)  {
        for (ParkingLot parkingLot: parkingLots) {
            try {
                return parkingLot.park(car);
            }
            catch (NotEnoughPositionException ignored) {

            }
        }
        return null;
    }

    public Car fetchCar(Ticket ticket) {
        for (ParkingLot parkingLot: parkingLots) {
            try {
                return parkingLot.fetchCar(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {

            }
        }
        return null;
    }
}
