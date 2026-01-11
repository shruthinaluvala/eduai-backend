package com.eduai.service;
import org.springframework.stereotype.Service;
@Service
public class AiEvaluationService {
     public String evaluate(String studentAnswer, String answerKey) {

        // Mock AI response (fast + safe for demo)
        return """
               Score: 8/10
               Strengths: Good understanding of core concepts
               Improvements: Add more real-world examples
               AI Confidence: High
               """;
    }
}
