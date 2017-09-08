package c03ex10_12;

import java.io.File;

public class File_Main {

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\Filip\\Desktop");
		File file = new File("C:\\Users\\Filip\\Downloads");
		
		File[] directories = MyFile.getDirectoriesFrom(directory);
		System.out.println("----------------> Subdirectories from " + directory.getAbsolutePath());
		for (File dir : directories) {
			System.out.println(dir.getName());
		}

		String[] files = MyFile.getFileFrom(file, ".exe");
		System.out.println("----------------> Files from dictionary " + file.getAbsolutePath());
		for (String f : files) {
			System.out.println(f);
		}
	}

}
