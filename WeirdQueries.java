import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WeirdQueries{
	private static int[] numberArray;
	private static int[][] queries;
	private static int[][] matrixDifference;

	public static void readFromFileInput(File in) throws IOException{
		FileInputStream fis = new FileInputStream(in);
		int arraySize;
		int numberOfQueries;
		

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		//leer el tamaño del arreglo y el numero de queries
		String line = br.readLine(); //aqui debe estar en la primera linea N. El numero de elementos que vendran en la siguiente linea
		String[] lineArr = line.split(" ");
		arraySize = Integer.parseInt(lineArr[0]);
		numberOfQueries = Integer.parseInt(lineArr[1]);
		//hacer el arreglo de numeros
		line = br.readLine();
		lineArr = line.split(" ");
		numberArray = new int[arraySize];
		for(int i = 0; i < numberArray.length;i++){
			numberArray[i] = Integer.parseInt(lineArr[i]);
		}
		queries = new int[numberOfQueries][4];
		for(int i = 0; i < numberOfQueries; i++){
			line = br.readLine();
			lineArr = line.split(" ");
			for(int j = 0; j < 4; j++){
				queries[i][j] = Integer.parseInt(lineArr[j]);
			}
		}
		br.close();
	}

	private static int getMaxFromArray(int[] array){
		int max = 0;
		for(int i = 0; i < array.length; i++){
			if(max < array[i]){
				max = array[i];
			}
		}
		return max;
	}
	public static void doMatrixDifference(){
		int max = getMaxFromArray(numberArray);
		matrixDifference = new int[max][max];
		for(int i = 0; i < matrixDifference.length; i++){
			for(int j = 0; j < matrixDifference[i].length; j++){
				matrixDifference[i][j] = Math.abs((i+1) - (j+1));
				
			}
		}
	}

	public static void getResults(){
		int l, r, n, k, d;
		int[] B;
		int[][] S;
		
		doMatrixDifference();

		for(int i = 0; i < queries.length; i++){
			l = queries[i][0];
			r = queries[i][1];
			n = queries[i][2];;
			k = queries[i][3];
			d = r - l + 1;

			B = new int[d];
			for(int j = 0; j < d; j++){
				B[j] = numberArray[l + j];
			}
			int maxB = getMaxFromArray(B);
			S = new int[d][maxB];
			for(int j = 0; j < d; j++){
				for(int k2 = 0; k2 < maxB; k2++){
					if((k2+1) > B[j]){
						S[j][k2] = 0;
					}else{
						S[j][k2] = k2+1;
					}
				}
			}
			//La parte dificil
			//hacer subsets
			ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
			if(n==1){
				for(int j = 0; j < S.length; j++){
					for(int k2 = 0; k2 < S[j].length; k2++){
						if(S[j][k2] == 0){
							break;
						}
						ArrayList<Integer> arr =  new ArrayList<Integer>();
						arr.add(S[j][k2]);
						subsets.add(arr);
					}
				}

			}else if(n == 2){
				for(int i1 = 0; i1 < S.length; i1++){
					for(int i2 = 0; i2 < S[i1].length; i2++){
						if(S[i1][i2] == 0){
							break;
						}
						for(int i3 = i1; i3 < S.length; i3++){
							for(int i4 = 0;i4 < S[i3].length; i4++){
								if(i4 == 0 && i3 == i1){
									i4 = i2;
									continue;
								}
								if(S[i3][i4] == 0){
									
									continue;
								}
								ArrayList<Integer> arr = new ArrayList<Integer>();
								arr.add(S[i1][i2]);
								arr.add(S[i3][i4]);
								subsets.add(arr);
								
							}
						}
						
					}
				}
			}else{
				System.out.println("No sea tan malo compañerito");
			}
			
			int numSets = 0;
			int diferencia;
			if(n == 1){
				System.out.println(subsets.size());
			}else if(n == 2){
				for(int j = 0; j < subsets.size(); j++){
					diferencia = Math.abs(subsets.get(j).get(0) - subsets.get(j).get(1));
					if(diferencia >= k){
						numSets++;
					}
				}
				System.out.println(numSets);
			}else{
				System.out.println("Calmela, tomese una aspirina y respire");
			}
		}
	}

	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Debe de llamar el archivo a probar como parametro al ejecutar el programa");
		}else{
			File in = new File(args[0]);
			try{
				readFromFileInput(in);
				getResults();
			}catch(IOException err){
				System.out.println(err.toString());
			}
			
		}
	}
}