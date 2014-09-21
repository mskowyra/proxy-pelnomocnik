import java.io.IOException;
import java.io.Writer;
/*
 * 
 * Maciej Skowyra
 * 
 */

//przedmiot
public class FileWriterProxy extends Writer {

	private String fileName;
	
	public FileWriterProxy(String fileName) throws IOException {
		this.fileName = fileName;
		
		IOManager.getInstance().get(fileName);
	}
	
	@Override
	public void close() throws IOException {	
		
	}

	@Override
	public void flush() throws IOException {
		IOManager.getInstance().get(fileName).flush();
	}

	@Override
	public void write(int c) throws IOException {
		IOManager.getInstance().get(fileName).write(c);
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		
		throw new UnsupportedOperationException();
	}
}
