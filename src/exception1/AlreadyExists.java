/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception1;

import model.*;

/**
 *
 * @author diegoa.torres
 */
public class AlreadyExists extends Exception {


    /**
     * Constructs an instance of <code>AlreadyExists</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public AlreadyExists(String name, String id) {
        super("THE USER: " + name + " WITH ID: " + id + " IS ALREADY CREATED IN THE BASA DATA.");
    }
}
