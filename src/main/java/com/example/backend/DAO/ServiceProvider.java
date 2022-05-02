
/*
Service provider logging in details database
 */

package com.example.backend.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ServiceProvider {
    public ServiceProvider(){}

    public ServiceProvider(long serviceProvider_id, String serviceProvider_name, String email, String password) {
        this.serviceProvider_id = serviceProvider_id;
        this.serviceProvider_name = serviceProvider_name;
        this.email = email;
        this.password = password;
    }

    public long getServiceProvider_id() {
        return serviceProvider_id;
    }

    public void setServiceProvider_id(long serviceProvider_id) {
        this.serviceProvider_id = serviceProvider_id;
    }

    public String getServiceProvider_name() {
        return serviceProvider_name;
    }

    public void setServiceProvider_name(String serviceProvider_name) {
        this.serviceProvider_name = serviceProvider_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue
    private long serviceProvider_id;
    @Column(unique = true)
    private String serviceProvider_name;
    private String email;
    private String password;




}
