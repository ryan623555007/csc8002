/**
 * This class extends AbstractCar and override drive method toString method. 
 * The drive method is used to caculate consume of fuel when drive large car.
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public class LargeCar extends AbstractCar{
/**
 * Constructor
 */
	public LargeCar() {
		super(60, 60, true, false);
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
		int use = 0;
		int temp = 0;
		if(km > 50) {
			if(currentTank < 5) {
				use = currentTank;
			}else{
				use = 5;
				temp = 15;
				currentTank = currentTank - use;
			}
		}else{
			temp = 10;
		}
		
		if(km % temp == 0) {
			temp = km/temp;
		}else{
			temp = km/temp + 1;
		}
		if(currentTank - temp < 0) {
			System.out.println("The car hasn't enough fuel tank.");
			use+= currentTank;
		}else{
			use += temp;
		}
		currentTank = currentTank - use;
		return use;
	}

	@Override
	public String toString() {
		return "LargeCar []";
	}

}
