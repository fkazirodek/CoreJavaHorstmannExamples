package c06ex14;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String url = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\miasta.txt";
		PrintStream p1 = null; // new PrintStream(url);
		PrintStream p2 = new PrintStream(url);
		ArrayList<PrintStream> ps = new ArrayList<>();
		ps.add(p1);
		ps.add(p2);
		try {
			Close.closeAll(ps);
		} catch (CloseException e) {
			e.printStackTrace();
		}
	}

}
