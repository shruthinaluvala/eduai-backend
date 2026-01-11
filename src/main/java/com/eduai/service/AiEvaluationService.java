package com.eduai.service;

import com.eduai.model.EvaluationHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AiEvaluationService {

    private final List<EvaluationHistory> history = new ArrayList<>();

    public String evaluate(String student, String answer, String key) {
        // Dummy AI logic (already exists)
        String result = """
        Score: 8/10
        Strengths: Clear understanding
        Improvements: Add examples
        Confidence: High
        """;

        // ✅ Save history
        history.add(new EvaluationHistory(student, result));

        return result;
    }

    public List<EvaluationHistory> getAllHistory() {
        return history;
    }

    public List<EvaluationHistory> getHistoryByStudent(String student) {
        return history.stream()
                .filter(h -> h.getStudentUsername().equals(student))
                .toList();
    }
}
