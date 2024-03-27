package Main;

import entity.model.*;

public class Main {
    public static void main(String[] args) {
        // Initialize the database schema
        DatabaseManager.initializeDatabase();

        // Insert sample data into the database
        DatabaseManager.insertSampleData();

        // Retrieve and print job listings
        System.out.println("Job Listings:");
        for (JobListing jobListing : DatabaseManager.getJobListings()) {
            System.out.println(jobListing);
        }
        System.out.println();

        // Retrieve and print companies
        System.out.println("Companies:");
        for (Company company : DatabaseManager.getCompanies()) {
            System.out.println(company);
        }
        System.out.println();

        // Retrieve and print applicants
        System.out.println("Applicants:");
        for (Applicant applicant : DatabaseManager.getApplicants()) {
            System.out.println(applicant);
        }
        System.out.println();

        // Retrieve and print job applications for a specific job listing (e.g., job ID = 1)
        int jobIdToSearch = 1;
        System.out.println("Job Applications for Job ID " + jobIdToSearch + ":");
        for (JobApplication jobApplication : DatabaseManager.getApplicationsForJob(jobIdToSearch)) {
            System.out.println(jobApplication);
        }
    }
}
