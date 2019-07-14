package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingCarTicke;

    public ParkingLot() {
        this.parkingCarTicke = new HashMap<>();
    }

    public Ticket parkCarIntoParkingLot(Car car){
        Ticket ticketNumber = new Ticket();
        parkingCarTicke.put(ticketNumber,car);
        return ticketNumber;
    }

    public Car takeCarOutOfParkingLot(Ticket ticket){
        return parkingCarTicke.get(ticket);
    }
}
