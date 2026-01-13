package com.eduai.service;

import com.eduai.model.Assignment;
import com.eduai.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    /* -------------------------------------------------
       1️⃣ SUBMIT ASSIGNMENT
    ------------------------------------------------- */
    public void submitAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    /* -------------------------------------------------
       2️⃣ STUDENT – ASSIGNMENT COUNT
    ------------------------------------------------- */
    public long getAssignmentCount(String username) {
        return assignmentRepository.countByUsername(username);
    }

    /* -------------------------------------------------
       3️⃣ STUDENT – ASSIGNMENT HISTORY
    ------------------------------------------------- */
    public List<Assignment> getAssignmentsByStudent(String username) {
        return assignmentRepository.findByUsername(username);
    }

    /* -------------------------------------------------
       4️⃣ FACULTY – ALL ASSIGNMENTS
    ------------------------------------------------- */
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    /* -------------------------------------------------
       5️⃣ FACULTY – FILTER BY YEAR + BRANCH
    ------------------------------------------------- */
    public List<Assignment> getAssignmentsByYearAndBranch(int year, String branch) {
        return assignmentRepository.findByYearAndBranch(year, branch);
    }

    /* -------------------------------------------------
   6️⃣ FACULTY – REVIEW ASSIGNMENT
------------------------------------------------- */
    public void reviewAssignment(Long id, String remark) {
        Assignment assignment = assignmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setFacultyRemark(remark);
        assignmentRepository.save(assignment);
    }

    /* -------------------------------------------------
       7️⃣ FACULTY – GRADE ASSIGNMENT
    ------------------------------------------------- */
    public void gradeAssignment(Long id, Integer score) {
        Assignment assignment = assignmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setScore(score);
        assignmentRepository.save(assignment);
    }
}
