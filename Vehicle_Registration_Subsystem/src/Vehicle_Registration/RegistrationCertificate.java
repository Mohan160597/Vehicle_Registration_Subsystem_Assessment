package Vehicle_Registration;
import java.io.Serializable;
import java.util.Date;

// Class representing a registration certificate
@SuppressWarnings("serial")
public class RegistrationCertificate implements Serializable {
    private String certificateId;
    private String registrationNumber;
    private Date issueDate;
    private Date expiryDate;

    // Constructor
    public RegistrationCertificate(String certificateId, String registrationNumber, Date issueDate, Date expiryDate) {
        this.certificateId = certificateId;
        this.registrationNumber = registrationNumber;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "RegistrationCertificate{" +
                "certificateId='" + certificateId + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}


