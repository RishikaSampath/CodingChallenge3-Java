package entity.model;

import java.util.List;
import java.util.ArrayList;

public class Company {
    private int companyID;
    private String companyName;
    private String location;
    private List<JobListing> jobListings;

    public Company(int companyID, String companyName, String location) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.location = location;
        this.jobListings = new ArrayList<>();
    }

    public int getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public List<JobListing> getJobListings() {
        return jobListings;
    }

    public void postJob(String jobTitle, String jobDescription, String jobLocation,
                       double salary, String jobType, String postedDate) {
        // Increment jobID based on the existing jobListings size
        int jobID = jobListings.size() + 1;
        JobListing newJobListing = new JobListing(jobID, companyID, jobTitle, jobDescription,
                jobLocation, salary, jobType, postedDate);
        jobListings.add(newJobListing);
    }

    public List<JobListing> getJobs() {
        return jobListings;
    }
}
