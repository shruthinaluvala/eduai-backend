package com.eduai.model;

import java.time.LocalDateTime;

public class EvaluationHistory {

    private String studentUsername;
    private String result;
    private AiScore score;
    private LocalDateTime evaluatedAt;

    public EvaluationHistory() {}

    public EvaluationHistory(String studentUsername, String result, AiScore score) {
        this.studentUsername = studentUsername;
        this.result = result;
        this.score = score;
        this.evaluatedAt = LocalDateTime.now();
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public String getResult() {
        return result;
    }

    public AiScore getScore() {
        return score;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
