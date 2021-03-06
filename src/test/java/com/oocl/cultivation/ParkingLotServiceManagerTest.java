package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceManagerTest {
    @Test
    void should_add_parking_boys_to_management_list_when_add_parking_boy_given_manager_and_parking_boys()  {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
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
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
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
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
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
    void should_parking_boy_fetch_car_when_parking_manager_specify_parking_boy_given_manager_and_parking_boy_in_management_list() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
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
    void should_return_null_when_parking_manager_specify_parking_boy_not_in_list_to_fetch_car_given_manager_and_parking_boy() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
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

    @Test
    void should_return_ticket_when_parking_manager_parks_car_given_manager_and_car() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(parkingLotList);
        Car car = new Car();

        //when
        Ticket ticket = manager.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_parking_manager_fetch_car_given_manager_and_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(parkingLotList);
        Car car = new Car();
        Ticket ticket = manager.park(car);

        //when
        Car fetchedCar = manager.fetchCar(ticket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_throw_not_enough_position_exception_when_parking_manager_specify_parking_boy_to_park_given_parking_manager_parking_boy_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
        manager.addToManagementList(parkingBoy);
        Car car = new Car();

        //when
        NotEnoughPositionException notEnoughPosition = assertThrows(NotEnoughPositionException.class,() -> manager.specifyParkingBoyToPark(parkingBoy, car));

        //then
        assertEquals("Not Enough Position", notEnoughPosition.getMessage());
    }

    @Test
    void should_throw_unrecognized_ticket_exception_when_parking_manager_specify_parking_boy_to_fetch_given_parking_manager_parking_boy_ticket() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(new ArrayList<>());
        manager.addToManagementList(parkingBoy);
        Car car = new Car();
        manager.specifyParkingBoyToPark(parkingBoy, car);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class,() ->
                manager.specifyParkingBoyToFetch(parkingBoy, new Ticket()));

        //then
        assertEquals("Unrecognized Parking Ticket", unrecognizedParkingTicketException.getMessage());
    }
}
