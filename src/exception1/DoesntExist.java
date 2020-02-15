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
public class DoesntExist extends Exception {


    public DoesntExist(String id) {
        super("THE USER WITH ID: " +id+ " ISN´T REGISTERED");
    }
}
