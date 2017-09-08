package c06ex14;

import java.util.ArrayList;

public class Close {

	public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws CloseException {
		for (T elem : elems) {
			try {
				elem.close();
			} catch (Exception e) {
				throw new CloseException("Problem with close", e);
			}
		}
	}
}