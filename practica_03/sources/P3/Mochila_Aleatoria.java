package P3;

import java.util.ArrayList;

public class Mochila_Aleatoria {
private static final int[] ArrayList = null;
static int w = 5; // Capacidad de la mochila
static int n = 4; // Numero de elementos
static ArrayList<Item> items = new ArrayList<Item>() ; //Array de los objetos


public static void generarItems() {
	for(int i = 0; i < n; i++) { // Genera como mucho 5 objetos
		 items.add(new Item((int)(Math.random()*5),(int)(Math.random()*5)));
	}
}

public static void cargarValoresyPesos() {
	generarItems();
	ArrayList<Integer> val = new ArrayList<Integer>(); // Array de valores
	ArrayList<Integer> wt = new ArrayList<Integer>(); // Array de pesos
	for (int i = 0; i < items.size(); i++) {
		wt.add(i, items.get(i).peso);
		val.add(i, items.get(i).valor);
	}
}
public int mochila (int w, int n, int[] val, int[] wt) {
	if(n == 0 || w == 0) {
		return 0;
	}
	if(wt[n-1] > w)
		return mochila(w, n-1, val, wt);
	else
		return Math.max(val[n-1] + mochila(w-wt[n-1], n-1, val, wt), mochila(w, n-1, val, wt)); 
	}

public static void main(String[] args) {
	//generarItems(items);
	cargarValoresyPesos();
	}
}
