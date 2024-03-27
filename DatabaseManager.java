package entity.model;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatabaseManager {
	
	    private static final String URL = "jdbc:mysql://localhost:3306/careerhub";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "Rishika@12";

	    
	    public static void initializeDatabase() {
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	             Statement statement = connection.createStatement()) {
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static void insertSampleData() {
	        insertJobListing(1, 1, "Software Engineer", "Job description for software engineer position", "New York", 80000.0, "Full-time", "2024-03-28");
	        insertJobListing(2, 1, "Data Analyst", "Job description for data analyst position", "San Francisco", 75000.0, "Full-time", "2024-03-29");
	        insertJobListing(3, 2, "Marketing Specialist", "Job description for marketing specialist position", "Los Angeles", 70000.0, "Full-time", "2024-03-30");
	        insertJobListing(4, 3, "Accountant", "Job description for accountant position", "Chicago", 65000.0, "Full-time", "2024-03-31");
	        insertJobListing(5, 4, "HR Manager", "Job description for HR manager position", "Houston", 70000.0, "Full-time", "2024-04-01");

	        insertCompany(1, "Hexaware Technologies", "New York");
	        insertCompany(2, "Google", "Mountain View");
	        insertCompany(3, "Facebook", "Menlo Park");
	        insertCompany(4, "Amazon", "Seattle");
	        insertCompany(5, "Microsoft", "Redmond");

	        insertApplicant(1, "John", "Doe", "john.doe@example.com", "1234567890", "John's resume content");
	        insertApplicant(2, "Jane", "Smith", "jane.smith@example.com", "9876543210", "Jane's resume content");
	        insertApplicant(3, "Alice", "Johnson", "alice.johnson@example.com", "1112223333", "Alice's resume content");
	        insertApplicant(4, "Bob", "Brown", "bob.brown@example.com", "4445556666", "Bob's resume content");
	        insertApplicant(5, "Eve", "Taylor", "eve.taylor@example.com", "7778889999", "Eve's resume content");

	        insertJobApplication(1, 1, 1, "2024-03-28", "Cover letter for job application 1");
	        insertJobApplication(2, 2, 2, "2024-03-29", "Cover letter for job application 2");
	        insertJobApplication(3, 3, 3, "2024-03-30", "Cover letter for job application 3");
	        insertJobApplication(4, 4, 4, "2024-03-31", "Cover letter for job application 4");
	        insertJobApplication(5, 5, 5, "2024-04-01", "Cover letter for job application 5");
	    }

	    
	    private static void insertJobListing(int jobID, int companyID, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType, String postedDate) {
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO JobListing VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
	            statement.setInt(1, jobID);
	            statement.setInt(2, companyID);
	            statement.setString(3, jobTitle);
	            statement.setString(4, jobDescription);
	            statement.setString(5, jobLocation);
	            statement.setDouble(6, salary);
	            statement.setString(7, jobType);
	            statement.setString(8, postedDate);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    private static void insertCompany(int companyID, String companyName, String location) {
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO Company VALUES (?, ?, ?)")) {
	            statement.setInt(1, companyID);
	            statement.setString(2, companyName);
	            statement.setString(3, location);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	   
	    private static void insertApplicant(int applicantID, String firstName, String lastName, String email, String phone, String resume) {
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO Applicant VALUES (?, ?, ?, ?, ?, ?)")) {
	            statement.setInt(1, applicantID);
	            statement.setString(2, firstName);
	            statement.setString(3, lastName);
	            statement.setString(4, email);
	            statement.setString(5, phone);
	            statement.setString(6, resume);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	   
	    private static void insertJobApplication(int applicationID, int jobID, int applicantID, String applicationDate, String coverLetter) {
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO JobApplication VALUES (?, ?, ?, ?, ?)")) {
	            statement.setInt(1, applicationID);
	            statement.setInt(2, jobID);
	            statement.setInt(3, applicantID);
	            statement.setString(4, applicationDate);
	            statement.setString(5, coverLetter);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static List<JobListing> getJobListings() {
	        List<JobListing> jobListings = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                PreparedStatement statement = connection.prepareStatement("SELECT * FROM JobListing");
	                ResultSet resultSet = statement.executeQuery()) {
	               while (resultSet.next()) {
	                   int jobID = resultSet.getInt("JobID");
	                   int companyID = resultSet.getInt("CompanyID");
	                   String jobTitle = resultSet.getString("JobTitle");
	                   String jobDescription = resultSet.getString("JobDescription");
	                   String jobLocation = resultSet.getString("JobLocation");
	                   double salary = resultSet.getDouble("Salary");
	                   String jobType = resultSet.getString("JobType");
	                   String postedDate = resultSet.getString("PostedDate");
	                   JobListing jobListing = new JobListing(jobID, companyID, jobTitle, jobDescription, jobLocation, salary, jobType, postedDate);
	                   jobListings.add(jobListing);
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	        return jobListings;
	    }


	    
	    public static List<Company> getCompanies() {
	        List<Company> companies = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Company");
	                ResultSet resultSet = statement.executeQuery()) {
	               while (resultSet.next()) {
	                   int companyID = resultSet.getInt("CompanyID");
	                   String companyName = resultSet.getString("CompanyName");
	                   String location = resultSet.getString("Location");
	                   Company company = new Company(companyID, companyName, location);
	                   companies.add(company);
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	           return companies;
	       }
	    

	    
	    public static List<Applicant> getApplicants() {
	        List<Applicant> applicants = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Applicant");
	                ResultSet resultSet = statement.executeQuery()) {
	               while (resultSet.next()) {
	                   int applicantID = resultSet.getInt("ApplicantID");
	                   String firstName = resultSet.getString("FirstName");
	                   String lastName = resultSet.getString("LastName");
	                   String email = resultSet.getString("Email");
	                   String phone = resultSet.getString("Phone");
	                   String resume = resultSet.getString("Resume");
	                   Applicant applicant = new Applicant(applicantID, firstName, lastName, email, phone, resume);
	                   applicants.add(applicant);
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	        return applicants;
	    }

	    
	    public static List<JobApplication> getApplicationsForJob(int jobID) {
	        List<JobApplication> jobApplications = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                PreparedStatement statement = connection.prepareStatement("SELECT * FROM JobApplication WHERE JobID = ?");
	                ) {
	               statement.setInt(1, jobID);
	               ResultSet resultSet = statement.executeQuery();
	               while (resultSet.next()) {
	                   int applicationID = resultSet.getInt("ApplicationID");
	                   int applicantID = resultSet.getInt("ApplicantID");
	                   String applicationDate = resultSet.getString("ApplicationDate");
	                   String coverLetter = resultSet.getString("CoverLetter");
	                   JobApplication jobApplication = new JobApplication(applicationID, jobID, applicantID, applicationDate, coverLetter);
	                   jobApplications.add(jobApplication);
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	        return jobApplications;
	    }
   }

