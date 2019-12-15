package bst;

public class Node<Key, Value> {
	protected Key chave;
	protected Value val;
	protected int depth;
	
	@SuppressWarnings("rawtypes")
	protected Node left, right;
	
	public Node(Key chave) {
		this.chave = chave;
	}
	
	public Node(Key chave, Value val) {
		this.chave = chave;
		this.val = val;
	}

	//novo construtor
	public Node(Key chave, Value val, int depth) {
		this.chave = chave;
		this.val = val;
		this.depth = depth;
	}
}