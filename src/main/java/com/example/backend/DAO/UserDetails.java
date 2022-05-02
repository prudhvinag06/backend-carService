package com.example.backend.DAO;

import javax.persistence.*;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long user_id;
    @Column(unique = true)
    private String username;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    private String email;
    private String password;


    public UserDetails(long user_id, String username, String password, String email) {
        this.user_id = user_id;
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDetails(){}



}
