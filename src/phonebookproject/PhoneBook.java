/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebookproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.events.FileReadEvent;

/**
 *
 * @author Samyan
 */
public class PhoneBook {
    
    private static PhoneBook instance;
    
    private List<Contact> contacts; 
    
    private PhoneBook(){
        contacts = new ArrayList<Contact>();
    }
    
    public static PhoneBook getIsntance(){
        if(instance==null)
        {
            instance = new PhoneBook();
        }
        
        return instance;
    }
    
    
    public void addContact(Contact c){
        contacts.add(c);
    }
    
    private int searchContact(String number)
    {
        int index = -1;
         for(int i = 0 ; i  < contacts.size(); i++)
         {
             if(contacts.get(i).getContactNumber().equals(number))
             {
                 index = i;
                 break;
             }
         }
         
        return index;
    }
    
    
    public Contact getContact(String number)
    {
        int index = searchContact(number);
        return contacts.get(index);
    }
     public boolean updateContact(String number ,Contact c){
       int index = searchContact(number);
       
       if(index == -1)
           return false;
       else {
           contacts.set(index, c);
           return true;
       }
    }
    
     
    public boolean deleteContact(String number){
       int index = searchContact(number);
       
       if(index == -1)
           return false;
       else {
           contacts.remove(index);
           return true;
       }
    }
    
    public List<Contact> getAllContacts(){
        return contacts;
    }
    
   
    
    public List<Contact> searchBasedOnEmail(String emailIdText){
        List<Contact> searched = new ArrayList<Contact>();
        
         for(int i = 0 ; i  < contacts.size(); i++)
         {
             if(contacts.get(i).getEmail().contains(emailIdText))
             {
                 searched.add(contacts.get(i));
             }
         }
        return searched;
    }
    
    
    
     public List<Contact> searchBasedOnName(String nameText){
        List<Contact> searched = new ArrayList<Contact>();
        
         for(int i = 0 ; i  < contacts.size(); i++)
         {
             if(contacts.get(i).getName().contains(nameText))
             {
                 searched.add(contacts.get(i));
             }
         }
        return searched;
    }
     
     
      public List<Contact> searchBasedOnContact(String contacText){
        List<Contact> searched = new ArrayList<Contact>();
        
         for(int i = 0 ; i  < contacts.size(); i++)
         {
             if(contacts.get(i).getContactNumber().contains(contacText))
             {
                 searched.add(contacts.get(i));
             }
         }
        return searched;
    }
    
    
    public void saveData(String filename)
    {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Name,Email,Contact,Date Of Birth,Saved On\n");
            
            for(int i = 0 ; i < contacts.size();i++)
            {
                bw.write(contacts.get(i).getName() + ", "+
                        contacts.get(i).getEmail() + ","+
                        contacts.get(i).getContactNumber()+","+
                        contacts.get(i).getDob().toString()+","+
                          contacts.get(i).getSavedOn().toString()+"\n"
                );
            }
            
            bw.flush();
            bw.close();
            fw.close();
        } catch (Exception ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        public void loadData(String filename)
    {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
          String line = br.readLine();
            
          line = br.readLine();
          while(line != null)
          {
               Contact c = new Contact();
               String[] toks = line.split(",");
               
               c.setName(toks[0]);
               c.setEmail(toks[1]);
               c.setContactNumber(toks[2]);
               
                  SimpleDateFormat formatter5=new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");  
                 Date d =  formatter5.parse(toks[3].replace(" PKT", ""));
               c.setDob(d);
                   Date d1=formatter5.parse(toks[4].replace(" PKT", ""));  
               c.setSavedOn(d1);
               PhoneBook.getIsntance().addContact(c);
               
          }
             
              
          
            
            
            br.close();
            fr.close();
        } catch (Exception ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
