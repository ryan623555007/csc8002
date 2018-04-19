import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * This class create some methods about LicenceNumber and override equals methods
 * Using a map to store LicenceNumber
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public final class LicenceNumber {
	
	private final static Map<String,LicenceNumber> Maps = new HashMap<>();
	private String number;
	private LicenceNumber(String number){
		this.number = number;
	}
	/**
	 * 
	 * @param issueDate issue date
	 * @param firstName first name
	 * @param lastName last name 
	 * @return a new licenceNumber object
	 */
	public static LicenceNumber getInstance(Date issueDate,String firstName,String lastName) {
		Calendar birthCalendar = new GregorianCalendar();
		birthCalendar.setTime(issueDate);
		String temp = (char)firstName.charAt(0) + "";
		temp += (char)lastName.charAt(0)+"";
		temp += "-"+birthCalendar.getWeekYear()+"-";
		Random ran = new Random();
		temp+=(ran.nextInt(90)+10)+"";
		if(Maps.containsKey(temp)) {
			return getInstance(issueDate, firstName, lastName);
		}else{
			LicenceNumber l = new LicenceNumber(temp);
			Maps.put(temp, l);
			return l;
		}
	}
	/**
	 * 
	 * @return the licence number
	 */
	public String getLicenceNumber() {
		return number;
	}
	@Override
	public String toString() {
		return "LicenceNumber [number=" + number + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicenceNumber other = (LicenceNumber) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
}
