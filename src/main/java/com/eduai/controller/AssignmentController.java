package com.eduai.controller;

import com.eduai.model.Assignment;
import com.eduai.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    /* -------------------------------------------------
       1️⃣ SUBMIT ASSIGNMENT (STUDENT)
    ------------------------------------------------- */
    @PostMapping("/submit")
    public void submitAssignment(@RequestBody Assignment assignment) {
        assignmentService.submitAssignment(assignment);
    }

    /* -------------------------------------------------
       2️⃣ ASSIGNMENT COUNT (STUDENT DASHBOARD)
    ------------------------------------------------- */
    @GetMapping("/count/{studentUsername}")
    public long getAssignmentCount(@PathVariable String studentUsername) {
        return assignmentService.getAssignmentCount(studentUsername);
    }

    /* -------------------------------------------------
       3️⃣ STUDENT ASSIGNMENT HISTORY
    ------------------------------------------------- */
    @GetMapping("/student/{studentUsername}")
    public List<Assignment> getAssignmentsByStudent(
            @PathVariable String studentUsername
    ) {
        return assignmentService.getAssignmentsByStudent(studentUsername);
    }

    /* -------------------------------------------------
       4️⃣ FACULTY DASHBOARD – ALL ASSIGNMENTS
    ------------------------------------------------- */
    @GetMapping("/all")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    /* -------------------------------------------------
       5️⃣ FACULTY FILTER – YEAR + BRANCH
    ------------------------------------------------- */
    @GetMapping("/year/{year}/branch/{branch}")
    public List<Assignment> getAssignmentsByYearAndBranch(
            @PathVariable int year,
            @PathVariable String branch
    ) {
        return assignmentService.getAssignmentsByYearAndBranch(year, branch);
    }

    /* -------------------------------------------------
       6️⃣ REVIEW ASSIGNMENT (FACULTY)
    ------------------------------------------------- */
    @PostMapping("/review/{index}")
    public void reviewAssignment(
            @PathVariable int index,
            @RequestBody String facultyRemark
    ) {
        assignmentService.reviewAssignment(index, facultyRemark);
    }

    /* -------------------------------------------------
       7️⃣ GRADE ASSIGNMENT (FACULTY)
    ------------------------------------------------- */
    @PostMapping("/grade/{index}")
    public void gradeAssignment(
            @PathVariable int index,
            @RequestBody Integer score
    ) {
        assignmentService.gradeAssignment(index, score);
    }
}
