package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.model.JobListing;
import exception.DBConnectionException;

public class JobListingDAO {
	public List<JobListing> getJobListingsBySalaryRange(Connection connection, double minSalary, double maxSalary) throws DBConnectionException {
        List<JobListing> jobListings = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Jobs WHERE Salary >= ? AND Salary <= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minSalary);
            statement.setDouble(2, maxSalary);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Create JobListing object from ResultSet
                JobListing jobListing = new JobListing();
                jobListing.setJobID(resultSet.getInt("JobID"));
                jobListing.setCompanyID(resultSet.getInt("CompanyID"));
                jobListing.setJobTitle(resultSet.getString("JobTitle"));
                jobListing.setJobDescription(resultSet.getString("JobDescription"));
                jobListing.setJobLocation(resultSet.getString("JobLocation"));
                jobListing.setSalary(resultSet.getDouble("Salary"));
                jobListing.setJobType(resultSet.getString("JobType"));
                jobListing.setPostedDate(resultSet.getDate("PostedDate"));
                // Add JobListing to list
                jobListings.add(jobListing);
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Error retrieving job listings by salary range from database.");
        }
        return jobListings;
    }
	public void postJobListing(Connection connection, JobListing jobListing) throws DBConnectionException {
        try {
            String sql = "INSERT INTO Jobs (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, jobListing.getCompanyID());
            statement.setString(2, jobListing.getJobTitle());
            statement.setString(3, jobListing.getJobDescription());
            statement.setString(4, jobListing.getJobLocation());
            statement.setDouble(5, jobListing.getSalary());
            statement.setString(6, jobListing.getJobType());
            // Execute insert statement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBConnectionException("Error posting job listing into database.");
        }
    }
    // Method to retrieve all job listings from the "Jobs" table
    public List<JobListing> getAllJobListings(Connection connection) throws DBConnectionException {
        List<JobListing> jobListings = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Jobs";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Create JobListing object from ResultSet
                JobListing jobListing = new JobListing();
                jobListing.setJobID(resultSet.getInt("JobID"));
                jobListing.setCompanyID(resultSet.getInt("CompanyID"));
                jobListing.setJobTitle(resultSet.getString("JobTitle"));
                jobListing.setJobDescription(resultSet.getString("JobDescription"));
                jobListing.setJobLocation(resultSet.getString("JobLocation"));
                jobListing.setSalary(resultSet.getDouble("Salary"));
                jobListing.setJobType(resultSet.getString("JobType"));
                jobListing.setPostedDate(resultSet.getDate("PostedDate"));
                // Add JobListing to list
                jobListings.add(jobListing);
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Error retrieving job listings from database.");
        }
        return jobListings;
    }
}
