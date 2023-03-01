package lineares;

public class ListaEstatica {
	private int[] info;
	private int tamanho;
	
	public ListaEstatica() {
		this.info = new int[10];
		this.tamanho = 0;
	}
	
	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		int[] novo = new int[info.length+10];
		
		for (int i=0; i < info.length; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}
	
	public int buscar(int valor) {
		for (int i=0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean estaVazia() {
		return (tamanho == 0);
	}
	
	public void retirar(int valor) {
		int pos = this.buscar(valor);
		if (pos != -1) {
			for (int i=pos; i < tamanho-1; i++) {
				info[i] = info[i+1];
			}
			tamanho--;
		}
	}
	
	
}
