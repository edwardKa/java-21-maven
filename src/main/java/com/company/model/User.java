package com.company.model;

public class User {
    private String username;

    private String password;

    private String email;

    private Job job;

    public User(String username, String password, String email, Job job) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.job = job;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }



}
