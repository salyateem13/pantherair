/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author samir
 */
public class Booking extends Flight{
    private SimpleStringProperty ticketID ;
    
    public Booking(String o, String d, String dd, String fn, String fc, String tid)
    {
      setOrigin(o) ;
      setDestination(d);
      setDepDate(dd);
      setSeatNo(fn);
      setFlightClass(fc);
      setTicketID(tid);
    
    }
    
     /**
     * @return the origin
     */
    public String getTicketID() {
        return ticketID.get();
    }

    /**
     * @param o the origin to set
     */
    public void setTicketID(String tid) {
        ticketID.set(tid);
    }
    
}
