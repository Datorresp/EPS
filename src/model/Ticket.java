package model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author diegoa.torres
 */
public class Ticket implements Serializable{
    
    private char letter;
    private String complete;
    private int number;
    private boolean atteended;
    private User user;
    private TicketType tp;
    private ArrayList<TicketType> types; 

    public Ticket(char letter, int number, TicketType tp, User user) {
        this.letter = letter;
        this.number = number;
        this.user = user;
        this.tp = tp;
        completeTicket();       
        atteended = false;
        types = new ArrayList<>();

    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAtteended() {
        return atteended;
    }

    public void setAtteended(boolean atteended) {
        this.atteended = atteended;
    }

    public TicketType getTp() {
        return tp;
    }

    public void setTp(TicketType tp) {
        this.tp = tp;
    }

    public String completeTicket(){
        
        return complete = letter + ""+number + "";
    }
    
    public void addTypes(TicketType tt){     
        types.add(tt);
    }
    
    public void addType(String t){
        
        TicketType tt = null;
    }
    
    public TicketType search(TicketType t){
        
        TicketType tt = null;
        boolean found = false;
        
        for (int i = 0; i < types.size() && !found; i++) {
            
            if (types.get(i).compareTo(t) == 0) {
                
                tt = types.get(i);
                found = true;
            }
        }
        
        return tt;
    }
    
    public void order(){
        
        
    }
}