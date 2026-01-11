package com.eduai.model;

import java.time.LocalDateTime;

public class Assignment {

    // Student identity
    private String studentUsername;
    private String studentName;
    private String rollNo;

    // Academic structure
    private String branch;     // CSE, IT, ECE, EEE, MECH
    private int year;          // 1,2,3,4
    private String subject;

    // File info
    private String fileName;

    // Lifecycle
    private String status;     // SUBMITTED, REVIEWED, GRADED
    private Integer score;     // 0–10
    private String aiFeedback;
    private String facultyRemark;
    private LocalDateTime submittedAt;

    // Default constructor
    public Assignment() {}

    // Constructor used during submission
    public Assignment(
            String studentUsername,
            String studentName,
            String rollNo,
            String branch,
            int year,
            String subject,
            String fileName
    ) {
        this.studentUsername = studentUsername;
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.branch = branch;
        this.year = year;
        this.subject = subject;
        this.fileName = fileName;

        this.status = "SUBMITTED";
        this.submittedAt = LocalDateTime.now();
        this.aiFeedback = "AI: Good structure, add more real-world examples.";
    }

    // ---------------- GETTERS & SETTERS ----------------

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAiFeedback() {
        return aiFeedback;
    }

    public void setAiFeedback(String aiFeedback) {
        this.aiFeedback = aiFeedback;
    }

    public String getFacultyRemark() {
        return facultyRemark;
    }

    public void setFacultyRemark(String facultyRemark) {
        this.facultyRemark = facultyRemark;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
