package c03ex10_12;

import java.io.File;
import java.io.FileFilter;

public class MyFile {

	public static File[] getDirectoriesFrom(File directory) {
		if (directory.isDirectory() && directory.exists()) {
			return directory.listFiles(f -> f.isDirectory());

// Method Reference
			// return directory.listFiles(File::isDirectory);

// Anonymous inner class
			// return directory.listFiles(new FileFilter() {
			//
			// @Override
			// public boolean accept(File pathname) {
			// return pathname.isDirectory();
			// }
			// });

		} else {
			return null;
		}
	}

	public static String[] getFileFrom(File directory, String extension) {
		if (directory.isDirectory() && directory.exists()) {
			return directory.list((dir, name) -> name.toLowerCase().endsWith(extension));
		} else {
			return null;
		}
	}
}
