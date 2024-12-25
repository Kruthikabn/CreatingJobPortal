package com.example.jobportal.model;

public class Job {
    private Long id;
    private String title;
    private String description;
    private String company;
    private String location;
    private String type; // Full-time, Part-time
    private double salary;

    // Constructors, Getters, and Setters
    public Job() {}

    public Job(Long id, String title, String description, String company, String location, String type, double salary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.company = company;
        this.location = location;
        this.type = type;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
