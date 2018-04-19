
/**
 * This class is implements some methods in class Car and it is an abstract class 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 * 
 */
public abstract class AbstractCar implements Car{
	protected RegistrationNumber registrationNumber;
	protected int maxFuelTank;
	protected int currentTank;
	protected boolean fullFuel;
	protected boolean rent;
	/**
	 * 
	 * @param maxFuelTank the capacity in whole Litres of the car's fueltank;
	 * @param currentTank the current fuel tank of the car
	 * @param fullFuel Whether the car is full of oil
	 * @param rent Whether the car is rented
	 */
	public AbstractCar(int maxFuelTank, int currentTank, boolean fullFuel, boolean rent) {
		this.registrationNumber = RegistrationNumber.getInstance();
		this.maxFuelTank = maxFuelTank;
		this.currentTank = currentTank;
		this.fullFuel = fullFuel;
		this.rent = rent;
	}
	/**
	 * set the fullFuel field
	 * @param fullFuel set whether it is fullfuel
	 */
	public void setFullFuel(boolean fullFuel) {
		this.fullFuel = fullFuel;
	}
	/**
	 * @param rent whether it is rented
	 */
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	/**
	 * 
	 * @return the registration number of the car
	 */
	public String getRegistrationNumber(){
		return registrationNumber.RegistrationNumberStr();
	}
	/**
	 * 
	 * @return the car's max fueltank
	 */
	public int getMaxFuelTank(){
		return maxFuelTank;
	}
	/**
	 * 
	 * @return the car's current fueltank
	 */
	public int getCurrentFuelTank() {
		return currentTank;
	}
	/**
	 * 
	 * @return whether the car is full fuel
	 */
	public boolean isFullFuel() {
		return fullFuel;
	}
	/**
	 * 
	 * @return whether the car is rented
	 */
	public boolean isRented() {
		return rent;
	}
	/**
	 * 
	 * @return the fuel need
	 */
	public int addFuelTank() {
		int rest = maxFuelTank - currentTank;
		currentTank =  maxFuelTank;
		return rest;
	}
	/**
	 * 
	 * @param km the car will drive
	 * @return the fuel need
	 */
	public abstract int drive(int km);
	@Override
	public String toString() {
		return "AbstractCar [registrationNumber=" + registrationNumber + ", maxFuelTank=" + maxFuelTank
				+ ", currentTank=" + currentTank + ", fullFuel=" + fullFuel + ", rent=" + rent + "]";
	}
	
}
