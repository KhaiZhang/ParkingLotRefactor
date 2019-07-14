package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<ParkingBoy> parkingBoys;

    public Manager() {
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
