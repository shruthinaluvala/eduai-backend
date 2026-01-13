package com.eduai.controller;

import com.eduai.model.Assignment;
import com.eduai.service.AssignmentService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> submitAssignment(@RequestBody Assignment assignment) {

        // 🔒 SAFETY CHECK (this fixes count + analytics issues)
        if (assignment.getUsername() == null || assignment.getUsername().isEmpty()) {
            return ResponseEntity.badRequest().body("Username is required");
        }

        assignmentService.submitAssignment(assignment);
        return ResponseEntity.ok().build(); // frontend-safe
    }

    /* -------------------------------------------------
       2️⃣ ASSIGNMENT COUNT (STUDENT DASHBOARD)
    ------------------------------------------------- */
    @GetMapping("/count/{studentUsername}")
    public ResponseEntity<Long> getAssignmentCount(
            @PathVariable String studentUsername
    ) {
        long count = assignmentService.getAssignmentCount(studentUsername);
        return ResponseEntity.ok(count);
    }

    /* -------------------------------------------------
       3️⃣ STUDENT ASSIGNMENT HISTORY
    ------------------------------------------------- */
    @GetMapping("/student/{studentUsername}")
    public ResponseEntity<List<Assignment>> getAssignmentsByStudent(
            @PathVariable String studentUsername
    ) {
        return ResponseEntity.ok(
                assignmentService.getAssignmentsByStudent(studentUsername)
        );
    }

    /* -------------------------------------------------
       4️⃣ FACULTY DASHBOARD – ALL ASSIGNMENTS
    ------------------------------------------------- */
    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    /* -------------------------------------------------
       5️⃣ FACULTY FILTER – YEAR + BRANCH
    ------------------------------------------------- */
    @GetMapping("/year/{year}/branch/{branch}")
    public ResponseEntity<List<Assignment>> getAssignmentsByYearAndBranch(
            @PathVariable int year,
            @PathVariable String branch
    ) {
        return ResponseEntity.ok(
                assignmentService.getAssignmentsByYearAndBranch(year, branch)
        );
    }

    /* -------------------------------------------------
       6️⃣ REVIEW ASSIGNMENT (FACULTY)
    ------------------------------------------------- */
    @PostMapping("/review/{id}")
    public ResponseEntity<?> reviewAssignment(
            @PathVariable Long id,
            @RequestBody String facultyRemark
    ) {
        assignmentService.reviewAssignment(id, facultyRemark);
        return ResponseEntity.ok().build();
    }

    /* -------------------------------------------------
       7️⃣ GRADE ASSIGNMENT (FACULTY)
    ------------------------------------------------- */
    @PostMapping("/grade/{id}")
    public ResponseEntity<?> gradeAssignment(
            @PathVariable Long id,
            @RequestBody Integer score
    ) {
        assignmentService.gradeAssignment(id, score);
        return ResponseEntity.ok().build();
    }
}
