/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import exception1.AlreadyExists;
import exception1.DoesntExist;
import exception1.NoUsers;
import exception1.PersistenciaError;
import exception1.missingImportantInformation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Eps;
import model.User;
import model.Dates;
import model.TicketType;

/**
 *
 * @author diegoa.torres
 */
public class Controller {
    
    private Eps eps;
    private Scanner reader;

    public Controller() {
        try {
            
            eps = new Eps("/Users/diegoa.torres/NetBeansProjects/Eps/data/DATAFINAL1","/Users/diegoa.torres/NetBeansProjects/Eps/data/DATAFINAL2");
            
        } catch (PersistenciaError ex) {
            
            System.out.println(ex.getLocalizedMessage());
        }
        reader = new Scanner(System.in);
        
        
    }
    
    public void addUser(){
        
        try{
            
            System.out.println("Say the type of document: " + '\n');
            String tod = reader.nextLine();
            System.out.println("Say the document number: " + '\n');
            String nod = reader.nextLine();
            System.out.println("Say the user name: " + '\n');
            String n = reader.nextLine();
            System.out.println("Say the user last name: " + '\n');
            String l = reader.nextLine();
            System.out.println("Say the user pphone: " + '\n');
            String p = reader.nextLine();
            System.out.println("Say the user address: " + '\n');
            String d = reader.nextLine();
            User u = new User(tod, nod, n, l, p, d);
        
            eps.addUser(u);
        } catch (AlreadyExists ex) {
            
            System.out.println(ex.getMessage());
            System.out.println("TRY AGAIN" + '\n');

        } catch (missingImportantInformation ex) {
            
            System.out.println("TRY AGAIN");
            reader.nextLine();
        }
    }
    
    public void addTicket(){
        
        System.out.println("Say the document number: " + '\n');
        String nod = reader.nextLine();
        
        System.out.println("Say the type of the ticket: " + '\n');
        String tot = reader.nextLine();    
        
        System.out.println("Say the time: " + '\n');
        int t = reader.nextInt();
        reader.nextLine();  
        
        TicketType tt = new TicketType(tot, t);
        try {
            eps.addTicket(nod, tt);
        } catch (DoesntExist ex) {
            
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void loadTextFileUsers(){
            
        try {
            eps.loadTextFileUs();
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
    public void loadTextFileTickets(){
        
        try {
            eps.loadTextFileTu();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        } catch (NoUsers ex) {
            
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void attend(){
        
        eps.attend();
    }
    
    public void showUsers(){
        
        System.out.println("Print in console");
        System.out.println("Print in a text file");
        int valor = reader.nextInt();

        try {
            reader.nextLine();			

        }
        catch(InputMismatchException e) {

            System.out.println(" ERROR: RESPUESTA INVALIDA ");
            reader.nextLine();

        }
        
        switch (valor) {
            case 1:
                
                System.out.println(eps.showUsers());
                
                break;
                
            case 2:
        {
            try {
                eps.showUsersAdvance();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }            
                break;
                
                
            default:
                throw new AssertionError();
        }
    }
    
    public void search(){
        System.out.println("Say the user's name: " + '\n');
        String n = reader.nextLine();
        
        System.out.println(eps.BinarySearchUsers(n).toString());
    }
    
    public void drivingGame(){

        Dates d = new Dates();
        long inicio;
        long fin;
        double tiempo;
        boolean salir = false;
        
        while (!salir) {

            int userInput = gameMenu();

            switch (userInput) {

                case 1:
                    
                    inicio = System.currentTimeMillis();
                    addUser();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    
                    break;

                case 2:
                    
                    inicio = System.currentTimeMillis();
                    addTicket();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");                    
                    
                    break;

                case 3:
                    
                    inicio = System.currentTimeMillis();
                    attendTurn();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;

                case 4:
                    inicio = System.currentTimeMillis();
                    d.date();     
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 5:
                    inicio = System.currentTimeMillis();
                    eps.save(); 
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 6:
                    inicio = System.currentTimeMillis();
                    loadTextFileUsers();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 7:
                    inicio = System.currentTimeMillis();
                    loadTextFileTickets();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 8:    
                    inicio = System.currentTimeMillis();
                    showUsers();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 9:
                    inicio = System.currentTimeMillis();
                    eps.showTickets();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 10:
                    inicio = System.currentTimeMillis();
                    search();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                case 11:
                    inicio = System.currentTimeMillis();
                    eps.sortUsers();
                    fin = System.currentTimeMillis();
                    tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    break;
                    
                default:

                    salir = true;
            }
        }
    }
    
    public void attendTurn(){
        
        eps.attend();
    }
    
    public int gameMenu(){
    
        System.out.println("ATENCION: SI AQUI SALE NULL, REVISE LA RUTA DE SERIALIZACION EN CONTROLLER LINEA 41, SI ESTA BIEN COMENTE " + '\n'+"LAS LINEAS DE EPS DE LA 50 A LA 58, 60 A LA 69 Y 43 ,EJECUTE EL PROGRAMA Y DIGITE 5, DESCOMENTE LAS LINEAS Y EJECUTE EL PROGRAMA NUEVAMENTE. GRACIAS MARCOS POR ENTENDER QUE NO SE QUE PASA JEJEJEJE");
        Dates d = new Dates();
        d.date();
        System.out.println("1. Añadir Usuario");
        System.out.println("2. Crear turno");
        System.out.println("3. Atender Turno");
        System.out.println("4. dar Hora");
        System.out.println("5. Guardar sistema");
        System.out.println("6. Generar aleatoreamente usuarios");
        System.out.println("7. Generar aleatoreamente Tickets");
        System.out.println("8. Mostrar Usuarios");
        System.out.println("9. Mostrar Tickets");
        System.out.println("10. Busqueda Usuario");
        System.out.println("11. Ordenar usuarios por nombre");
        System.out.println("12. Añadir tipos de ticket");
        System.out.println("13. Buscar tipos de ticket");
        System.out.println("14 Ordenar tipos de ticket");

        int valor = reader.nextInt();

        try {
            reader.nextLine();			

        }
        catch(InputMismatchException e) {

            System.out.println(" ERROR: RESPUESTA INVALIDA ");
            reader.nextLine();

        }
        catch(NoSuchElementException e1) {

            e1.printStackTrace();
            reader.nextLine();
        }
        return valor;        
    }
}
