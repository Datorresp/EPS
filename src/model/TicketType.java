package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class TicketType implements Serializable{

    private String type;
    private float time;

    public TicketType(String type, float time) {
        this.type = type;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
    
    
}
