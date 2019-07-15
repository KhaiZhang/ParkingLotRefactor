package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return (ArrayList<ParkingLot>)parkingLots.clone();
    }

    public Ticket parkCar(Car car) throws Exception{
        try {
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.isParkingSpaceRemain())
                    .findFirst()
                    .get()
                    .parkCarIntoParkingLot(car);
        }catch (NoSuchElementException ex){
            throw  new Exception("Not enough position");
        }
    }

    public Car fetchCar(Ticket ticket) throws Exception {
        if(ticket == null){
            throw new Exception("Please provide your parking ticket");
        }
        try {
            return parkingLots.stream()
                    .filter(currentParkingLot -> currentParkingLot.isTheTicketForThisParkingLot(ticket))
                    .findFirst()
                    .get()
                    .takeCarOutOfParkingLot(ticket);
        }catch (NoSuchElementException ex){
            throw new NoSuchElementException("Unrecognized parking ticket");
        }
    }
}
