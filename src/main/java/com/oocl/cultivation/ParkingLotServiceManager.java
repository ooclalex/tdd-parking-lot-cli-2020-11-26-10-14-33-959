package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager {
    private List<ParkingBoy> managementList;

    public ParkingLotServiceManager() {
        managementList = new ArrayList<>();
    }
    public void addToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList() {
        return this.managementList;
    }

    public Ticket specifyParkingBoyToPark(ParkingBoy parkingBoy, Car car) {
        return null;
    }
}
