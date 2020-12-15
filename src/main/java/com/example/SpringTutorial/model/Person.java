package com.example.SpringTutorial.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;

public class Person {

    private final UUID id;


    private final String FirstName;
    private final String LastName;

    public Person(@JsonProperty("id")UUID id, @JsonProperty("first-name") String firstName, @JsonProperty("last-name") String lastName) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName(){
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
}
