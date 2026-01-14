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

    // Student submits assignment
    public void submitAssignment(Assignment assignment) {
        assignment.setStatus("SUBMITTED");
        assignmentRepository.save(assignment);
    }

    // Student dashboard count
    public long getAssignmentCount(String username) {
        return assignmentRepository.countByStudentUsername(username);
    }

    // Student history
    public List<Assignment> getAssignmentsByStudent(String username) {
        return assignmentRepository.findByStudentUsername(username);
    }

    // Faculty dashboard
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> getAssignmentsByYearAndBranch(int StudyYear, String branch) {
        return assignmentRepository.findByStudyYearAndBranch(StudyYear, branch);
    }

    // Faculty review
    public void reviewAssignment(Long id, String remark) {
        Assignment a = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        a.setFacultyRemark(remark);
        a.setStatus("REVIEWED");
        assignmentRepository.save(a);
    }

    // Faculty grade
    public void gradeAssignment(Long id, Integer score) {
        Assignment a = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        a.setScore(score);
        a.setStatus("GRADED");
        assignmentRepository.save(a);
    }
}
