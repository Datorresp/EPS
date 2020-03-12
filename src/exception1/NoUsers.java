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
public class NoUsers extends Exception {

    /**
     * Creates a new instance of <code>NoUsers</code> without detail message.
     */
    public NoUsers() {
    }

    /**
     * Constructs an instance of <code>NoUsers</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public NoUsers(String msg) {
        super(msg);
    }
}
