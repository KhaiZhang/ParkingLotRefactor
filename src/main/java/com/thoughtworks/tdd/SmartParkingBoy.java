package com.thoughtworks.tdd;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) throws Exception{
        try {
            return this.getParkingLots().stream()
                    .max((a , b) -> a.getRemainPakingSpacaNumber() - b.getRemainPakingSpacaNumber())
                    .get()
                    .parkCarIntoParkingLot(car);
        }catch (NoSuchElementException ex){
            throw  new Exception("Not enough position");
        }
    }
}
