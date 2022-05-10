package P3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Mochila_Archivo {
	static int w; // Capacidad de la mochila
	static int n; // Numero de elementos
	static ArrayList<Item> items = new ArrayList<Item>() ; //Array de los objetos
	static int[] val; // Array de valores
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
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			wt[cont] = Integer.parseInt(line);
			cont++;
		}
		
	}
	
	
public static void main(String[] args) {
	setCapacidad(capacity);
	setPesos(weights);
	System.out.println(w);
	System.out.println(wt.length);
}	
	
}
	

