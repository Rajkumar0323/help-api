package com.example.helpapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HelpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long helpId;

    private String title;
    private String description;
    private int seekerId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;

    // Getters and setters omitted for brevity
    public Long getHelpId() { return helpId; }
    public void setHelpId(Long helpId) { this.helpId = helpId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getSeekerId() { return seekerId; }
    public void setSeekerId(int seekerId) { this.seekerId = seekerId; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
