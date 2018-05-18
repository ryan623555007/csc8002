/**
 * 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 * this class is carfactory that create small car and large car
 */
public class CarFactory {
	public final static int SMALL_CAR = 1;
	public final static int LARGE_CAR = 2;
	/**
	 * 
	 * @param type the type of car
	 * @return a new car
	 */
	public static Car createCar(int type) {
		Car car = null;
		if(type == SMALL_CAR) {
			car = new SmallCar();
		}else if(type == LARGE_CAR){
			car = new LargeCar();
		}
		return car;
	}
}
