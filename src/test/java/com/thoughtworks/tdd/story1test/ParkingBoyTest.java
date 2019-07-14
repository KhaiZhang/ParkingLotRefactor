package com.thoughtworks.tdd.story1test;

import com.thoughtworks.tdd.Car;
import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingLot;
import com.thoughtworks.tdd.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ParkingBoyTest {
    @Test
    public void should_return_car_when_given_ticket() {
        //given
        Car car = new Car("C：12138");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        Car actualCar = parkingBoy.fetchCar(ticket);
        //then
        assertThat(actualCar, is(car));
    }

    @Test
    public void should_return_multiple_cars_when_given_correspond_ticket() {
        //given
        Car firstCar = new Car("C：12138");
        Car secondCar = new Car("C：12306");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket firstTicket = parkingBoy.parkCar(firstCar);
        Car actualFirstCar = parkingBoy.fetchCar(firstTicket);
        Ticket secondTicket = parkingBoy.parkCar(secondCar);
        Car actualSecondCar = parkingBoy.fetchCar(secondTicket);

        //then
        assertThat(actualFirstCar, is(firstCar));
        assertThat(actualSecondCar, is(secondCar));
    }

    @Test
    public void should_not_return_car_when_given_wrong_ticket() throws NullPointerException{
        //given
        Car car = new Car("C：12138");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket nullTicket = null;
        Ticket wrongTicket = new Ticket();
        //then
        Assertions.assertThrows(NullPointerException.class,() ->parkingBoy.fetchCar(nullTicket));
        Assertions.assertThrows(NullPointerException.class,() ->parkingBoy.fetchCar(wrongTicket));
    }
}
