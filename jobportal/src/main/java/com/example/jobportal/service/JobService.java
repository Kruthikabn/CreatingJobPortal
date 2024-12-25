package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    // Create a new job
    public Job createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return job;
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobs;
    }

    // Get a job by ID
    public Optional<Job> getJobById(Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst();
    }

    // Delete a job by ID
    public boolean deleteJob(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }
}
