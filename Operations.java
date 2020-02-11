public class Operations{
	public static void main(String[] args){
		String opName=args[0];
		float[] tempArray = new float[args.length];
			for(int i=1;i<args.length;i++){
				tempArray[i]=Float.parseFloat(args[i]);
				}
		System.out.println(operate(opName, tempArray));		
		}
public static float operate(String opName, float...n){ // n is an internal array after spread
switch(opName){

case "add":
	float sum = 0;
	for(int i =0;i<n.length;i++){
	sum=sum+n[i];
	}
	return sum;	
case "subtract":
	float dif = 0;
	for(int i=1;i<n.length;i++){
	if(i==1){
	dif=n[i];
	}
	else{
	dif=dif-n[i];
	}
	}
	return dif;	
case "divide":
	float quo = 0;
	for(int i=1;i<n.length;i++){
	if(i==1){
	quo=n[i];
	}
	else{
	quo=quo/n[i];
	}
	}
	return quo;

case "multiply":
	float prod=1;
	for(int i =1;i<n.length;i++){
	prod=prod*n[i];
	}
	return prod;
default:
case "module":
	float mod = 1;
	for(int i =1;i<n.length;i++){
	if(i==1){
	mod=n[i];
	}
	else{
	mod=mod%n[i];
		}
	}
	return mod;


	}		
     }

}

