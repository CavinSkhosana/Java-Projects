/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djsmoroka.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import za.ac.tut.Mayor;
import za.ac.tut.Place;
import za.ac.tut.PlaceManager;

/**
 *
 * @author Dumi
 */
public class DJSMOROKAAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Place place;
        Mayor mayor;
        PlaceManager pm;
        Connection con;
        
        String dbURL = "jdbc:derby://localhost:1527/DJSMOROKA";
        String username = "moroka";
        String password = "123";
        
        String addPlayerSQL = "INSERT INTO MOROKA "
                + "VALUES(?,?,?,?)";
        String addMayorSQL = "INSERT INTO MAYOR "
                + "VALUES(?,?,?)";
        String getPlaceSQL = "SELECT MOROKA.ID, MOROKA.NAME, MOROKA.POPULATION, MAYOR.NAME AS MAYOR_NAME, MAYOR.AGE AS MAYOR_AGE "
                + "FROM MOROKA "
                + "INNER JOIN MAYOR ON MOROKA.MAYORID = MAYOR.ID "
                + "WHERE MOROKA.ID = ?";
        String updateSQL = "UPDATE MOROKA SET "
                + "MOROKA.POPULATION = ? "
                + "WHERE MOROKA.ID = ?";
        String getMayorAboveSQL = "SELECT   MOROKA.NAME, MAYOR.NAME AS MAYOR_NAME, MAYOR.AGE AS MAYOR_AGE  "
                + "FROM MOROKA "
                + "INNER JOIN MAYOR ON MOROKA.MAYORID = MAYOR.ID "
                + "WHERE MAYOR.AGE > ?";
        String removeSQL = "DELETE FROM MOROKA "
    
                + "WHERE MOROKA.ID = ?";
        
        try{
             con = DriverManager.getConnection(dbURL, username, password);
             pm = new PlaceManager(con);
             
             int option = getOption();
             
             while(option !=9){
                 switch(option){
                     
                     case 1 :
                         place = getPlace();
                         mayor = place.getMayor();
                         
                         pm.addMayor(mayor, addMayorSQL);
                         pm.addPlace(place,addPlayerSQL );
                         break;
                         
                     case 2 :
                           
                         int id = getID();
                         
                         place = pm.getPlace(id, getPlaceSQL);
                         
                         System.out.println(place);
                         break;
                         
                         case 3 :
                             
                               id = getID();
                               Integer population = getPop();
                               
                               pm.updatePlace(id, population, updateSQL);
                         break;
                         
                         case 4 :
                             int above = getAboveAge();
                             
                             List<Place> places = pm.getMayorAbove(above, getMayorAboveSQL);
                             
                             display(places);
                             
                         break;
                         
                         case 5 :
                             
                              id = getID();
                              
                              pm.remove(id, removeSQL);
                             
                         break;
                         
                         default :
                             System.out.println("Invalid");
                     
                 }
                 option = getOption();
             }
             System.out.println("GOODBYE");
        }
        catch(SQLException ex){
         System.out.println(ex.getMessage());
        }
    }

    private static int getOption() {
Scanner ke = new Scanner(System.in); 

System.out.println("ENTER OPTION : \n"
        + "1 - ADD \n"
        + "2 - GET \n"
        + "3 - UPDATE \n"
        + "4 - PLACES WITH MAYOR ABOVE... \n"
        + "5 - REMOVE \n"
        + "9 - EXIT \n");

int option = ke.nextInt();
     return option;   
    }

    private static Place getPlace() {
         Scanner ke = new Scanner(System.in);
         
         System.out.print("Enter place ID:");
         int id = ke.nextInt();
         
         System.out.print("Enter place name:");
         String name = ke.next();
         
         System.out.print("Population:");
         int pop = ke.nextInt();
         
        System.out.print("Enter mayor ID:");
        int mayorID = ke.nextInt();
        
        System.out.print("MAYOR NAME:");
        String mname = ke.next();
        
        System.out.print("Age:");
        int age = ke.nextInt();
        
        Place place = new Place(id,name,pop);
        Mayor mayor = new Mayor(mayorID,mname,age);
        
        place.setMayor(mayor);
        
        return place;
    }

    private static int getID() {
          Scanner ke = new Scanner(System.in);
          
          System.out.print("Enter place id:");
          int id = ke.nextInt();
          
          
          return id;
    }

    private static Integer getPop() {
             Scanner ke = new Scanner(System.in);
             
             System.out.print("Enter new population:");
             int population = ke.nextInt();
             
             return population;
    }

    private static int getAboveAge() {
          Scanner ke = new Scanner(System.in);
          
          System.out.print("Enter age of mayor: ");
          int age = ke.nextInt();
          
          return age;
    }

    private static void display(List<Place> places) {

        for(int x = 0; x<places.size();x++){
            System.out.println("Name of the mayor: "+places.get(x).getMayor().getName());
            System.out.println("Place: "+places.get(x).getName());
             System.out.println("Age of the mayor: "+places.get(x).getMayor().getAge());
        }
    }
    
}
