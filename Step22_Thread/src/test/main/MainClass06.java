package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 *  지역 변수는 메소드가 리턴되면 사라진다. 
		 */
		String name="김구라";
		new Thread() {
			@Override
			public void run() {
				System.out.println("name:"+name);
			}
		}.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("name:"+name);
			}
		}).start();
		
	}
	
}












