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
        Float t = reader.nextFloat();
        reader.nextLine();  
        
        TicketType tt = new TicketType(tot, t);
        try {
            eps.addTicket(nod, tt);
        } catch (DoesntExist ex) {
            
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void loadTextFileUsers(){
        
        System.out.println("Type the text file's path: " + '\n');
        String csv = reader.nextLine();
        
        System.out.println("Type the separator: " + '\n');
        String sep = reader.nextLine();    
        try {
            eps.loadTextFileUs(csv, sep);
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
    public void loadTextFileTickets(){
        
        System.out.println("Type the text file's path: " + '\n');
        String csv = reader.nextLine();
        
        System.out.println("Type the separator: " + '\n');
        String sep = reader.nextLine(); 
        try {
            eps.loadTextFileTu(csv,sep);
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        } catch (NoUsers ex) {
            
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void attend(){
        
        eps.attend();
    }
    
    
    
    public void drivingGame(){

        Dates d = new Dates();
        
        boolean salir = false;
        
        while (!salir) {

            int userInput = gameMenu();

            switch (userInput) {

                case 1:
                    
                    long inicio = System.currentTimeMillis();
                    addUser();
                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio)/1000);
                    System.out.println(tiempo +" segundos");
                    
                    break;

                case 2:

                    addTicket();
                    break;

                case 3:

                    attendTurn();
                    break;

                case 4:
                    
                    d.date();                   
                    break;
                    
                case 5:
                    
                    eps.save(); 
                    break;
                    
                case 6:
                    
                    loadTextFileUsers();
                    break;
                    
                case 7:
                    
                    loadTextFileTickets();
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
    
        Dates d = new Dates();
        d.date();
        System.out.println("1. Añadir Usuario");
        System.out.println("2. Crear turno");
        System.out.println("3. Atender Turno");
        System.out.println("4. dar Hora");
        System.out.println("5. Guardar sistema");
        System.out.println("6. Generar aleatoreamente usuarios");
        System.out.println("7. Generar aleatoreamente Tickets");
        

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
