package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/**
 *
 * @author diegoa.torres
 */
public class Dates {

    int dia, mes, año, minuto, segundo, hora;
    String mesf;
    Calendar fecha = Calendar.getInstance(Locale.getDefault());
    public Dates() {
        
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        año = fecha.get(Calendar.YEAR);
        minuto = fecha.get(Calendar.MINUTE);
        segundo = fecha.get(Calendar.SECOND);
        hora = fecha.get(Calendar.HOUR);
        fechaf();
        
    }
    
    private void fechaf(){
        
        if (mes == 0) {
            
            mesf = "January";
        }else if (mes == 1) {
            
            mesf = "February";
        }else if (mes == 2) {
            
            mesf = "March";
        }else if (mes == 3) {
            
            mesf = "April";
        }else if (mes == 4) {
            
            mesf = "May";
        }else if (mes == 5) {
            
            mesf = "June";
        }else if (mes == 6) {
            
            mesf = "July";
        }else if (mes == 7) {
            
            mesf = "Agust";
        }else if (mes == 8) {
            
            mesf = "September";
        }else if (mes == 9) {
            
            mesf = "October";
        }else if (mes == 10) {
            
            mesf = "Novembre";
        }else if (mes == 11) {
            
            mesf = "December";
        }
    }
    
    
    public  void date(){
        
        System.out.println(mesf + "/" + dia + "/" + año);
        System.out.println(hora + ":" + minuto + ":" + segundo);

        
    }


    
    
    
}
