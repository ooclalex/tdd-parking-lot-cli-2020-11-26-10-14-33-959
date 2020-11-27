package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

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
}
