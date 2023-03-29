package lineares;

public class FilaVetor<T> implements Fila<T> { // contribuição do Gustavo G 
	private T[] vetor;
	private int inicio;
	private final int limite;
	private int tamanho;

	public FilaVetor(int limite) {
		vetor = (T[]) new Object[limite];
		this.limite = limite;
	}

	@Override
	public void inserir(T valor) {
		if (tamanho == limite) {
			throw new RuntimeException("Fila está cheia");
		}
		int pos = (inicio + tamanho) % limite;
		vetor[pos] = valor;
		tamanho++;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Fila está vazia");
		}
		return vetor[inicio];
	}

	@Override
	public T retirar() {
		T valor = peek();
		vetor[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho = tamanho - 1;
		return valor;
	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	@Override
	public void liberar() {
		vetor = (T[]) new Object[limite];
		inicio = 0;
		tamanho = 0;
	}

	public String toString() {
		if (estaVazia()) {
			return "[]";
		}
		String retorno = "["+vetor[inicio].toString();
		for (int i = inicio + 1; i < tamanho + inicio; i++) {
			int pos = (i) % limite;
			retorno += ", " + vetor[pos].toString();
		}
		return retorno+"]";
	}

	public String toString2() { // contribuição do Eduardo Lyra
		String str = "[";
		for (int i = 0; i < this.tamanho; i++) {
			str += vetor[(inicio + i) % limite] + ", ";
		}
		return str + "]";
	}

	public FilaVetor<T> concatenar(FilaVetor<T> f2) {
		int novoTamanho = limite + f2.getLimite();
		FilaVetor<T> f3 = new FilaVetor<>(novoTamanho);
		for (int i = getInicio(); i < getTamanho() + getInicio(); i++) {
			int pos = i % getLimite();
			f3.inserir(getElemento(pos));
		}
		for (int i = f2.getInicio(); i < f2.getTamanho() + f2.getInicio(); i++) {
			int pos = i % f2.getLimite();
			f3.inserir(f2.getElemento(pos));
		}
		return f3;
	}

	public int getLimite() {
		return limite;
	}

	private int getInicio() {
		return inicio;
	}

	public int getTamanho() {
		return tamanho;
	}

	private T getElemento(int pos) {
		return vetor[pos];
	}
}