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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlreadyExists;
import model.Eps;
import model.User;

/**
 *
 * @author diegoa.torres
 */
public class Controller {
    
    private Eps eps;
    private Scanner reader;

    public Controller() {
        eps = new Eps();
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
            
            ex.printStackTrace();
            Menu();
        }
    }
    
    public void addTicket(){
        
        System.out.println("Say the document number: " + '\n');
        String nod = reader.nextLine();
        eps.addTicket(nod);
    }
    
    public void attend(){
        
        eps.attend();
    }
    
    public void Menu(){
        
        System.out.println("1. Añadir Usuario" + '\n');
        System.out.println("2. Crear turno" + '\n');
        System.out.println("3. Atender Turno" + '\n');
 
    }
    
    public void drivingGame() {

        boolean salir = false;

        while (!salir) {

            int userInput = gameMenu();

            switch (userInput) {

                case 1:

                    addUser();

                    break;

                case 2:

                    addTicket();

                    break;

                case 3:

                    //addHability();

                    break;


                default:

                    salir = true;
            }
        }
    }
    
    public int gameMenu(){
    
        System.out.println("1. Añadir Usuario" + '\n');
        System.out.println("2. Crear turno" + '\n');
        System.out.println("3. Atender Turno" + '\n');

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
