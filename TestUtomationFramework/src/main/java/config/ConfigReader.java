package config;

import java.io.FileInputStream;
import java.util.Properties;


//This class is responsible for loading and reading test data from configuration files
public class ConfigReader extends FileBase{
	
	
	
//get file path
	private static final String file_Path = "";

	
	// Declare a Properties object to store configuration data
	private static Properties properties;


	public ConfigReader() {

		super(file_Path);

	}

	
	
	//Static block used to load configuration file and read test data.
		//Runs once when the class is first loaded.
	static {

		try {

			FileInputStream fileStream = new FileInputStream(file_Path);

			properties = new Properties();

			properties.load(fileStream);


		}catch(Exception e) {

			e.getStackTrace();

			e.printStackTrace();

		}

	}



@Override
public void loadFile() {
	
	 // no-op, since static block already handled it
	
}


	


	//this method will get test data value as a string
	public static String getConfigData(String testValue) {

		return properties.getProperty(testValue);

	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * FileInputStream:
	 * >> will provide a stream of data from a file so other classes like "Properties" can read it.
	 * >> This opens the file and lets Java read its content byte by byte.
	 * 
	 * 
	 * Properties:
	 * >> Provides a way to access configuration data
	 * >> Works with .properties files.
	 * >> load data from a stream
	 * 
	 * 
	 * How this class work?
	 * >> FileInputStream opens the file at "config file path".
	 * >> properties.load(fileInput) reads the entire properties file into memory and stores all the key-value pairs in the Properties object.
	 * >> This happens once when the class is loaded, thanks to the static block.
	 * >> properties now contains all key-value pairs from your properties file in memory.
	 * >> The method does not open the file again.
	 * >> It simply looks inside the already-loaded Properties object in memory.
	 * 
	 * shortly:
	 * The method relies on the fact that the static block has already loaded the file.
	 * So the connection to the file is indirect: it happened during class loading, not in the method itself.
	 * */


}