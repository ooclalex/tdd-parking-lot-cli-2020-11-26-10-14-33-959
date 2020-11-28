package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    @Test
    void should_park_in_emptier_parking_lot_when_park_the_car_given_smart_parking_boy_parking_lots() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        smartParkingBoy.park(car1);

        //when
        Ticket ticket = smartParkingBoy.park(car2);

        //then
        assertEquals(car2, parkingLot2.fetchCar(ticket));
    }

    @Test
    void should_throw_not_enough_position_exception_when_park_the_car_given_smart_parking_boy_full_parking_lots() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);

        //when
        NotEnoughPositionException notEnoughPosition =
                assertThrows(NotEnoughPositionException.class,() -> smartParkingBoy.park(new Car()));

        //then
        assertEquals("Not Enough Position", notEnoughPosition.getMessage());
    }
}
