import java.util.ArrayList;
import java.util.List;

public class Car {

	public List<CarPart> carPartList = new ArrayList<CarPart>();
	public FuelTank carFuelTank =new FuelTank(this);
	public Engine carEngine =new Engine(this);
	public Wheels carWheels =new Wheels();

	public Car() {
		
		
		carPartList.add(carFuelTank);
		carPartList.add(carEngine);
		carPartList.add(carWheels);
	
		
	}
	
	public void run() {
		
		for(int i =0;i<carPartList.size();i++) {
			carPartList.get(i).function();
		}
	}
}
