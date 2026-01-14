package com.eduai.repository;

import com.eduai.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByStudentUsername(String studentUsername);

    long countByStudentUsername(String studentUsername);

    List<Assignment> findByStudyYearAndBranch(int StudyYear, String branch);
}
