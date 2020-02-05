
package model;


public class AlreadyAssociatedUser extends Exception {

    /**
     * Creates a new instance of <code>AlreadyAssociatedUser</code> without
     * detail message.
     */
    public AlreadyAssociatedUser() {
    }

    /**
     * Constructs an instance of <code>AlreadyAssociatedUser</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlreadyAssociatedUser(String msg) {
        super(msg);
    }
}
