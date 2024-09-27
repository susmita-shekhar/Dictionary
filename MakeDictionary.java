package dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MakeDictionary {

	public static void main(String[] args) {

		String path = "src\\dictionary\\data.properties";
		MakeDictionary dic = new MakeDictionary();
		System.out.println(dic.doesFileExists(path) ? "File Exists" : "File doesn't exists");

		if (dic.doesFileExists(path)) {
			Properties prop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(path);
				prop.load(fs);
				
				for (String key : prop.stringPropertyNames()) {
                    String value = prop.getProperty(key);
                    System.out.println(key + ": " + value);
                }
				
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public boolean doesFileExists(String path) {
		try {
			File file = new File(path);
			return file.exists();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
}
