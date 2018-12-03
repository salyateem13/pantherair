
import controller.FlightAdder;
import java.sql.SQLException;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir
 */
public class FlightAdderTet {
    public static void main(String [] args) throws SQLException
    {
        LocalDate ld = LocalDate.parse("2018-12-12");
        
     
    FlightAdder fa;
     int numSeats =25;
        fa = new FlightAdder("Atlanta", "New York", ld, "Economy", numSeats);
       int classID = fa.getClassID();
     int flightScheduleID = fa.getFlightScheduleID();
     int flightID = fa.getFlightID();
       
       System.out.println(fa.getClassID() + "  "+flightScheduleID  + "  "+ flightID );
      fa.addFlights();
      
  
                  for (int i = 0; i < numSeats; i++)
                {
                    fa.addSeats(i);
                    
                   System.out.println("One flightseat added" );
                }
                    
                   
    
    }
    
}
