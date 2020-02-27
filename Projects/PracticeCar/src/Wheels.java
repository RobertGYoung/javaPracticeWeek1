
public class Wheels extends CarPart{

	public boolean hasAir = false;
	
	public void fillTires() {
		hasAir=true;
		System.out.println("You filled the tires");
	}
	
	public void function() {
		if(hasAir==false) {
		System.out.println("The tires need air! Use the fillTires() method");
		}
		else {
			System.out.println("The tires have air and are ready to go!");
		}
	}
}
