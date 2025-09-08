package config;

import java.io.FileInputStream;
import java.util.Properties;


//This class is responsible for loading and reading test data from configuration files
public class ConfigReader {
	
	
	
	
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



	// Declare a Properties object to store configuration data
	private static Properties properties;

	//Static block used to load configuration file and read test data.
	//Runs once when the class is first loaded.
	static {

		try {


			// Create a FileInputStream to read data from the specified file path
			FileInputStream fileInput = new FileInputStream("config file path");


			//Initialize the Properties object to work with the configuration file
			properties = new Properties(); 


			//Initialize the Properties object to work with the configuration file
			properties.load(fileInput);
			
			
			
	

		}catch(Exception e) {

			e.getStackTrace();

			e.printStackTrace();

		}	
	}
	
	
	
	//this method will get test data value as a string
	public static String getConfigData(String testValue) {
		
		return properties.getProperty(testValue);
		
	}




}