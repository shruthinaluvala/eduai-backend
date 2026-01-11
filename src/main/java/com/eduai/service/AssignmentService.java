package com.eduai.service;

import com.eduai.model.Assignment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    // In-memory storage (MVP)
    private final List<Assignment> assignments = new ArrayList<>();

    /* -------------------------------------------------
       1️⃣ SUBMIT ASSIGNMENT (STUDENT)
    ------------------------------------------------- */
    public void submitAssignment(Assignment assignment) {

        Assignment newAssignment = new Assignment(
                assignment.getStudentUsername(),
                assignment.getStudentName(),
                assignment.getRollNo(),
                assignment.getBranch(),
                assignment.getYear(),
                assignment.getSubject(),
                assignment.getFileName()
        );

        assignments.add(newAssignment);
    }

    /* -------------------------------------------------
       2️⃣ COUNT ASSIGNMENTS (STUDENT DASHBOARD)
    ------------------------------------------------- */
    public long getAssignmentCount(String studentUsername) {
        return assignments.stream()
                .filter(a -> a.getStudentUsername().equals(studentUsername))
                .count();
    }

    /* -------------------------------------------------
       3️⃣ STUDENT ASSIGNMENT HISTORY
    ------------------------------------------------- */
    public List<Assignment> getAssignmentsByStudent(String studentUsername) {
        return assignments.stream()
                .filter(a -> a.getStudentUsername().equals(studentUsername))
                .collect(Collectors.toList());
    }

    /* -------------------------------------------------
       4️⃣ FACULTY DASHBOARD – ALL ASSIGNMENTS
    ------------------------------------------------- */
    public List<Assignment> getAllAssignments() {
        return assignments;
    }

    /* -------------------------------------------------
       5️⃣ FACULTY FILTERS (YEAR + BRANCH)
    ------------------------------------------------- */
    public List<Assignment> getAssignmentsByYearAndBranch(int year, String branch) {
        return assignments.stream()
                .filter(a -> a.getYear() == year && a.getBranch().equalsIgnoreCase(branch))
                .collect(Collectors.toList());
    }

    /* -------------------------------------------------
       6️⃣ REVIEW ASSIGNMENT (FACULTY)
    ------------------------------------------------- */
    public void reviewAssignment(int index, String facultyRemark) {
        if (index < 0 || index >= assignments.size()) return;

        Assignment assignment = assignments.get(index);
        assignment.setStatus("REVIEWED");
        assignment.setFacultyRemark(facultyRemark);
    }

    /* -------------------------------------------------
       7️⃣ GRADE ASSIGNMENT (FACULTY)
    ------------------------------------------------- */
    public void gradeAssignment(int index, int score) {
        if (index < 0 || index >= assignments.size()) return;

        Assignment assignment = assignments.get(index);
        assignment.setStatus("GRADED");
        assignment.setScore(score);
    }
}
