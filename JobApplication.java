package entity.model;
import exception.ApplicationDeadlineException;

public class JobApplication {
	    private int applicationID;
	    private int jobID;
	    private int applicantID;
	    private String applicationDate;
	    private String coverLetter;

	    public JobApplication(int applicationID, int jobID, int applicantID, String applicationDate, String coverLetter) {
	        this.applicationID = applicationID;
	        this.jobID = jobID;
	        this.applicantID = applicantID;
	        this.applicationDate = applicationDate;
	        this.coverLetter = coverLetter;
	    }
	    
	    private boolean submissionAfterDeadline; 

	    public void setSubmissionAfterDeadline(boolean submissionAfterDeadline) {
	        this.submissionAfterDeadline = submissionAfterDeadline;
	    }

	    public void submitApplication() throws ApplicationDeadlineException {
	        
	        if (submissionAfterDeadline) {
	            throw new ApplicationDeadlineException("Application deadline has passed.");
	        }
	    }

	    public int getApplicationID() {
	        return applicationID;
	    }

	    public int getJobID() {
	        return jobID;
	    }

	    public int getApplicantID() {
	        return applicantID;
	    }

	    public String getApplicationDate() {
	        return applicationDate;
	    }

	    public String getCoverLetter() {
	        return coverLetter;
	    }
	}


