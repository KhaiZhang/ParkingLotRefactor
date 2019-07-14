package com.thoughtworks.tdd.story3test;

import com.thoughtworks.tdd.Car;
import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingLot;
import com.thoughtworks.tdd.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingBoyTest {
    @Test
    public void should_parking_car_to_second_parkinglot_first_parkinglot_is_full() throws Exception{
        //given
        List<Car> Cars = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Cars.add(new Car(String.format("C:121 %s","0"+i)));
        }
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        for (Car element : Cars) {
            parkingBoy.parkCar(element);
        }
        Car car = new Car("C:12111");
        Ticket ticket = parkingBoy.parkCar(car);
        Car fetchedCar = parkingBoy.fetchCar(ticket);
        //then
        assertThat(fetchedCar, is(car));
    }
}
