/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DatabaseConnection.getPrepareStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author samir
 */
public class TicketDelete {
    public TicketDelete ()
    {
    }
        public void deleteTicket (int fsid, int uid ) throws SQLException
    {
       String query = "DELETE FROM TICKETS \n" +
"where FlightSeatID = ?\n" +
"AND UserID = ?";
       
        PreparedStatement  preparedStmt = getPrepareStatement(query);
        preparedStmt.setInt(1, fsid);
        preparedStmt.setInt(2, uid);
        preparedStmt.execute();
       
    
    }
}
