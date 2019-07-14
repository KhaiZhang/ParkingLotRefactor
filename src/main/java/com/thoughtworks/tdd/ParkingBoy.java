package com.thoughtworks.tdd;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
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
