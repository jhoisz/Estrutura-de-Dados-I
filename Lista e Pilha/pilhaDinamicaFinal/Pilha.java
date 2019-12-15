package pilhaDinamicaFinal;

public class Pilha<Item> {
	private Item vetor[]; 
	private int n; 
	private int cont = 1; 

	@SuppressWarnings("unchecked")
	//construtor
	public Pilha(int TAM){
		vetor = (Item[]) new Object[TAM];
		n = 0;
	}
	
	//metodo para inserir item
	public void push(Item item) {
		if(n<vetor.length) {
			vetor[n] = item; 
			n++;
		}else{ 
			cont*=2;
			resize(2*vetor.length);
			vetor[n] = item;
			n++;
		}
	}

	@SuppressWarnings("unchecked")
	//metodo para redimensionar
	private void resize(int max) { 
		Item[] aux = (Item[]) new Object[max];
		for(int i=0; i<n; i++) { 	
			aux[i] = vetor[i];
		}
		vetor = aux;
	}
	
	//metodo para retirar item
	public Object pop() { 
		Object item = vetor[n-1];
		n--; 
		if(n<=(vetor.length/4)) {
			resize(vetor.length/2);
			cont/=2;
		}
		
		return item;
	}
	
	//verifica se a pilha esta vazia
	public boolean isEmpty() {
		return (n==0);
	}
	
	//devolve o tamanho da pilha ate o momento
	public int size() {
		return n;
	}
	
	//calcula a porcentagem
	public float porcentagem(int max) {
		float porcento = (n*100)/(max*cont);
		
		return porcento;
	}
	
	//metodo para exibir itens da pilha
	public String toString(){
		String str = "";
		
		for(int i=n-1;i>=0;i--) {
			str+=(vetor[i]+"\n");
		}
		return str;
	}
}