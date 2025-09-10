package configSetup;

import java.io.FileInputStream;

public class FileBase2 {
	
	protected String filePath;
	
public FileBase2(String filePath) {
		
		this.filePath = filePath;
		
	}

public void fileStream() {
	
	FileInputStream file = new FileInputStream(filePath);
	
}
	
	
	


}
