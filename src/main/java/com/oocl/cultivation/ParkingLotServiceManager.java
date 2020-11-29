package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy{
    private List<ParkingBoy> managementList;

    public ParkingLotServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.managementList = new ArrayList<>();
    }
    public void addToManagementList(ParkingBoy parkingBoy) {
        this.managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList() {
        return this.managementList;
    }

    public Ticket specifyParkingBoyToPark(ParkingBoy parkingBoy, Car car) throws NotEnoughPositionException {
        if (this.managementList.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }

    public Car specifyParkingBoyToFetch(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicketException {
        if (this.managementList.contains(parkingBoy)) {
            return parkingBoy.fetchCar(ticket);
        }
        return null;
    }

    public void removeFromManagementList(ParkingBoy parkingBoy) {
        this.managementList.remove(parkingBoy);
    }
}
