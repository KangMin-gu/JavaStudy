package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;
import test.mypac.YourRemocon;

public class MainClass02 {
	public static void main(String[] args) {
		
		useRemocon(new YourRemocon());
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}




