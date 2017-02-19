import.lang.Object;
import.lang.Throwable;
import.lang.Exception;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Detective{
	public static int[] readFromFileInput(File in) throws IOException{
		FileInputStream fis = new FileInputStream(in);
		int arraySize;
		int[] arrayClan;

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = br.readLine(); //aqui debe estar en la primera linea N. El numero de elementos que vendran en la siguiente linea
		int arraySize = Integer.parseToInt(line);

		br.close;

		return null;
	}
	public static int[] getPotentialKillers(int[] clan){

	}

	public static void main(String[] main){

	}
}