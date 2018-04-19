/**
 * 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 * this class is an interface which have some methods that other classes need to override
 */
public interface Car {
	public String getRegistrationNumber();
	/**
	 * 
	 * @return the car's max fueltank
	 */
	public int getMaxFuelTank();
	/**
	 * 
	 * @return the car's current fueltank
	 */
	public int getCurrentFuelTank();
	/**
	 * 
	 * @return whether the car is full fuel
	 */
	public boolean isFullFuel();
	/**
	 * 
	 * @return whether the car is rented
	 */
	public boolean isRented();
	/**
	 * 
	 * @return the fuel need
	 */
	public int addFuelTank();
	/**
	 * 
	 * @param km the car will drive
	 * @return the fuel need
	 */
	public int drive(int km);
	/**
	 * set the fullFuel field
	 * @param fullFuel set whether it is full fuel
	 */
	public void setFullFuel(boolean fullFuel);
	/**
	 * @param rent set whether it is rented
	 */
	public void setRent(boolean rent);
}
