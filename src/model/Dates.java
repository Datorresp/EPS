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
        fecha = new GregorianCalendar();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        año = fecha.get(Calendar.YEAR);
        this.minuto = setMinuto();
        this.segundo = setSegundo();
        this.hora = setHora();
        fechaf();
        
    }

    public int setMinuto() {
        return fecha.get(Calendar.MINUTE);
    }

    public int setSegundo() {
        return fecha.get(Calendar.SECOND);
    }

    public int setHora() {
        return fecha.get(Calendar.HOUR);
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
    
    
    private void refresh(){
        
        fecha = new GregorianCalendar();
        this.minuto = setMinuto();
        this.segundo = setSegundo();
        this.hora = setHora();
    }
    public  void date(){
        
        refresh();
        System.out.println(mesf + "/" + dia + "/" + año);
        System.out.println(hora + ":" + minuto + ":" + segundo);
        System.out.println();

        
    }

 
}
