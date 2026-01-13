package com.eduai.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ---------------------------
       STUDENT DETAILS
    --------------------------- */
    private String username;   // 🔥 REQUIRED
    private String title;

    @Column(length = 5000)
    private String content;

    /* ---------------------------
       METADATA
    --------------------------- */
    private Integer year;
    private String branch;

    private LocalDateTime submittedAt;

    /* ---------------------------
       FACULTY REVIEW
    --------------------------- */
    private Integer score;
    private String facultyRemark;

    /* ---------------------------
       AUTO TIMESTAMP
    --------------------------- */
    @PrePersist
    public void onSubmit() {
        this.submittedAt = LocalDateTime.now();
    }

    /* ---------------------------
       GETTERS & SETTERS
    --------------------------- */

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFacultyRemark() {
        return facultyRemark;
    }

    public void setFacultyRemark(String facultyRemark) {
        this.facultyRemark = facultyRemark;
    }
}
