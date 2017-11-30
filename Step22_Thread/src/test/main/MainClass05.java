package test.main;

public class MainClass05 {
	public static void main(String[] args) {
		// Runnable type 객체를 얻어내서 
	 	Runnable r1=new Runnable() {
			@Override
			public void run() {
				System.out.println("달려 ~ 달려~");
			}
		};
		//스레드를 시작 시킨다. 
		new Thread(r1).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("고고 ~");
			}
		}).start();
		
	}
}







