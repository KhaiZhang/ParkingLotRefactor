package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingCarTicket;
    private static  int capacity = 10;

    public ParkingLot() {
        this.parkingCarTicket = new HashMap<>();
    }

    public Ticket parkCarIntoParkingLot(Car car) throws Exception{
        if(parkingCarTicket.size() >= capacity){
            throw new Exception("Not enough position");
        }
        else {
            Ticket ticketNumber = new Ticket();
            parkingCarTicket.put(ticketNumber,car);
            return ticketNumber;
        }
    }

    public Car takeCarOutOfParkingLot(Ticket ticket){
        if(ticket == null){
            throw new NullPointerException("Please provide your parking ticket");
        }
        Car car = parkingCarTicket.get(ticket);
       if(car == null){
           throw new NullPointerException("Unrecognized parking ticket");
       }
       parkingCarTicket.remove(ticket);
       return car;
    }

    public boolean isParkingSpaceRemain(){
        return parkingCarTicket.size() < capacity ? true : false;
    }

    public boolean isTheTicketForThisParkingLot(Ticket ticket){
        return parkingCarTicket.containsKey(ticket);
    }
}
