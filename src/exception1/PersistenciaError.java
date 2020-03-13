package exception1;

/**
 *
 * @author diegoa.torres
 */
public class PersistenciaError extends Exception{



    public PersistenciaError(String string) {
        
        string = "impossible to restore program state";
    }

}
