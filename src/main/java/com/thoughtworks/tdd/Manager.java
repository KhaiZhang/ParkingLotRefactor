package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Manager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;

    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingBoys = new ArrayList<>();;
    }

    public boolean addParkingBoy(ParkingBoy parkingBoy){
        return parkingBoys.add(parkingBoy);
    }

    public Ticket orderParkingBoyParkCar(Car car,ParkingBoy parkingBoy) throws Exception{
        if(parkingBoys.contains(parkingBoy)){
            return parkingBoy.parkCar(car);
        }
        else throw new Exception("Unrecognized parking boy");
    }

    public Car orderParkingBoyFetchCar(Ticket ticket,ParkingBoy parkingBoy) throws Exception{
        if(parkingBoys.contains(parkingBoy)){
            return parkingBoy.fetchCar(ticket);
        }
        else throw new Exception("Unrecognized parking boy");
    }

}
