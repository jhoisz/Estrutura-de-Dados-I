package bst;

public class ArvoreBinaria<Key extends Comparable<Key>, Value> {
	private Node root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if (x==null) return 0;
		return 1 + size(x.left) + size(x.right);
	}
	
	public Value get(Key chave) {
		return get(root, chave);
	}

	private Value get(Node x, Key chave) {
		if (x == null)
			return null;
		int cmp = chave.compareTo((Key)x.chave);
		if (cmp < 0)
			return get(x.left, chave);
		else if (cmp > 0)
			return get(x.right, chave);
		else
			return (Value) x.val;
	}
	
	public void put(Key chave, Value valor) {
		root = put(root, chave, valor);
	}

	private Node put(Node x, Key chave, Value valor) {
		if (x == null) { //arvore vazia
			Node aux = new Node(chave, valor);
		//	quant++;
			return aux;
		}
		int cmp = chave.compareTo((Key)x.chave);
		if (cmp < 0) {
			x.left = put(x.left, chave, valor);
		//	quant++;
		}
		else if (cmp > 0) {
			x.right = put(x.right, chave, valor);
		//	quant++;
		}else {
			x.val = valor;
		}
		return x;
	}	
	
	//retorna a altura da arvore
	//A altura (height) de uma BT é o máximo das profundidades dos nós, 
	//ou seja, a profundidade do nó mais profundo.
	public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
    //depth
    public void setDepthField() {
		setDepthField(root, 0);
	}
	
	public void setDepthField(Node x, int depth) {
		if(x==null) return;
		
		x.depth = depth;
		setDepthField(x.left, depth+1);
		setDepthField(x.right, depth+1);
	}
    
    
    //é a soma das profundidades dos seus nós, ou seja, 
    //a soma dos comprimentos de todos os caminhos que levam da raiz até um nó.
    public int internalPathLength() {    	
    	return internalPathLength(root);
    }
    
	private int internalPathLength(Node x) {
		if(x!=null) {
			return x.depth+internalPathLength(x.left)+internalPathLength(x.right);
		}
		return 0;
	}

	public String toString(int i) {
		return mostrar(root, i);
	}
	
	private String mostrar(Node x, int i) {
		if (x==null) return "";
		if(i==1) //retorna pre-ordem: raiz-esquerda-direita
			return (x.chave+" ") + mostrar(x.left, i) + mostrar(x.right, i);
		if(i==2) //retorna in-ordem: esquerda-raiz-direira
			return  mostrar(x.left, i) + (x.chave+" ") + mostrar(x.right, i);
		if(i==3) //retorna pos-ordem: esquerda-direita-raiz
			return  mostrar(x.left, i)  + mostrar(x.right, i) + (x.chave+" ");
		
		return null;
	}
}