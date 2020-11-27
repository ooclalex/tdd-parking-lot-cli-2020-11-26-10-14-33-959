package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_a_parking_ticket_when_park_the_car_given_a_car_and_parking_lot_with_available_capacity() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        // when
        final Ticket ticket = parkingLot.park(car);

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_be_parked_when_park_multiple_cars_given_multiple_cars_and_parking_lot_with_available_capacity() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        final Ticket ticket1 = parkingLot.park(car1);
        final Ticket ticket2 = parkingLot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1, ticket2);
    }
}
