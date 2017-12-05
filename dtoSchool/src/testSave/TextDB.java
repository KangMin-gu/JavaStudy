package testSave;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextDB {
	
	public TextDB() {
		
	}
	
	public void save() {
		try {
			PrintWriter tDb = new PrintWriter(new BufferedWriter(new FileWriter("학생기록부.txt")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
