package com.example.backend.DAO;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Service {
    public Service(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(unique = true)
    private String serviceName;

    public Service(Long id, String serviceName, String location, String address, String imageLink) {
        this.id = id;
        this.serviceName = serviceName;
        this.location = location;
        this.address = address;
        this.imageLink = imageLink;

    }

    private String location;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Column(length = 15000)
    private String imageLink;

}
