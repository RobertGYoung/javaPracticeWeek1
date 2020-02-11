public class addAll{
	public static void main(String[] args){
int[] tempArray = new int[args.length];
for(int i=0;i<args.length;i++){
tempArray[i]=Integer.parseInt(args[i]);
}
System.out.println(add(tempArray));

}

public static int add(int...n){ // n is an internal array after spread
int sum = 0;
for(int i =0;i<n.length;i++){
sum=sum+n[i];

}

return sum;
}


}
