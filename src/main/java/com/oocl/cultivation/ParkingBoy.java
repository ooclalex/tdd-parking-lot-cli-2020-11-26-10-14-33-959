package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        for (ParkingLot parkingLot: parkingLots) {
            try {
                return parkingLot.park(car);
            }
            catch (NotEnoughPositionException ignored) {

            }
        }
        throw new NotEnoughPositionException();
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
