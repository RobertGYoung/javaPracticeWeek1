
public class FuelTank extends CarPart {

private int fuelLevel =0;
public Car thisCar = null;

public FuelTank(Car Car){
	this.thisCar=Car;
}


public  int getFuelLevel() {
	return fuelLevel;
}



public void fillTank() {
	fuelLevel =100;
	System.out.println("You filled the fuel tank");
}

public void function() {
	if(fuelLevel<10&&fuelLevel>0) {
		System.out.println("The car is running on fumes, use fillTank() method");
	}
	else if(fuelLevel==0) {
		System.out.println("The car cannot start because the tank is empty, use fillTank()");
	}
	else {
		System.out.println("The fuel levels are okay and the car is ready to travel");
	}
	}
}
