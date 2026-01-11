package com.eduai.model;

import java.time.LocalDateTime;

public class EvaluationHistory {

    private String studentUsername;
    private String result;
    private LocalDateTime evaluatedAt;

    public EvaluationHistory() {}

    public EvaluationHistory(String studentUsername, String result) {
        this.studentUsername = studentUsername;
        this.result = result;
        this.evaluatedAt = LocalDateTime.now();
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public String getResult() {
        return result;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
