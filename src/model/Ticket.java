/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author diegoa.torres
 */
public class Ticket {
    
    private char letter;
    private String complete;
    private int number;
    private boolean atteended;
    private User user;

    public Ticket(char letter, int number, User user) {
        this.letter = letter;
        this.number = number;
        this.user = user;
        atteended = false;
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
    
    

    public void completeTicket(){
        
        complete = letter + number + "";
    }
    
    
    
}
