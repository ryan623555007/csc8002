import java.util.Date;
/**
 * This class create some parameters about driving licence and override toString method
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 * This class 
 */
public class DrivingLicence {
	
	private Name name;
	private Date birth;
	private LicenceNumber licenceNumber;
	private Date issueDate;
	private boolean fullDrivingLicence;
	/**
	 * Constructor
	 * @param firstName firstname
	 * @param lastName last name
	 * @param birth birthday
	 * @param issueDate issue date
	 * @param fullDrivingLicence which is driver's full driving licence
	 */
	public DrivingLicence(String firstName, String lastName, Date birth,  Date issueDate,
			boolean fullDrivingLicence) {
		super();
		name = new Name(firstName, lastName);
		this.birth = birth;
		licenceNumber = LicenceNumber.getInstance(issueDate, firstName, lastName);
		this.issueDate = issueDate;
		this.fullDrivingLicence = fullDrivingLicence;
		
	}
	/**
	 * 
	 * @return firstname
	 */
	public String getFirstName() {
		return name.getFirstName();
	}
	/**
	 * 
	 * @return last name
	 */
	public String getLastName() {
		return name.getLastName();
	}
	/**
	 * 
	 * @return birthday
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 
	 * @return licence number
	 */
	public String getLicenceNumber() {
		return licenceNumber.getLicenceNumber();
	}
	/**
	 * 
	 * @return issue date
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * 
	 * @param issueDate issue date
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * 
	 * @return is full driving licence
	 */
	public boolean isFullDrivingLicence() {
		return fullDrivingLicence;
	}
	/**
	 * 
	 * @param fullDrivingLicence which is driver's fulldrivinglicence
	 */
	public void setFullDrivingLicence(boolean fullDrivingLicence) {
		this.fullDrivingLicence = fullDrivingLicence;
	}
	@Override
	public String toString() {
		return "DrivingLicence [name=" + name + ", birth=" + birth + ", licenceNumber=" + licenceNumber + ", issueDate="
				+ issueDate + ", fullDrivingLicence=" + fullDrivingLicence + "]";
	}
	
}
