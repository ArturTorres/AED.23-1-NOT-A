package lineares;

public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdeElementos;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProx(novo);
		}
		ultimo = novo;
		qtdeElementos++;
	}

	@Override
	public int buscar(T valor) {
		NoLista<T> p = primeiro;
		int contador = 0;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return contador;
			}
			p = p.getProx();
			contador++;
		}
		return -1;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public void retirar(T valor) { // contribuição Elaine
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;
		for (int i = 0; i < this.getTamanho(); i++) {
			if (p.getInfo().equals(valor)) {
				break; // sair do laço
			}
			anterior = p;
			p = p.getProx();
		}
		if (p != null) {
			if (p == primeiro) {
				this.primeiro = p.getProx();
			} else {
				anterior.setProx(p.getProx());
			}
			if (p == ultimo) {
				this.ultimo = anterior;
			}
			this.qtdeElementos--;
		}
	}

	@Override
	public String exibir() { // contribuição Eduardo Lyra
		String str = "[";
		NoLista<T> p = primeiro;
		while (p != null) {
			str += p.getInfo() + ", ";
			p = p.getProx();
		}
		return str + "]";
	}

	@Override
	public Lista<T> copiar() { // contribuição Guilherme Milani
		NoLista<T> atual = primeiro;
		Lista<T> lista = new ListaEncadeada<>();
		for (int i = 0; i < this.qtdeElementos; i++) {
			lista.inserir(atual.getInfo());
			atual = atual.getProx();
		}
		return lista;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.qtdeElementos;
	}

	@Override
	public T pegar(int pos) { // Contribuição Adriel
		if (pos < 0 || pos >= this.qtdeElementos) {
			throw new IndexOutOfBoundsException("Pos=" + pos);
		}
		NoLista<T> p = primeiro;
		int cont = 0;
		while (p != null) {
			if (cont == pos) {
				return p.getInfo();
			}
			cont++;
			p = p.getProx();
		}
		return null; // nunca vai chegar aqui
	}

	@Override
	public Lista<T> dividir() {  // contribuição do Gustavo G
		  int metade = getTamanho()/2;
		  ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		  NoLista<T> no = primeiro;
		  for (int i = 1; i < getTamanho(); i++) {
		    if (i < metade) {
		      no = no.getProx();
		    } else {
		      novaLista.inserir(pegar(i)); // observar a ordem de complexidade
		    }
		  }
		  no.setProx(null);
		  ultimo = no;
		  qtdeElementos = metade;
		  return novaLista;
		}

}
