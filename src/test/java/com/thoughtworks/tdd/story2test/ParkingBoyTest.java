package com.thoughtworks.tdd.story2test;

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
    public void should_return_message_Unrecongnized_parking_ticket_when_given_wrong_ticket() throws Exception{
        //given
        Car car = new Car("C：12138");
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket wrongTicket = new Ticket();
        //then
        String exceptionMessage = Assertions.assertThrows(Exception.class, () -> parkingBoy.fetchCar(wrongTicket)).getMessage();
        Assertions.assertTrue(exceptionMessage.contains("Unrecognized parking ticket"));

    }

    @Test
    public void should_return_prompt_message_when_does_not_privide_ticket()throws Exception{
        //given
        Car car = new Car("C：12138");
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket nullTicket = null;
        //then
        String exceptionMessage = Assertions.assertThrows(Exception.class, () -> parkingBoy.fetchCar(nullTicket)).getMessage();
        Assertions.assertTrue(exceptionMessage.contains("Please provide your parking ticket"));

    }

    @Test
    public void should_return_prompt_message_not_enough_position_when_parkinglot_has_not_enough_position() throws Exception{
        //given
        List<Car> Cars = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Cars.add(new Car(String.format("C:121 %s","0"+i)));
        }
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        for (Car element : Cars) {
            parkingBoy.parkCar(element);
        }
        //then
        String exceptionMessage = Assertions.assertThrows(Exception.class, () -> parkingBoy.parkCar(new Car("12110"))).getMessage();
        Assertions.assertTrue(exceptionMessage.contains("Not enough position"));
    }
}
