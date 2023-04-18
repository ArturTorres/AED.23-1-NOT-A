package arvores;

public class ArvoreBinaria<T> { // contribuição do Gustavo G
	private NoArvoreBinaria<T> raiz;

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public boolean vazia() {
		return raiz == null; 
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}
}
