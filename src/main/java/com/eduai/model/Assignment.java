package com.eduai.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentUsername;
    private String title;
    private String content;

    private String branch;
    private int studyYear;   // ✅ FIXED

    private String status;
    private Integer score;
    private String facultyRemark;
}
