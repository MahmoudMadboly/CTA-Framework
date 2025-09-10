package configSetup;

public abstract class FileBase {
	
	protected String filePath;
	
	
	
	public FileBase(String filePath) {
		
		this.filePath = filePath;
		
	}
	
	
	//abstract method to load files
	public abstract void loadFile();
	
}