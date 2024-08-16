package com.thisavik.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    boolean createJob(Job job);
    Job findByJobId(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}