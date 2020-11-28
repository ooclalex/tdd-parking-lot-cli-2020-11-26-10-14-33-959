package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkingBoyTest {

    @Test
    void should_park_in_larger_available_position_rate_parking_lot_when_park_the_car_given_super_smart_parking_boy_parking_lots()
            throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertEquals(car, parkingLot1.fetchCar(ticket));
    }

    @Test
    void should_throw_not_enough_position_exception_when_park_the_car_given_super_smart_parking_boy_full_parking_lots() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);

        //when
        NotEnoughPositionException notEnoughPosition =
                assertThrows(NotEnoughPositionException.class,() -> smartParkingBoy.park(new Car()));

        //then
        assertEquals("Not Enough Position", notEnoughPosition.getMessage());
    }
}
