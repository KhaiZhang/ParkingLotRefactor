package com.thoughtworks.tdd.story5test;

import com.thoughtworks.tdd.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_parking_car_into_secondParkingLot_when_secondParkinglot_position_better_used() throws Exception{
        //given
        List<Car> Cars = new ArrayList<>();
        for (int i = 0; i <12 ; i++) {
            Cars.add(new Car(String.format("C:121 %s","0"+i)));
        }
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(30);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        //when
        for (int i = 0; i <6 ; i++) {
            parkingBoy.parkCar(Cars.get(i));
        }
        for (int i = 6; i <12 ; i++) {
            smartParkingBoy.parkCar(Cars.get(i));
        }
        Ticket ticket = superSmartParkingBoy.parkCar(new Car("C:12106"));
        //then
        assertThat(secondParkingLot.isTheTicketForThisParkingLot(ticket), is(true));
    }
}
