package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot largerAvailablePositionRateParkingLot = this.getParkingLots().stream().min(
                Comparator.comparing(lot -> lot.getNumEmptyPositions() / lot.getCapacity())).orElse(null);
        if (largerAvailablePositionRateParkingLot != null) {
            return largerAvailablePositionRateParkingLot.park(car);
        }
        throw new NotEnoughPositionException();
    }
}
