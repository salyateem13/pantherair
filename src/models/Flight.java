/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;


/**
 *
 * @author samir
 */
public class Flight {
    private SimpleStringProperty origin = new SimpleStringProperty("");
    private SimpleStringProperty destination = new SimpleStringProperty("");
    private SimpleStringProperty depDate = new SimpleStringProperty("");
    private SimpleStringProperty retDate = new SimpleStringProperty("");
    private SimpleStringProperty seatNo = new SimpleStringProperty("");
    private SimpleStringProperty flightClass = new SimpleStringProperty("") ;
    private SimpleStringProperty flightNo = new SimpleStringProperty("") ;
    private int flightSeatId;
    
    public Flight ()
    {
        
    }
    
    
    //constructor for flight display object
    public Flight(String o, String d, String dd, String sn, String fc)
    {
      setOrigin(o) ;
      setDestination(d);
      setDepDate(dd);
      setSeatNo(sn);
      setFlightClass(fc);
    
    }
    
    
    
    /*
    // constructor for flight search object
    public Flight(String o, String d, String dd, String rd, String fc)
    {
      setOrigin(o) ;
      setDestination(d);
      setDepDate(dd);
      setRetDate(rd);
      setFlightClass(fc);
    
    }
    */
    //constructor for flight getter object
    public Flight(String o, String d, String dd, String rd,  int fsid)
    {
      setOrigin(o) ;
      setDestination(d);
      setDepDate(dd);
      setRetDate(rd);
      setFlightSeatID(fsid);
    
    }
 public Flight(String o, String d, String dd, String rd, String fc, int fsid)
    {
      setOrigin(o) ;
      setDestination(d);
      setDepDate(dd);
      setRetDate(rd);
      setFlightClass(fc);
      setFlightSeatID(fsid);
    
    }
    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin.get();
    }

    /**
     * @param o the origin to set
     */
    public void setOrigin(String o) {
        origin.set(o);
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination.get();
    }

    /**
     * @param dest the destination to set
     */
    public void setDestination(String dest) {
        destination.set(dest);
    }

    /**
     * @return the depDate
     */
    public String getDepDate() {
        return depDate.get();
    }

    /**
     * @param depd
     */
    public void setDepDate(String depd) {
        depDate.set(depd);
        
    }
    
      /**
     * @return the depDate
     */
    public String getRetDate() {
        return retDate.get();
    }

    /**
     * @param depd
     */
    public void setRetDate(String retd) {
        retDate.set(retd);
        
    }
    /**
     * @param seatNo
     */
    public String getSeatNo(){
        return seatNo.get();
    }
    
    /**
     * @param seatNo
     */
    public void setSeatNo(String sn) {
        seatNo.set(sn);
        
    }
            
    /**
     * @return the flightClass
     */
    public String getFlightClass() {
        return flightClass.get();
    }

    /**
     * @param fc the flightClass to set
     */
    public void setFlightClass(String fc) {
        flightClass.set(fc);
    }

    /**
     * @return the flightClass
     */
    public int getFlightSeatID() {
        return flightSeatId;
    }

    /**
     * @param fc the flightClass to set
     */
    public void setFlightSeatID(int fcid) {
        this.flightSeatId = fcid;
    }
    
    
     /**
     * @return the flightClass
     */
    public String getFlightNo() {
         return flightNo.get();
    }

    /**
     * @param fc the flightClass to set
     */
    public void setFlightSeatID(String fno) {
       flightNo.set(fno);
    }
}
