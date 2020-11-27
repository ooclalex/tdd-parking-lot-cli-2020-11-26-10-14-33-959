package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {
    @Test
    void should_return_a_parking_ticket_when_park_the_car_given_a_car_and_parking_lot_with_available_capacity() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

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
        ParkingLot parkingLot = new ParkingLot(2);

        //when
        final Ticket ticket1 = parkingLot.park(car1);
        final Ticket ticket2 = parkingLot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void should_only_one_car_parked_when_park_multiple_cars_given_multiple_cars_and_parking_lot_with_one_capacity() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        final Ticket ticket1 = parkingLot.park(car1);
        final Ticket ticket2 = parkingLot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNull(ticket2);
    }

    @Test
    void should_return_car_when_fetch_car_given_parking_ticket_parking_lot_that_parked_the_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetchCar(ticket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_not_return_car_when_fetch_car_given_used_parking_ticket_parking_lot_that_parked_the_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car fetchCar = parkingLot.fetchCar(ticket);
        Car actualCar = parkingLot.fetchCar(ticket);

        //then
        assertNull(actualCar);
    }

    @Test
    void should_not_return_car_when_fetch_car_given_fake_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket fakeTicket = new Ticket();

        //when
        Car fetchCar = parkingLot.fetchCar(fakeTicket);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_throw_not_enough_position_exception_when_park_car_given_parking_lot_with_full_capacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        assertThrows(NotEnoughPositionException.class,() -> parkingLot.park(new Car()), "Not Enough Position");

        //when

        //then
        verify(parkingLot, times(1)).park(car);
    }
}
