package lineares;

public class TesteFilas {
	public static void main(String[] args) { 

		int limite = 5;

		Fila<Integer> fila = new FilaVetor<Integer>(limite);

		System.out.println(fila.toString() + " - Limite: " + limite);
		System.out.println("Inserir 3 5 e 7");
		fila.inserir(3);
		fila.inserir(5);
		fila.inserir(7);
		System.out.println(fila.toString());
		System.out.println("Retirar 2 vezes");
		System.out.println("Retirado: " + fila.retirar());
		System.out.println("Retirado: " + fila.retirar());
		System.out.println(fila.toString());
		System.out.println("Inserir 4, 6, 8, e 2");
		fila.inserir(4);
		fila.inserir(6);
		fila.inserir(8);
		fila.inserir(2);
		System.out.println(fila.toString());
		System.out.println("Retirar 2 vezes");
		System.out.println("Retirado: " + fila.retirar());
		System.out.println("Retirado: " + fila.retirar());
		System.out.println(fila.toString());
		System.out.println("Inserir 1 e 6");
		fila.inserir(1);
		fila.inserir(6);
		System.out.println(fila.toString());

		FilaVetor<Integer> outraFila = new FilaVetor<>(limite);
		outraFila.inserir(10);
		outraFila.inserir(20);
		outraFila.inserir(30);
		outraFila.inserir(40);
		System.out.println(outraFila.toString());
		FilaVetor<Integer> resultante = ((FilaVetor)fila).concatenar(outraFila);
		System.out.println(resultante.toString());
		System.out.println("Liberar");
		fila.liberar();
		System.out.println(fila.toString());

		
		System.out.println("\n Fila Dinamica-----");
		fila = new FilaLista<Integer>();

		System.out.println(fila.toString());
		System.out.println("Inserir 3 5 e 7");
		fila.inserir(3);
		fila.inserir(5);
		fila.inserir(7);
		System.out.println("Retirar 2 vezes");
		System.out.println("Retirado: " + fila.retirar());
		System.out.println("Retirado: " + fila.retirar());
		System.out.println(fila.toString());
		System.out.println("Inserir 4, 6, 8, e 2");
		fila.inserir(4);
		fila.inserir(6);
		fila.inserir(8);
		fila.inserir(2);
		System.out.println(fila.toString());
		System.out.println("Retirar 2 vezes");
		System.out.println("Retirado: " + fila.retirar());
		System.out.println("Retirado: " + fila.retirar());
		System.out.println(fila.toString());
		System.out.println("Inserir 1 e 6");
		fila.inserir(1);
		fila.inserir(6);
		System.out.println(fila.toString());

		System.out.println("Liberar");
		fila.liberar();
		System.out.println(fila.toString());

		
	}
}