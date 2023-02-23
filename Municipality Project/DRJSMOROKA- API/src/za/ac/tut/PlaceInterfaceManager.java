/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dumi
 */
public interface PlaceInterfaceManager {
    
    public void addPlace(Place place, String sql) throws SQLException;
    public void addMayor(Mayor mayor, String sql) throws SQLException;
    public Place getPlace(Integer id,String sql) throws SQLException;
    public void updatePlace(Integer id, Integer population, String sql) throws SQLException;
    public List<Place> getMayorAbove(Integer above, String sql) throws SQLException;
    public void remove(Integer id, String sql) throws SQLException;
    
}
