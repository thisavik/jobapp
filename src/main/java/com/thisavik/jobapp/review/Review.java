package com.thisavik.jobapp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thisavik.jobapp.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@Table(name = "job_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    private Company company;
}
