package c09examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ex08_ZipFile {

	public static void main(String[] args) {
		String uri = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.zip";
		String file1 = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		String file2 = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemstax5.txt";
		String file3 = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta_copy.txt";
		zipFiles(uri, file1, file2, file3);

	}

	private static void zipFiles(String uri, String... filesToZip) {
		FileInputStream in = null;
		try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(Paths.get(uri), StandardOpenOption.CREATE))) {
			for (String file : filesToZip) {
				zipOut.putNextEntry(new ZipEntry(Paths.get(file).getFileName().toString()));
				in = new FileInputStream(file);
				// byte[] b = new byte[1024];
				int count;
				while ((count = in.read()) > 0) {
					zipOut.write(count);
				}
			}
			if (in != null) {
				in.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
