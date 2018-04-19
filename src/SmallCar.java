/**
 * This class extends AbstractCar and override drive method toString method. 
 * The drive method is used to caculate consume of fuel when drive small car.
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public class SmallCar extends AbstractCar{
	/**
	 * Constructor
	 */
	public SmallCar() {
		super(49, 49, true, false);
	}
	/**
	 * Override drive method to caculate consume of fuel
	 */
	@Override
	public int drive(int km) {
		if(currentTank <= 0) {
			System.out.println("This car doesn't have enough fuel tank.");
			return 0;
		}
		if(currentTank == maxFuelTank) {
			setFullFuel(false);
		}
		int temp = km/20 + 1;
		if(km % 20 == 0) {
			temp = km / 20;
		}
		if(currentTank - temp < 0) {
			System.out.println("The car drive "+currentTank*20+" Kilometres and has no fuel tank.");
			temp = currentTank;
			currentTank = 0;
			return temp;
		}else{
			currentTank = currentTank - temp;
			return temp;
		}
	}

	@Override
	public String toString() {
		return "SmallCar []";
	}

}
