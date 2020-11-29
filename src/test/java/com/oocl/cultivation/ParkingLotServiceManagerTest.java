package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_parking_boy_park_car_when_parking_manager_specify_parking_boy_given_manager_and_parking_boy_in_management_list() throws NotEnoughPositionException {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager();
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        manager.addToManagementList(parkingBoy);
        Car car = new Car();

        //when
        Ticket ticket = manager.specifyParkingBoyToPark(parkingBoy, car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_parking_manager_specify_parking_boy_not_in_list_given_manager_and_parking_boy() throws NotEnoughPositionException {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager();
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();

        //when
        Ticket ticket = manager.specifyParkingBoyToPark(parkingBoy, car);

        //then
        assertNull(ticket);
    }

    @Test
    void should_parking_boy_fetch_car_when_parking_manager_specify_parking_boy_given_manager_and_parking_boy_in_management_list() throws NotEnoughPositionException {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager();
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        manager.addToManagementList(parkingBoy);
        Car car = new Car();
        Ticket ticket = manager.specifyParkingBoyToPark(parkingBoy, car);

        //when
        Car fetchedCar = manager.specifyParkingBoyToFetch(parkingBoy, ticket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_null_when_parking_manager_specify_parking_boy_not_in_list_to_fetch_car_given_manager_and_parking_boy() throws NotEnoughPositionException {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager();
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        Ticket ticket = manager.specifyParkingBoyToPark(parkingBoy, car);
        manager.removeFromManagementList(parkingBoy);

        //when
        Car fetchedCar = manager.specifyParkingBoyToFetch(parkingBoy, ticket);

        //then
        assertNull(fetchedCar);
    }
}
