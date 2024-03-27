package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.model.JobApplication;
import exception.DBConnectionException;

public class JobApplicationDAO {
    // Method to insert job application details into the "Applications" table
    public void submitJobApplication(Connection connection, JobApplication jobApplication) throws DBConnectionException {
        try {
            String sql = "INSERT INTO Applications (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, jobApplication.getJobID());
            statement.setInt(2, jobApplication.getApplicantID());
            statement.setDate(3, new java.sql.Date(jobApplication.getApplicationDate().getTime()));
            statement.setString(4, jobApplication.getCoverLetter());
            // Execute insert statement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBConnectionException("Error submitting job application into database.");
        }
    }
}
