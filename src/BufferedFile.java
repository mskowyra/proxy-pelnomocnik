import java.io.*;
import java.util.LinkedList;
import java.util.List;
/*
 * 
 * Maciej Skowyra
 * 
 */

//prawdziwy przedmiot
public class BufferedFile {
		
	private List<Integer> buffer;
	private String fileName;
	
	public BufferedFile(String fileName) throws IOException {	
		Reader reader = null;
		buffer = new LinkedList<Integer>();
		
		this.fileName = fileName; 
		
		try {
			Integer c = -1;			
			reader = new FileReader(fileName);
			
			while ((c = reader.read()) != -1) {
				buffer.add(c);
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	public int read(int pos) {
		if(pos >= buffer.size() ) {
			pos = -1;
		}
		
		if(pos != -1) {			
			return buffer.get(pos++);			
		}
		
		return -1;
	}
	
	public void write(int c) throws IOException{
		buffer.add(c);
	}
		
	public void flush() throws IOException {
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(fileName);
			char[] out = new char[buffer.size()];
			
			for(int i = 0; i < buffer.size(); i++) {
				out[i] = (char)(int)buffer.get(i);
			}
			writer.write(out);
			out = null;
		}
		finally {
			if(writer != null ) {
				writer.close();
			}
		}
		
	}	
	
}
