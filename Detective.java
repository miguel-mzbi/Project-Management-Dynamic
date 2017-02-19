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
		arraySize = Integer.parseInt(line);
		arrayClan = new int[arraySize];
		line = br.readLine(); //aqui estan los elementos del clan
		String[] splitLine = line.split(" ");
		for(int i = 0; i < splitLine.length; i++){
			arrayClan[i] = Integer.parseInt(splitLine[i]);
		}

		br.close();
		return arrayClan;
	}
	public static int[] getPotentialKillers(int[] clan){
		int[] reportTo = new int[clan.length]; //aqui guardare cuanta gente le reporta, la gente que tenga 0 sera regresada como respuesta
		for(int i = 0; i < clan.length; i++){
			if(clan[i] > 0){
				reportTo[clan[i]-1]++;
			}
		}
		int sizeOfResult = 0;
		for(int i = 0; i < reportTo.length; i++){
			if(reportTo[i] == 0){
				sizeOfResult++;
			}
		}
		int[] result = new int[sizeOfResult];
		int j = 0;
		for(int i = 0; i < reportTo.length;i++){
			if(reportTo[i] == 0){
				result[j++] = i+1;
			}
		}
		
		return result;
	}
	public static void printResult(int[] potentialKillers){
		System.out.print("The potential killers are: ");
		for(int i = 0; i < potentialKillers.length; i++){
			System.out.print(potentialKillers[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Debe de llamar el archivo a probar como parametro al ejecutar el programa");
		}else{
			File in = new File(args[0]);
			try{
				int[] clan = readFromFileInput(in);
				int[] potentialKillers = getPotentialKillers(clan);
				printResult(potentialKillers);
			}catch(IOException err){
				System.out.println(err.toString());
			}
			
		}
	}
}