package com.thoughtworks.tdd.story4test;

import com.thoughtworks.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmartParkingBoyTest {
    @Test
    public void should_parking_car_into_secondParkingLot_when_secondParkinglot_has_more_position() throws Exception{
        //given
        List<Car> Cars = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            Cars.add(new Car(String.format("C:121 %s","0"+i)));
        }
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        for (Car element : Cars) {
            parkingBoy.parkCar(element);
        }
        Ticket ticket = smartParkingBoy.parkCar(new Car("C:12106"));
        //then
        assertThat(secondParkingLot.isTheTicketForThisParkingLot(ticket), is(true));

    }
}
