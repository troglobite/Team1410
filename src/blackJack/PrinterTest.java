package blackJack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrinterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src\\blackJack\\leaderBoard.txt"), true))) {
			for(int i = 0; i<10; i++) {
				pw.print(String.valueOf(i));
				pw.println();
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
