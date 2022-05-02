package com.example.backend.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SubServiceDetails {
    public SubServiceDetails(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProvider_id(long serviceProvider_id) {
        this.serviceProviderID = serviceProvider_id;
    }

    public SubServiceDetails(long id, String service_name, long cost, long serviceProviderID) {
        this.id = id;
        this.service_name = service_name;
        this.cost = cost;
        this.serviceProviderID = serviceProviderID;
    }

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String service_name;
    private long cost;
    private long serviceProviderID;
}
