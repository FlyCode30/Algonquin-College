package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This is a static class used to read files from a folder.
 */

public class Reader {
    
	/**
	 * Reads a folder path, creates a StringBuilder object, and appends the contents of the files to the StringBuilder.
	 * 
	 * @param folderPath the path to the folder
	 * @param maxFiles   the maximum number of files to read
	 * @return the contents of the files as a string
	 */
	public static String readStringFiles(String folderPath, int maxFiles) {
		StringBuilder sb = new StringBuilder();
		try (Stream<Path> paths = Files.walk(Paths.get(folderPath), 1)) { // Only look in the specified folder
			paths.filter(Files::isRegularFile)
			.limit(maxFiles)
			.forEach(file -> {
				try (BufferedReader reader = Files.newBufferedReader(file)) {
					String line;
					while ((line = reader.readLine()) != null) {
						// Process each line here
						sb.append(line + "\n");
					}
					sb.append("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
