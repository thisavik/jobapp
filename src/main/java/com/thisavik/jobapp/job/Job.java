package com.thisavik.jobapp.job;

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
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;
}
