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
        
        tp = search(t);
    }
    
    public TicketType search(String t){
        
        boolean encotre = false;
        int fin = types.size()-1;
        int inicio = 0;
        int pos = 0;
        while (inicio <= fin && !encotre) {
            
            int medio = (inicio + fin)/2;
            if (types.get(medio).getType().compareTo(t)==0) {
                
                encotre = true;
                pos = medio;
            }else if (types.get(medio).getType().compareTo(t)>0) {
                
                fin = medio + 1;
            }else{
                
                inicio = medio + 1;
            }
        }
        
        return types.get(pos);
    }
    
    public void sortByTypeBurbuja(){
        
        for (int i = types.size(); i > 0; i--) {
            
            for (int j = 0; j < i-1; j++) {
                
                if (types.get(j).getType().compareTo(types.get(j+1).getType())>0) {
                    
                    TicketType tmp = types.get(j);
                    types.set(j, types.get(j+1));
                    types.set(j+1, tmp);
                    
                }
            }
        }
    }
    
    public void sortTimeInsercion(){
        
        for (int i = 1; i < types.size(); i++) {
            
            for (int j = i; j > 0 && types.get(j-1).getTime()-types.get(j).getTime() > 0 ; j--) {
                
                TicketType temp = types.get(j);
                types.set(j, types.get(j+1));
                types.set(j+1, temp);
            }
        }
    }

    @Override
    public String toString() {
        return "Ticket{" + "letter=" + letter + ", complete=" + complete + ", number=" + number + ", atteended=" + atteended + ", user=" + user + ", tp=" + tp + ", types=" + types + '}';
    }
    
    public String ShowTypes(){
        
        String t = "";
        
        for (int i = 0; i < types.size(); i++) {
            
            t+=types.get(i).toString() + '\n';
        }
        
        return t;
    }
     
}