/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception1;

/**
 *
 * @author diegoa.torres
 */
public class noUnattendedTickets extends Exception {

    /**
     * Creates a new instance of <code>noUnattendedTickets</code> without detail
     * message.
     */
    public noUnattendedTickets() {
    }

    /**
     * Constructs an instance of <code>noUnattendedTickets</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public noUnattendedTickets(String msg) {
        super(msg);
    }
}
