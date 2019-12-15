package buscaSB;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;

public class SequentialSearchST<Key, Value> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    	
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }


    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }


    public Iterable<Key> keys()  {
        Queue<Key> queue = new LinkedList<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.add(x.key);
        return queue;
    }

    public static void main(String[] args) { 
       
    	SequentialSearchST<Integer, Integer> st = new SequentialSearchST<Integer, Integer>();
    	
    	int N, buscasCorretas=0, buscasErradas=0;
    	
    	N = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade N de chaves desejada"));
    	
    	insereSequentialST(st, N);
    	
    	//busca bem sucedida 10x cada chave
    	for(Integer it: st.keys()) {
    		for(int i=0; i<10; i++) {
    			if(st.contains(it)) {
        			buscasCorretas++;    			
        		}
    		}
    		
    	}
    	
    	//busca mal sucedida 10x cada chave
    	for(@SuppressWarnings("unused") Integer it: st.keys()) {
    		for(int i=0; i<10; i++) {
    			if(!st.contains(N+1)) {
        			buscasErradas++;
        		}
    		}
    		
    	}    	
    	System.out.println("Buscas corretas: " +buscasCorretas);
    	System.out.println("Buscas erradas: " +buscasErradas);

    }
    public static void insereSequentialST (SequentialSearchST<Integer, Integer> st, int N) {
    	Random gerador = new Random();
    	for(int i=0; i<N; i++) {
    		int x;
    		do {
    			x = gerador.nextInt(100);
    		}while(st.contains(x));
    		st.put(x, i);
    	}
    	
    	for (Integer it : st.keys()) {
			System.out.println(it);
		}
    }
}