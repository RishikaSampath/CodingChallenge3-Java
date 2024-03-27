package entity.model;
import java.util.List;
import java.util.ArrayList;

public class JobListing {
	    private int jobID;
	    private int companyID;
	    private String jobTitle;
	    private String jobDescription;
	    private String jobLocation;
	    private double salary;
	    private String jobType;
	    private String postedDate;
	    private List<Applicant> applicants;

	    public JobListing(int jobID, int companyID, String jobTitle, String jobDescription, String jobLocation,
	                      double salary, String jobType, String postedDate) {
	        this.jobID = jobID;
	        this.companyID = companyID;
	        this.jobTitle = jobTitle;
	        this.jobDescription = jobDescription;
	        this.jobLocation = jobLocation;
	        this.salary = salary;
	        this.jobType = jobType;
	        this.postedDate = postedDate;
	        this.applicants = new ArrayList<>();
	    }

	    public int getJobID() {
	        return jobID;
	    }

	    public int getCompanyID() {
	        return companyID;
	    }

	    public String getJobTitle() {
	        return jobTitle;
	    }

	    public String getJobDescription() {
	        return jobDescription;
	    }

	    public String getJobLocation() {
	        return jobLocation;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public String getJobType() {
	        return jobType;
	    }

	    public String getPostedDate() {
	        return postedDate;
	    }

	    public List<Applicant> getApplicants() {
	        return applicants;
	    }

	    public void apply(int applicantID, String coverLetter) {
	        // Assuming applicant ID and cover letter are added to applicants list
	        applicants.add(new Applicant(applicantID, coverLetter));
	    }
	}

