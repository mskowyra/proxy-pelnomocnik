import java.io.*;
/*
 * 
 * Maciej Skowyra
 * 
 */

//przedmiot
//ta klasa uzywa klasy IOManager, zarzadza dostepem do plikow jak sa w pamieci to dziala a jak nie to doczytuje je do pamieci
public class FileReaderProxy extends Reader {

	private String fileName;
	private int pos;
	
	public FileReaderProxy(String fileName) throws IOException{
		this.fileName = fileName;
		
		// Zbuforowanie pliku jesli wczytywany od nowa
		IOManager.getInstance().get(fileName);
		pos = 0;
	}
	
	public int read() throws IOException {
		return IOManager.getInstance().get(fileName).read(pos++);
	}
	
	@Override
	public void close() throws IOException {
		pos = -1;
	}

	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		
		return 0;
	}
}
