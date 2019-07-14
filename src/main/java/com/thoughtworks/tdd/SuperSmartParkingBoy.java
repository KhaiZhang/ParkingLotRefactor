package com.thoughtworks.tdd;

import java.util.List;
import java.util.NoSuchElementException;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
    @Override
    public Ticket parkCar(Car car) throws Exception{
        try {
            return this.getParkingLots().stream()
                    .max((a , b) ->{
                        if(a.getRemainPakingSpacaNumber()/(double)a.getCapacity() - b.getRemainPakingSpacaNumber()/(double)b.getCapacity() >= 0){
                            return 1;
                        }
                        else return -1;
                    })
                    .get()
                    .parkCarIntoParkingLot(car);
        }catch (NoSuchElementException ex){
            throw  new Exception("Not enough position");
        }
    }
}
