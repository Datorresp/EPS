package model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exception1.AlreadyExists;
import exception1.DoesntExist;
import exception1.NoUsers;
import exception1.missingImportantInformation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class Eps implements Serializable{
    
    private ArrayList <Ticket> tickets;
    private ArrayList <User> users;
    private Ticket actuals;
    

    public Eps() {
        
        tickets = new ArrayList<>();
        users = new ArrayList<>();
        Ticket t = new Ticket('A', 00, null, null);
        t.setAtteended(true);
        tickets.add(t);
        actual();
    }
    
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public Ticket getActuals() {
		return actuals;
	}

	public void setActuals(Ticket actuals) {
		this.actuals = actuals;
	}

    public void addUser(User u)throws AlreadyExists, missingImportantInformation{       
        boolean added = false;        
        for (int i = 0; i < users.size() && !added; i++) {           
            if (users.get(i).getNumberOfDocument().equalsIgnoreCase(u.getNumberOfDocument())) {                
                throw  new AlreadyExists(users.get(i).getName(), users.get(i).getNumberOfDocument());                
            }else{                
                if(u.getName() == null || u.getLastName() == null || u.getNumberOfDocument()== null || u.getTypeOfDocument()== null){                    
                    throw new missingImportantInformation();                    
                }else{                    
                    users.add(u);
                    added = true;
                    try{
                        String rutaFichero = null;
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));
                        oos.writeObject(u);
                        oos.close();
                        User readClient = (User) ois.readObject();
                        ois.close();
                    }catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }catch (ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }if (users.size() == 0) {            
            if(u.getName() == null || u.getLastName() == null || u.getNumberOfDocument()== null || u.getTypeOfDocument()== null){
                throw new missingImportantInformation();
            }else{
                users.add(u);
                try{
                    String rutaFichero = null;
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));
                    oos.writeObject(u);
                    oos.close();
                    User readClient = (User) ois.readObject();
                    ois.close();
                }catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }                            
            }
        }
    }
    
    public User findById(String id) throws DoesntExist{
        
        boolean encontrado = false;
        User u = null;
        
        for (int i = 0; i < users.size() && !encontrado; i++) {
		
            if (users.get(i).getNumberOfDocument().equalsIgnoreCase(id)) {

                u = users.get(i);
                encontrado =true;
                
            }else if (i == users.size()-1 &&users.get(i++) == null) {
                
                throw new DoesntExist(id);
            }
		}
        
        return u;
    }
    
    public void loadTextFileUs()throws IOException{

        String csv = "/Users/diegoa.torres/NetBeansProjects/LecturaDeArchivos/prueba.csv";
        String sep = ",";
        User cl = null;


        if (csv != null) {

            File f = new File (csv);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);

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
                    try{
                        String rutaFichero = null;
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));
                        oos.writeObject(cl);
                        oos.close();
                        User readClient = (User) ois.readObject();
                        ois.close();
                    }catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }catch (ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }                    
                    line = br.readLine();

                }
            }
        }
    }
    
    public void loadTextFileTu()throws IOException, NoUsers{
        String csv = "/Users/diegoa.torres/NetBeansProjects/LecturaDeArchivos/prueba.csv";
        String sep = ",";
        if (csv != null) {
            File f = new File (csv);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                if (line.charAt(0) != '#') {
                    User u = null;
                    for (int i = 0; i < users.size(); i++) {                       
                        u = users.get(i);
                    }                    
                    if(u != null){                        
                        String[] parts = line.split(sep);
                        String type = parts[0];
                        String time = parts[1];                    
                        TicketType tt = new TicketType(type, Float.parseFloat(time));
                        String num = numberOfTheTicket();
                        String num1;
                        if(num.charAt(1) == 0) {
                            num1 = num.charAt(1) +num.charAt(2)+"";
                        }else {
                            num1 = num.charAt(1) + "";
                        }
                        Ticket t = new Ticket(num.charAt(0), Integer.parseInt(num1), tt, u);
                        tickets.add(t);
                        try{
                            String rutaFichero = null;
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));
                            oos.writeObject(t);
                            oos.close();
                            User readClient = (User) ois.readObject();
                            ois.close();
                        }catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }catch (ClassNotFoundException ex) {
                            System.out.println(ex.getMessage());
                        }                        
                    }
                    line = br.readLine();
                    throw new NoUsers();
                }
            }
        }
    }
    
    public String numberOfTheTicket(){
        
        char letterT = tickets.get(tickets.size()-1).getLetter();
        int number = tickets.get(tickets.size()-1).getNumber();
        String complete = tickets.get(tickets.size()-1).getComplete();
        
        if(tickets.get(0) != null){
        	
            if(!complete.equalsIgnoreCase("Z99")){
            	
                if (tickets.get(tickets.size()-1).getNumber() == 99) {
                	
                    letterT = (char) (letterT+1);
                    
                    number = 00;
                    complete = letterT + ""+ number + "";
                }else{
                	
                    number = number+1;
                    
                    complete = letterT +""+ number + "";

                }
            }else{

                letterT = 'A';
                number = 00;
                complete = letterT + ""+ number + "";
            }
        }else{
            
            letterT = 'A';
            number = 00;
            complete = letterT + number + "";
        }    
        
        
        return complete;
    }
    
    public void addTicket(String id, TicketType tp) throws DoesntExist{
        
        if(tickets.get(0).getUser() == null){
            
        	
            User u = findById(id);
            tickets.get(0).setUser(u);

        }else{
            
            User u = findById(id);
            String num = numberOfTheTicket();
            String num1;
            if(num.charAt(1) == 0) {
            	 num1 = num.charAt(1) +num.charAt(2)+"";
            }else {
            	num1 = num.charAt(1) + "";
            }
            Ticket t = new Ticket(num.charAt(0), Integer.parseInt(num1), tp, u);
            tickets.add(t);
            try{
                String rutaFichero = null;

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

                oos.writeObject(t);
                oos.close();

                Ticket readClient = (Ticket) ois.readObject();
                ois.close();

            }catch (IOException ex) {

                System.out.println(ex.getMessage());
            }catch (ClassNotFoundException ex) {

                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    public void actual(){
        
        boolean attended = false;
        
        for (int i = 0; i < tickets.size() && !attended; i++) {

            if(tickets.get(i) != null){
                
                if (!tickets.get(i).isAtteended()) {
                	System.out.println("No ha sido atendido");
                    attended = true;
                    actuals = tickets.get(i);
                }
            }else{
                
                throw  new NullPointerException("No hay registros de tickets, por favor cree uno");
            }   
        }
    }
    
    public void attend(){
        
        
        actual();
    }
}