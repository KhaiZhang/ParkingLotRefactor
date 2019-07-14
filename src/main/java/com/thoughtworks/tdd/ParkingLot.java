package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingCarTicket;
    private static  int capacity = 10;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>();
    }

    public Ticket parkCarIntoParkingLot(Car car){
        if(parkingCarTicket.size() >= capacity){
            return null;
        }
        else {
            Ticket ticketNumber = new Ticket();
            parkingCarTicket.put(ticketNumber,car);
            return ticketNumber;
        }
    }

    public Car takeCarOutOfParkingLot(Ticket ticket){
        Car car =parkingCarTicket.get(ticket);
       if(car == null){
           throw new NullPointerException("ticket is null or wrong");
       }
       parkingCarTicket.remove(ticket);
       return car;
    }
}
