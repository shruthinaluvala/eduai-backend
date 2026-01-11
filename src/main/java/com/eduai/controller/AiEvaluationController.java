package com.eduai.controller;

import com.eduai.model.EvaluationHistory;
import com.eduai.service.AiEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AiEvaluationController {

    private final AiEvaluationService service;

    public AiEvaluationController(AiEvaluationService service) {
        this.service = service;
    }

    @PostMapping("/evaluate")
    public EvaluationHistory evaluate(@RequestBody Map<String, String> body) {
        return service.evaluate(
                body.get("student"),
                body.get("studentAnswer"),
                body.get("answerKey")
        );
    }
}
