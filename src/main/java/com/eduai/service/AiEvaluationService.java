package com.eduai.service;

import com.eduai.model.AiScore;
import com.eduai.model.EvaluationHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AiEvaluationService {

    private final List<EvaluationHistory> history = new ArrayList<>();

    public EvaluationHistory evaluate(
            String student,
            String studentAnswer,
            String answerKey
    ) {
        // Dummy AI logic (replace later with real LLM)
        AiScore score = new AiScore(
                3, // accuracy
                2, // clarity
                2, // examples
                1  // structure
        );

        String feedback = """
        Strengths: Good understanding of core concepts
        Improvements: Add more real-world examples
        AI Confidence: High
        """;

        EvaluationHistory result =
                new EvaluationHistory(student, feedback, score);

        history.add(result);
        return result;
    }

    public List<EvaluationHistory> getHistory() {
        return history;
    }
}
