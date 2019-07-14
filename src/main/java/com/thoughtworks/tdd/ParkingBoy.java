package com.thoughtworks.tdd;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) throws Exception{
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isParkingSpaceRemain())
                .findFirst()
                .get()
                .parkCarIntoParkingLot(car);
    }

    public Car fetchCar(Ticket ticket) throws NullPointerException{
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isTheTicketForThisParkingLot(ticket))
                .findAny()
                .get()
                .takeCarOutOfParkingLot(ticket);
    }
}
