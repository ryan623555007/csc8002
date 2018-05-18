/**
 * This simple class store drive's firstname and lastname.
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public final class Name {
	private String firstName;
	private String lastName;
	/**
	 * Constructor
	 * @param firstName which is driver's firstname
	 * @param lastName which is driver's lastname 
	 */
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
