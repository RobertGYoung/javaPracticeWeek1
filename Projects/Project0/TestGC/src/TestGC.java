

	public class TestGC {
		 public static void main(String args[]){
			 TestGC s1=new TestGC();
			 TestGC s2=new TestGC();
		  s1=null;
		  s2=null;
		  System.gc();
		  
		 }
		 public void finalize(){
			 System.out.println("object is garbage collected");
			 }
	}

