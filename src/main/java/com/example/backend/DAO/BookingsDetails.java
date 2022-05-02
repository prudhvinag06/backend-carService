package com.example.backend.DAO;

import javax.persistence.*;

@Entity
public class BookingsDetails{

    public BookingsDetails(){}

    public long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(long booking_id) {
        this.booking_id = booking_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  //  @TableGenerator(name = "booking_id", initialValue = 10000, allocationSize = 100)
    @Id
    @GeneratedValue
    private long booking_id;

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    private long cost;
    private long user_id;
    private long service_id;
    private boolean status;
    private String date;

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    private String service_name;


    public BookingsDetails(long cost, long booking_id, long user_id, long service_id, boolean status, String date, String service_name) {
        this.cost = cost;
        this.booking_id = booking_id;
        this.user_id = user_id;
        this.service_id = service_id;
        this.status = status;
        this.date = date;
        this.service_name = service_name;
    }




}