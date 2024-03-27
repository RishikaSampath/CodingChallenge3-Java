package entity.model;
import exception.InvalidEmailFormatException;
import exception.FileUploadException;
import java.io.File; 

public class Applicant {
	    private int applicantID;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phone;
	    private String resume;
	    private String coverLetter;

	    public Applicant(int applicantID, String firstName, String lastName, String email, String phone, String resume) {
	        this.applicantID = applicantID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phone = phone;
	        this.resume = resume;
	    }
	    
	    public void setEmail(String email) throws InvalidEmailFormatException {
	        if (!isValidEmail(email)) {
	            throw new InvalidEmailFormatException("Invalid email format.");
	        }
	        this.email = email;
	    }
	    
	    private boolean isValidEmail(String email) {
	        
	        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	    }
	    
	    public void uploadResume(String resumeFilePath) throws FileUploadException {
	       
	        try {
	            File resumeFile = new File(resumeFilePath);
	            
	           
	            if (!resumeFile.exists()) {
	                throw new FileUploadException("File not found: " + resumeFilePath);
	            }
	            
	         
	            if (resumeFile.length() > MAX_FILE_SIZE) {
	                throw new FileUploadException("File size exceeded: " + resumeFilePath);
	            }
	            
	           
	            String fileExtension = getFileExtension(resumeFilePath);
	            if (!isSupportedFormat(fileExtension)) {
	                throw new FileUploadException("Unsupported file format: " + fileExtension);
	            }
	            
	         
	        } catch (FileUploadException e) {
	            throw e; 
	        } catch (Exception e) {
	            throw new FileUploadException("Error uploading file: " + e.getMessage());
	        }
	    }
	    
	    private String getFileExtension(String fileName) {
	        int lastIndex = fileName.lastIndexOf(".");
	        if (lastIndex != -1 && lastIndex < fileName.length() - 1) {
	            return fileName.substring(lastIndex + 1);
	        }
	        return "";
	    }
	    
	    private boolean isSupportedFormat(String fileExtension) {
	        
	        return fileExtension.equalsIgnoreCase("pdf") || fileExtension.equalsIgnoreCase("docx");
	    }
	    
	  
	    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB

	    public int getApplicantID() {
	        return applicantID;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public String getResume() {
	        return resume;
	    }
	    
	    public String getCoverLetter() {
	        return coverLetter;
	    }

	    public void createProfile(String email, String firstName, String lastName, String phone) {
	        // Logic to create applicant profile
	    }

	    public void applyForJob(int jobID, String coverLetter) {
	        // Logic to apply for a job
	    }
	    
	    public Applicant(int applicantID, String coverLetter) {
	        this.applicantID = applicantID;
	        this.coverLetter = coverLetter;
	}
}


