import java.io.IOException;
import java.util.HashMap;
/*
 * 
 * Maciej Skowyra
 * 
 */

//pe³nomocnik
//wykorzystuje singleton bo chce zeby w systemie znajdowal sie wylacznie jeden obiekt ktory bedzie zarzadzal 
//plikami zbuforowanymi i niezbuforowanymi
public class IOManager {
	private static IOManager instance = null;
	
	private HashMap<String, BufferedFile> filesMap; 
	
	private IOManager() {	
		filesMap = new HashMap<String, BufferedFile>();
	}
		
	public static IOManager getInstance() {
		if( instance == null ) {
			instance = new IOManager();
		}
		
		return instance;
	}
	
	BufferedFile get(String fileName) throws IOException {
		
		if(!filesMap.containsKey(fileName)) {
			
			BufferedFile bf = new BufferedFile(fileName);
			filesMap.put(fileName, bf);
			
			return bf;
		}
		
		return filesMap.get(fileName);
	}	
}
