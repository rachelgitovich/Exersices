package org.example;

public class User {
   private String name;
   private String job;

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
