
import controller.FlightSearch;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir
 */
public class FlightSearchTest {
    
    public static void main(String [] args) throws SQLException
    {
        FlightSearch fst = new FlightSearch("New York");
         List<String> origin = fst.getDest();
         System.out.println();
         for(int i = 0; i < origin.size(); i++) {   
             System.out.println(i);
             System.out.println(origin.get(i));
             
            } 
         
        
    }
    
}
