package lineares;

public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdeElementos;

	@Override
	public void inserir(int valor) {
		NoLista novo = new NoLista();
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
	public int buscar(int valor) {
		NoLista p = primeiro;
		int contador = 0;
		while (p != null) {
			if (p.getInfo() == valor) {
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
	public void retirar(int valor) { // contribuição Elaine
		NoLista anterior = null;
		NoLista p = primeiro;
		for (int i = 0; i < this.getTamanho(); i++) {
			if (p.getInfo() == valor) {
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
		NoLista p = primeiro;
		while (p != null) {
			str += p.getInfo() + ", ";
			p = p.getProx();
		}
		return str + "]";
	}

	@Override
	public Lista copiar() { // contribuição Guilherme Milani
		NoLista atual = primeiro;
		Lista lista = new ListaEncadeada();
		for (int i = 0; i < this.qtdeElementos; i++) {
			lista.inserir(atual.getInfo());
			atual = atual.getProx();
		}
		return lista;
	}

	@Override
	public void concatenar(Lista outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.qtdeElementos;
	}

	@Override
	public int pegar(int pos) { // Contribuição Adriel
		if (pos < 0 || pos >= this.qtdeElementos) {
			throw new IndexOutOfBoundsException("Pos=" + pos);
		}
		NoLista p = primeiro;
		int cont = 0;
		while (p != null) {
			if (cont == pos) {
				return p.getInfo();
			}
			cont++;
			p = p.getProx();
		}
		return -1; // nunca vai chegar aqui
	}

	@Override
	public Lista dividir() {  // contribuição do Gustavo G
		  int metade = getTamanho()/2;
		  ListaEncadeada novaLista = new ListaEncadeada();
		  NoLista no = primeiro;
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
