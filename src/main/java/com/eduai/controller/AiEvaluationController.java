package com.eduai.controller;

import com.eduai.dto.EvaluationRequest;
import com.eduai.service.AiEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AiEvaluationController {

    private final AiEvaluationService aiEvaluationService;

    public AiEvaluationController(AiEvaluationService aiEvaluationService) {
        this.aiEvaluationService = aiEvaluationService;
    }

    @PostMapping("/evaluate")
    public String evaluateAssignment(@RequestBody EvaluationRequest request) {
        return aiEvaluationService.evaluate(
                request.getStudentAnswer(),
                request.getAnswerKey()
        );
    }
    @GetMapping("/test")
    public String test() {
        return "AI Evaluation API is working!";
    }

}
