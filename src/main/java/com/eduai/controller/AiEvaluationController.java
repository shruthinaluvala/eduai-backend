package com.eduai.controller;

import com.eduai.model.EvaluationHistory;
import com.eduai.service.AiEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AiEvaluationController {

    private final AiEvaluationService service;

    public AiEvaluationController(AiEvaluationService service) {
        this.service = service;
    }

    // ✅ Evaluate + save history
    @PostMapping("/evaluate")
    public String evaluate(@RequestBody Map<String, String> body) {
        return service.evaluate(
                body.get("student"),
                body.get("studentAnswer"),
                body.get("answerKey")
        );
    }

    // ✅ Get all evaluations (Faculty)
    @GetMapping("/history")
    public List<EvaluationHistory> getAllHistory() {
        return service.getAllHistory();
    }

    // ✅ Get student evaluations (Student)
    @GetMapping("/history/{student}")
    public List<EvaluationHistory> getStudentHistory(@PathVariable String student) {
        return service.getHistoryByStudent(student);
    }
}
