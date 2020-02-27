
public class Engine extends CarPart{

boolean engineIsRunning = false;
Car thisCar=null;

public Engine(Car Car) {
	this.thisCar=Car;
}



public void startEngine() {
	
	System.out.println("You try to start the engine..");
	
	if(engineIsRunning==true) {
		System.out.println("The engine makes a terrible sound,the engine is already running!");
	}
	else if(thisCar.carFuelTank.getFuelLevel()==0) {
		System.out.println("THere is no fuel, use the fillTank() on the Fuel Tank0- the car did not start");
	}
	else
		
	System.out.println("Started successfully");
}
public void function(){
	if(engineIsRunning==true) {
	System.out.println("Engine:Running");
	}
	else {
		System.out.println("Engine:Off, use the startEngine() method");
	}
}
}
