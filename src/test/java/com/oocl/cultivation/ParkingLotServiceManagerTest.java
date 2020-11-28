package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotServiceManagerTest {
    @Test
    void should_add_parking_boys_to_management_list_when_add_parking_boy_given_manager_and_parking_boys()  {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager();
        ParkingBoy parkingBoy = new ParkingBoy(new ArrayList<>());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy((new ArrayList<>()));

        //when
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);

        //then
        assertEquals(3, manager.getManagementList().size());
    }
}
