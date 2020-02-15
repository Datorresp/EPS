/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception1;

import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 */
public class missingImportantInformation extends Exception {

    /**
     * Creates a new instance of <code>missingImportantInformation</code>
     * without detail message.
     */
    
    public missingImportantInformation() {
        
        super("MISSING SOME CHARACTERS, PLEASE FILL IT");
        
    }

    /**
     * Constructs an instance of <code>missingImportantInformation</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public missingImportantInformation(String msg) {
        super(msg);
    }
}
