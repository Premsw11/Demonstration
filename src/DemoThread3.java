
public class DemoThread3 implements Runnable {
String tname;
Thread t;
DemoThread3(String thread_name) {
	tname=thread_name;
	t=new Thread(this,tname);
	System.out.println("Just created thread" +t);
	t.start();
}
@Override
public void run() {
	try {
		for(int z=5;z>0;z--) {
			System.out.println("Kid Thread" +z);
			Thread.sleep(1000);
		}
	}
	catch(InterruptedException ie) {
		System.out.println(tname + "is interrupted");
		}
	System.out.println(tname + "is dying");
}
}
class MultiThreadImplement {
	public static void main(String[] args ) {
	new DemoThread3("One");
	new DemoThread3("Two");
	new DemoThread3("Three");
	try {
		Thread.sleep(10000);
	}
	catch(InterruptedException ie) {
		System.out.println("Main thread is interrupted");
	}
	System.out.println("Main thread is about to die");
	}			
}