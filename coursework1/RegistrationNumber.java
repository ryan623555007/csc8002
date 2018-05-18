import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * this class using a map to store RegistrationNumber and override toString method equals method.
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public final class RegistrationNumber {
    private static final Map<String, RegistrationNumber> Maps = new HashMap<String, RegistrationNumber>();
    private String rNumber;
    /**
     * Constructor 
     * @param number
     */
    private RegistrationNumber(String number) {
    	rNumber = number;
    }
    public static RegistrationNumber getInstance() {
    	Random ran = new Random();
    	String number = (char)('A'+ran.nextInt(26))+"";
    	number+= (ran.nextInt(9000)+1000)+"";
       if(Maps.containsKey(number)) {
    	   return getInstance();
       }else{
    	   RegistrationNumber r = new RegistrationNumber(number);
    	   Maps.put(number, r);
    	   return r;
       }
    }
    public String RegistrationNumberStr() {
        return rNumber;
    }
	@Override
	public String toString() {
		return "RegistrationNumber [rNumber=" + rNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rNumber == null) ? 0 : rNumber.hashCode());
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
		RegistrationNumber other = (RegistrationNumber) obj;
		if (rNumber == null) {
			if (other.rNumber != null)
				return false;
		} else if (!rNumber.equals(other.rNumber))
			return false;
		return true;
	}
    
}