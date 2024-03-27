package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.model.Applicant;
import exception.DBConnectionException;

public class ApplicantDAO {
    // Method to insert applicant data into the "Applicants" table
    public void createApplicantProfile(Connection connection, Applicant applicant) throws DBConnectionException {
        try {
            String sql = "INSERT INTO Applicants (FirstName, LastName, Email, Phone, Resume) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, applicant.getFirstName());
            statement.setString(2, applicant.getLastName());
            statement.setString(3, applicant.getEmail());
            statement.setString(4, applicant.getPhone());
            statement.setString(5, applicant.getResume());
            // Execute insert statement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBConnectionException("Error inserting applicant data into database.");
        }
    }
}
