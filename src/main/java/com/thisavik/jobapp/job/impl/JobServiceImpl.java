package com.thisavik.jobapp.job.impl;

import com.thisavik.jobapp.company.Company;
import com.thisavik.jobapp.company.CompanyRepository;
import com.thisavik.jobapp.job.Job;
import com.thisavik.jobapp.job.JobRepository;
import com.thisavik.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
    CompanyRepository companyRepository;

    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public boolean createJob(Job job) {
        Company company = companyRepository.findById(job.getCompany().getId()).orElse(null);
        if (company != null) {
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public Job findByJobId(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        if(jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
