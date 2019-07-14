package com.thoughtworks.tdd;

import java.util.UUID;

public class Ticket {
    private String ticketNumber;

    public Ticket(){
        this.ticketNumber= UUID.randomUUID().toString();
    }
}
