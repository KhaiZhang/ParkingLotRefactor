package com.thoughtworks.tdd.story1test;

import com.thoughtworks.tdd.Car;
import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingLot;
import com.thoughtworks.tdd.Ticket;
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
}
