
public class Song {
public Song() {
	try {
		callSong();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void callSong()throws InterruptedException {
	// TODO Auto-generated method stub
	System.out.println("  I know a song");
	Thread.sleep(1000);
	System.out.println("  that'll get on your nerves,  ");
	Thread.sleep(1000);
	System.out.println("  that'll get on your nerves,  ");
	Thread.sleep(1000);
	System.out.println("  that'll get on your nerves,  ");
	Thread.sleep(1000);
	System.out.println("  I know a song that'll get on your nerves  ");
	Thread.sleep(1000);
	System.out.println("  And this is how it goes");
	Thread.sleep(200);
	System.out.print(".");
	Thread.sleep(200);
	System.out.print(".");
	Thread.sleep(200);
	System.out.print(".");
	Thread.sleep(2000);

	callSong();
}
}
