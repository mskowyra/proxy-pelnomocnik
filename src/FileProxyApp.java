import java.io.*;
/*
 * 
 * Maciej Skowyra
 * 
 */

public class FileProxyApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			int c = -1;						
			//tworzy dwa obiekty typu reader za pomoca klasy FileReaderProxy
			Reader fr = new FileReaderProxy("test.txt");
			Reader anotherFile = new FileReaderProxy("test_2.txt");
			
			System.out.println("test.txt contents:");
			//pêtla która wyœwietla ca³y plik który znajduje siê w zmiennej fe, kiedy dojdzie do -1 petla jest przerywana
			while( (c = fr.read()) != -1 ) {
				System.out.print((char)c);
			}
			System.out.println();
			
			System.out.println("test_2.txt contents:");
			while( (c = anotherFile.read()) != -1 ) {
				System.out.print((char)c);
			}
			System.out.println();
			
			
			Writer fw = new FileWriterProxy("test.txt");
			Writer anotherFw = new FileWriterProxy("test_2.txt");
			//fw to obiekt, write to jego metoda która zapisuje na koniec pliku znak podany w nawiasach
			fw.write(' ');
			fw.write('f');
			fw.write('r');
			fw.write('o');
			fw.write('m');
			fw.write(' ');
			fw.write('f');
			fw.write('i');
			fw.write('l');
			fw.write('e');
			//inny obiekt ktory tez zapisuje
			anotherFw.write('n');

			// Dane nie sa wczytywane z dysku mimo utworzenia nowego obiektu reader'a
			Reader fr2 = new FileReaderProxy("test.txt");
			
			System.out.println("test.txt contents after adding some data:");
			while( (c = fr2.read()) != -1 ) {
				System.out.print((char)c);
			}
			System.out.println();
			
			Reader fr3 = new FileReaderProxy("test_2.txt");
			
			System.out.println("test_2.txt contents after adding some data:");
			while( (c = fr3.read()) != -1 ) {
				System.out.print((char)c);
			}
			System.out.println();
			
					
			System.out.println("Check file(s) test.txt, test_2.txt added data are not saved to disk yet. Press return to continue");
			
			
			//zapisuje na dysk plik ktore sa przechowywane w wewnetrznym buforze za pomoca metody flush
			
			fw.flush();			
			anotherFw.flush();

			System.out.println("File buffer saved to disk");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
