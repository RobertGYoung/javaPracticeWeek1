
public abstract class CarPart implements Functional {
private int condition =100;



public int getCondition() {
	return condition;
}



public void setCondition(int condition) {
	this.condition = condition;
}



public void status() {
	
	System.out.println("The condition is: "+this.condition);
}


}
