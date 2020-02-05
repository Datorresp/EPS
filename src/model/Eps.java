/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 */
public class Eps {
    
    private ArrayList <Ticket> ticket;
    private ArrayList <User> users;

    public Eps() {
        
        ticket = new ArrayList<>();
        users = new ArrayList<>();
    }
    
    public void addUser(User u)throws AlreadyExists{
        
        boolean added = false;
        
        for (int i = 0; i < users.size() && !added; i++) {
            
            if (users.get(i).getNumberOfDocument().equalsIgnoreCase(u.getNumberOfDocument())) {
                
                throw  new AlreadyExists();
                
            }else{
                
                users.add(u);
                added = true;
            }
        }
    }
    
    public User findById(String id) throws NullPointerException{
        
        boolean encontrado = false;
        User u = null;
        for (int i = 0; i < users.size() && !encontrado; i++) {
            
            if (users.get(i).getNumberOfDocument().equalsIgnoreCase(id)) {
                
                u = users.get(i);
                encontrado =true;
                
            }else if (users.get(i++) == null) {
                
                throw new NullPointerException("El numero de documento: " + id + " Por favor crear el usuario para darle un turno.");
            }
            
        }
        
        return u;
    }
    
    public void loadTextFile()throws IOException{

        String csv = "/Users/diegoa.torres/NetBeansProjects/LecturaDeArchivos/prueba.csv";
        String sep = ",";
        User cl = null;


        if (csv != null) {

            File f = new File (csv);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;

            String line = br.readLine();

            while (line != null) {

                if (line.charAt(0) != '#') {

                    String[] parts = line.split(sep);
                    String typeOfId = parts[0];
                    String id = parts[1];                    
                    String name = parts[2];
                    String LastName = parts[3];
                    String phone = parts[3];
                    String address = parts[3];

                    cl = new User(typeOfId, id, name, LastName, phone, address);
                    users.add(cl);
                    line = br.readLine();

                }
            }
        }
    }    
    
}
