package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {
    @Test
    void should_parking_boy_call_parking_lot_park_function_once_when_park_the_car_given_parking_boy_car_parking_lot_with_available_capacity() throws NotEnoughPositionException {
        // given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        // when
        parkingBoy.fetchCar(ticket);

        // then
        verify(parkingLot, times(1)).fetchCar(ticket);
    }

    @Test
    void should_park_in_second_parking_lot_when_park_the_car_given_parking_boy_parking_lot_1_with_full_capacity_parking_lot_2_with_available_capacity() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingBoy.park(car1);

        //when
        Ticket ticket = parkingBoy.park(car2);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_in_second_parking_lot_when_fetch_the_car_given_parking_boy_parking_lots_and_ticket_for_car_in_second_parking_lot() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingBoy.park(car1);
        Ticket ticket = parkingBoy.park(car2);

        //when
        Car car = parkingBoy.fetchCar(ticket);

        //then
        assertNotNull(car);
    }

    @Test
    void should_throw_not_enough_position_exception_when_park_the_car_given_parking_boy_car_and_two_full_parking_lots() throws NotEnoughPositionException{
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        //when
        NotEnoughPositionException notEnoughPosition =
                assertThrows(NotEnoughPositionException.class,() -> parkingBoy.park(new Car()));


        //then
        assertEquals("Not Enough Position", notEnoughPosition.getMessage());
    }
}
