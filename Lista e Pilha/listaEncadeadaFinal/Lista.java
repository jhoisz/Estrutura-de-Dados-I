package listaEncadeadaFinal;

public class Lista<Item>{
	private Node<Item> inicio;
	private int quant;
	
	@SuppressWarnings("hiding")
	public class Node<Item>{
		protected Item elem;
		protected Node<Item> prox;
		
		public Node(Item el) {
			elem = el;
			prox = null;		
		}
	}
	
	public Lista() {
		inicio = null;
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
			quant++;
			return true;
		}
		
		while(aux.prox != null){
			aux = aux.prox;
		}
		
		Node<Item> a = new Node<Item>(el);
		aux.prox = a;
		quant++;
		return true;
		}

	/*
	 void inserir(Item el) {
		
		Node<Item> aux = inicio;
		
		if(isEmpty()) {
			Node<Item> a = new Node<Item>();
			a.elem = el;
			a.prox = null;
			inicio = a;
			quant++;
			//return true;
		} else {
		
		while(aux.prox != null){
			aux = aux.prox;
		}
		
		Node<Item> a = new Node<Item>();
		a.elem = el;
		a.prox = null;
		aux.prox = a;
		quant++;
		//return true;
		}
	 }*/
	
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
		quant--;
		return true;
	}
	boolean remover(Item el) {
		Node<Item> aux = inicio;
		
		if(inicio.elem.equals(el)) {
			inicio = inicio.prox;
			quant--;
			return true;
		}
		
		while(!aux.prox.elem.equals(el)) {
			aux = aux.prox;
		}
		
		aux.prox = aux.prox.prox;
		quant--;
		return true;
	}
}