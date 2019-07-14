package com.thoughtworks.tdd.story2test;

import com.thoughtworks.tdd.Car;
import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingLot;
import com.thoughtworks.tdd.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingBoyTest {
    @Test
    public void should_message_Unrecongnized_parking_ticket_when_given_wrong_ticket() throws NullPointerException{
        //given
        Car car = new Car("C：12138");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket wrongTicket = new Ticket();
        //then
        String exceptionMessage = Assertions.assertThrows(NullPointerException.class, () -> parkingBoy.fetchCar(wrongTicket)).getMessage();
        Assertions.assertTrue(exceptionMessage.contains("Unrecognized parking ticket"));

    }
}
