package listaDuplamenteEncadeada;

public class Lista<Item>{
	public Node<Item> inicio;
	public Node<Item> fim;
	private int quant;
	
	@SuppressWarnings("hiding")
	public class Node<Item>{
		public Item elem;
		protected Node<Item> prox;
		protected Node<Item> ant;

		public Node(Item el) {
			elem = el;
			prox = null;
			ant = null;
		}
		public Item getElem() {
			return elem;
		}
	}
	

	public Lista() {
		inicio = null;
		fim = null;
		quant = 0;
	}
	
	boolean isEmpty() {
		return quant == 0;
	}
	
	int size() {
		return quant;
	}
	
	boolean inserir(Item el) {
		Node<Item> aux = inicio;
		
		if(isEmpty()) {
			Node<Item> a = new Node<Item>(el);
			inicio = a;
			fim = a;
			quant++;
			return true;
		}
		
		while(aux != fim){
			aux = aux.prox;
		}
		
		Node<Item> a = new Node<Item>(el);
		
		aux.prox = a;
		a.ant = fim;
		fim = a;
		quant++;
		return true;
		}
	
	public String toString() {
		String str = "";
		
		Node<Item> aux = inicio;
		
		while(aux!=null) {
			str += (aux.elem + "\n");
			aux = aux.prox;
		}
		return str;
	}
	boolean remover() {
		inicio = inicio.prox;
		inicio.ant = null;
		quant--;
		return true;
	}
	boolean remover(Item el) {
		Node<Item> aux = inicio;
		
		if(inicio.elem.equals(el)) {
			inicio = inicio.prox;
			inicio.ant = null;
			quant--;
			return true;
		}
		if(fim.elem.equals(el)) {
			fim = fim.ant;
			fim.prox = null;
			quant--;
			return true;
		}		
		while(!aux.prox.equals(el)) {
			aux = aux.prox;
		}
		
		aux.prox = aux.prox.prox;
		aux.prox.ant = aux;
	
		quant--;
		return true;
	}
}