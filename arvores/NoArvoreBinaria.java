package arvores;

public class NoArvoreBinaria<T> { // contribuição do Gustavo G
	private final T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.info = info;
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esq = esq;
		this.dir = dir;
	}

	public T getInfo() {
		return this.info;
	}
	
	public NoArvoreBinaria<T> pertence(T info) {
		if (info.equals(this.info)) {
			return this;
		}
		if (esq != null) {
			NoArvoreBinaria<T> valor = esq.pertence(info);
			if (valor != null) {
				return valor;
			}
		}
		if (dir != null) {
			return dir.pertence(info);
		}
		return null;
	}

	public String imprimePre() {
		String retorno = "<" + info.toString();
		if (esq != null) {
			retorno += esq.imprimePre();
		} else {
			retorno += "<>";
		}
		if (dir != null) {
			retorno += dir.imprimePre();
		} else {
			retorno += "<>";
		}
		return retorno + ">";
	}

	@Override
	public String toString() {
		return this.imprimePre();
	}
}
