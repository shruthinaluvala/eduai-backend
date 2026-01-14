package com.eduai.controller;

import com.eduai.model.Assignment;
import com.eduai.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/submit")
    public void submitAssignment(@RequestBody Assignment assignment) {
        assignmentService.submitAssignment(assignment);
    }

    @GetMapping("/count/{username}")
    public long getAssignmentCount(@PathVariable String username) {
        return assignmentService.getAssignmentCount(username);
    }

    @GetMapping("/student/{username}")
    public List<Assignment> getStudentAssignments(@PathVariable String username) {
        return assignmentService.getAssignmentsByStudent(username);
    }

    @GetMapping("/all")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/year/{studyYear}/branch/{branch}")
    public List<Assignment> getByYearAndBranch(
            @PathVariable int studyYear,
            @PathVariable String branch
    ) {
        return assignmentService.getAssignmentsByYearAndBranch(studyYear, branch);
    }


    @PostMapping("/review/{id}")
    public void review(@PathVariable Long id, @RequestBody String remark) {
        assignmentService.reviewAssignment(id, remark);
    }

    @PostMapping("/grade/{id}")
    public void grade(@PathVariable Long id, @RequestBody Integer score) {
        assignmentService.gradeAssignment(id, score);
    }
}
