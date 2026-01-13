package com.eduai.repository;

import com.eduai.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    long countByUsername(String username);

    List<Assignment> findByUsername(String username);

    List<Assignment> findByYearAndBranch(int year, String branch);
}
