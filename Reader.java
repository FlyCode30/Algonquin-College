package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader {
    
    // create a method that will return a string files read from the folder
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
