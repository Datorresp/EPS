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
public class AlreadyExists extends Exception {

    /**
     * Creates a new instance of <code>AlreadyExists</code> without detail
     * message.
     */
    public AlreadyExists() {
    }

    /**
     * Constructs an instance of <code>AlreadyExists</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public AlreadyExists(String msg) {
        super(msg);
    }
}
