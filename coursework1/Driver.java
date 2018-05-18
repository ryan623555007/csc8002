/**
 * This simple class is used to store driver 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 * 
 */
public class Driver {
	private DrivingLicence licence;
	private Car car;
	/**
	 * 
	 * @return the licence of driver
	 */
	public DrivingLicence getLicence() {
		return licence;
	}
	/**
	 * 
	 * @param licence the licence of driver
	 */
	public void setLicence(DrivingLicence licence) {
		this.licence = licence;
	}
	/**
	 * 
	 * @return the car which driver rented
	 */
	public Car getCar() {
		return car;
	}
	/**
	 * 
	 * @param car the car which driver want to rented
	 */
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Driver [licence=" + licence + ", car=" + car + "]";
	}
	
	
}
