package com.thoughtworks.tdd.story6test;

import com.thoughtworks.tdd.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MangerTest {
    @Test
    public void should_return_car_when_given_ticket() throws Exception{
        //given
        Car car = new Car("C：12138");
        ParkingLot parkingLot = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Manager manager = new Manager();
        manager.addParkingBoy(parkingBoy);
        manager.addParkingBoy(smartParkingBoy);
        //when
        Ticket ticket = manager.orderParkingBoyParkCar(car,parkingBoy);
        Car actualCar = manager.orderParkingBoyFetchCar(ticket,parkingBoy);
        //then
        assertThat(car, is(actualCar));
    }
}
