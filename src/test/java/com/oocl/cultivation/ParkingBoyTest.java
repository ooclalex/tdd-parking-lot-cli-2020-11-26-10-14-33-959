package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {
    @Test
    void should_parking_boy_call_parking_lot_park_function_once_when_park_the_car_given_parking_boy_car_parking_lot_with_available_capacity() throws NotEnoughPositionException {
        // given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        // when
        parkingBoy.park(car);

        // then
        verify(parkingLot, times(1)).park(car);
    }

    @Test
    void should_return_a_car_when_fetch_the_car_given_parking_boy_parking_ticket_and_parking_lot_with_available_capacity() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        // given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        // when
        parkingBoy.fetchCar(ticket);

        // then
        verify(parkingLot, times(1)).fetchCar(ticket);
    }
}
