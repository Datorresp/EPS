package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
 public class TicketType implements Serializable, Comparable<TicketType>{

    private String type;
    private int time;

    public TicketType(String type, int time) {
        this.type = type;
        this.time =  time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(TicketType o) {
        return this.type.compareToIgnoreCase(o.getType());
    }
    
    public int compareToTime(TicketType o){
        
        return this.time - o.getTime();
    }

    @Override
    public String toString() {
        return "TicketType{" + "type=" + type + ", time=" + time + '}';
    }
    
    
}
