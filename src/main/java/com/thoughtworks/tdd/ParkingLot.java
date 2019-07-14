package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingCarTicket;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>();
    }

    public Ticket parkCarIntoParkingLot(Car car){
        Ticket ticketNumber = new Ticket();
        parkingCarTicket.put(ticketNumber,car);
        return ticketNumber;
    }

    public Car takeCarOutOfParkingLot(Ticket ticket){
       if(parkingCarTicket.get(ticket) == null){
           throw new NullPointerException("ticket is null or wrong");
       }
       return parkingCarTicket.get(ticket);
    }
}
