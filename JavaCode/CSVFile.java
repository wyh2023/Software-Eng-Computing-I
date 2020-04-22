import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CSVFile {

	public static void main(String[] args) {
		String filePath = CSVFile.class.getClassLoader().getResource("data.txt").getPath();
		printCSVFile(filePath);
	}
	
	public static void printCSVFile(String filePath) {
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			System.out.println("Last    Fisrt    Salary");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				System.out.println(tempString.replace(",", "    "));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignored) {
				}
			}
		}
	}
}
