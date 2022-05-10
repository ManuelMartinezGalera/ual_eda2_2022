package P3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Mochila_Archivo {
	static int w; // Capacidad de la mochila
	static int n; // Numero de elementos
	static ArrayList<Item> items = new ArrayList<Item>() ; //Array de los objetos
	static int[] val;  // Array de valores
	static int[] wt; // Array de pesos
	static String capacity = System.getProperty("user.dir")+File.separator+"sources"+File.separator+"P3"+File.separator+"p03_c.txt";
	static String weights = System.getProperty("user.dir")+File.separator+"sources"+File.separator+"P3"+File.separator+"p03_w.txt";
	static String profits = System.getProperty("user.dir")+File.separator+"sources"+File.separator+"P3"+File.separator+"p03_p.txt";

	public static void setCapacidad(String file) {
			Scanner scan = null;
			try {
				scan = new Scanner(new File(file));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.exit(-1);
				
			}
			w = Integer.parseInt(scan.nextLine());
	}	
	public static void setNumElementos(String file) {
		Scanner scan = null;
		String line = null;
		int cont = 0;
		try {
			scan = new Scanner(new File(file));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.exit(-1);
			
		}
		while(scan.hasNextLine() || line.isEmpty()) {
			cont++;
			line = scan.nextLine();
			
		}
		n = cont;
	}
	
	public static void setPesos(String file) {
		Scanner scan = null;
		String line = null;
		int cont = 0;
		try {
			scan = new Scanner(new File(file));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.exit(-1);
			
		}
		setNumElementos(weights);
		wt = new int[n];
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			wt[cont] = Integer.parseInt(line);
			cont++;
		}
		
	}
	
	public static void setProfits(String file) {
		Scanner scan = null;
		String line = null;
		int cont = 0;
		try {
			scan = new Scanner(new File(file));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.exit(-1);
			
		}
		setNumElementos(profits);
		val = new int[n];
		while(scan.hasNextLine()) {
			line = scan.nextLine().trim();
			val[cont] = Integer.parseInt(line);
			cont++;
		}
		
	}
	
	public static int mochila (int w, int n, int[] val, int[] wt) {
		if(n == 0 || w == 0) {
			return 0;
		}
		if(wt[n-1] > w)
			return mochila(w, n-1, val, wt);
		else
			return Math.max(val[n-1] + mochila(w-wt[n-1], n-1, val, wt), mochila(w, n-1, val, wt)); 
		}
	
public static void main(String[] args) {
	setCapacidad(capacity);
	setPesos(weights);
	setProfits(profits);
	System.out.println("La capacidad de la mochila es : " + w);
	System.out.println("El numero de elementos es : " + wt.length);
	for (int i = 0; i < wt.length; i++) {
		System.out.print("Peso" + (i+1) + " : " + wt[i] + "\t");
		System.out.print("Valor" + (i+1) + " : " + val[i] + "\t");
		System.out.println();
		}
	System.out.println("El profit optimo para la mochila es : "+mochila(w, n, val, wt));
	
	}	
	
}
	

