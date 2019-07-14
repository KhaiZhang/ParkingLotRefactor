package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car) throws Exception{
        return parkingLot.parkCarIntoParkingLot(car);
    }

    public Car fetchCar(Ticket ticket) throws NullPointerException{
        return parkingLot.takeCarOutOfParkingLot(ticket);
    }
}
