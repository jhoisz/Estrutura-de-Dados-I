package ListaCircular;

/* falta: 
metodos:	remover
			contem
			toString
add classe cliente.	
*/

public class ListaCircular<Item>{
	private Node<Item> inicio;
	private Node<Item> fim;
	private int n;
	
	private class Node<Item>{
		private Item elem;
		private Node<Item> prox;
	}
	public ListaCircular() {
		inicio = null;
		fim = null;
		n=0;
	}
	boolean isEmpty() {
		return inicio == null;
	}
	void inserir(Item el) {
		Node<Item> novo = new Node <Item>();
		novo.prox = novo;
		novo.elem = el;
		if(isEmpty()) {
			inicio = novo;
			fim = novo;
		}else {
			fim.prox = novo;
			fim = novo;
			novo.prox = inicio;
		}
	}
}
