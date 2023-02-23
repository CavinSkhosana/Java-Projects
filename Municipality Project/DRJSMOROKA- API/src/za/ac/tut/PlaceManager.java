/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dumi
 */
public class PlaceManager implements PlaceInterfaceManager{
    
    private Connection connection;

    public PlaceManager(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
    
    

    @Override
    public void addPlace(Place place, String sql) throws SQLException {
          PreparedStatement ps = connection.prepareStatement(sql);
          
          ps.setInt(1, place.getId());
          ps.setString(2, place.getName());
          ps.setInt(3, place.getPopulation());
          ps.setInt(4, place.getMayor().getId());
          ps.executeUpdate();
    }

    @Override
    public Place getPlace(Integer id, String sql) throws SQLException {
         PreparedStatement ps = connection.prepareStatement(sql);
         
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next()){
               
             String name = rs.getString("NAME");
             Integer pop = rs.getInt("POPULATION");
             
             Place place = new Place(id,name,pop);
             
             String mayor_name = rs.getString("MAYOR_NAME");
             Integer mayor_age = rs.getInt("MAYOR_AGE");
             
             Mayor mayor = new Mayor(mayor_name,mayor_age);
             place.setMayor(mayor);
             
             return place;
         }
         else{
       return null;
    }
    }

    @Override
    public void updatePlace(Integer id, Integer population, String sql) throws SQLException {
                     PreparedStatement ps = connection.prepareStatement(sql);
                     
                
                     ps.setInt(1, population);
                       ps.setInt(2, id);
                       ps.executeUpdate();
    }

    @Override
    public List<Place> getMayorAbove(Integer above, String sql) throws SQLException {
                    List<Place> places = new ArrayList<>();
                       PreparedStatement ps = connection.prepareStatement(sql);
                       ps.setInt(1, above);
            
                       ResultSet rs = ps.executeQuery();
                       Place place = new Place();
                       Mayor mayor = new Mayor();
                       
                       while(rs.next()){
                         
                            String name = rs.getString("NAME");
                           place.setName(name);
             
           
             
             String mayor_name = rs.getString("MAYOR_NAME");
             mayor.setName(mayor_name);
             
             Integer mayor_age = rs.getInt("MAYOR_AGE");
             mayor.setAge(mayor_age);
            
             
            
             place.setMayor(mayor);
                           
             places.add(place);          }
                       return places;
    }

    @Override
    public void remove(Integer id, String sql) throws SQLException {
             PreparedStatement ps = connection.prepareStatement(sql);
             
             ps.setInt(1, id);
             
    }

    @Override
    public void addMayor(Mayor mayor, String sql) throws SQLException {
         
         PreparedStatement ps = connection.prepareStatement(sql);
         
         ps.setInt(1, mayor.getId());
         ps.setString(2, mayor.getName());
         ps.setInt(3, mayor.getAge());
         ps.executeUpdate();
    }
    
}
