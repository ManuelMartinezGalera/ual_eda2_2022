package P3;

public class Item {
	int valor;
	int peso;
	public Item (int valor, int peso) {
		this.valor = valor;
		this.peso = peso;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String toString() {
		return "Objeto[v = " + valor + "][w = " + peso + "]" ;
		
	}
}
