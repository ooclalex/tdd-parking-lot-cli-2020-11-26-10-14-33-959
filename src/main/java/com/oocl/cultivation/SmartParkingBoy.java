package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot emptyParkingLot = this.getParkingLots().stream().max(
                Comparator.comparing(ParkingLot::getNumEmptyPositions)).orElse(null);
        if (emptyParkingLot != null) {
            return emptyParkingLot.park(car);
        }
        throw new NotEnoughPositionException();
    }
}
