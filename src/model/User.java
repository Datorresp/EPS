package model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author diegoa.torres
 */
public class User implements Serializable{
    
    public static final String ID_CARD = "IC";
    public static final String CITIZENSHIP_CARD = "CC";
    public static final String PASSPORT = "P";    
    
    private String typeOfDocument, numberOfDocument, name, lastName, phone, address;

    public User(String typeOfDocument, String numberOfDocument, String name, String lastName, String phone, String address) {
        this.typeOfDocument = typeOfDocument;
        this.numberOfDocument = numberOfDocument;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    public String getNumberOfDocument() {
        return numberOfDocument;
    }

    public void setNumberOfDocument(String numberOfDocument) {
        this.numberOfDocument = numberOfDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
