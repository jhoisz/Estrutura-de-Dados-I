package hash;

import java.awt.Color;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class HashTable {
	public static int m;
	
	private static int hash(String s) {
		return (s.hashCode() & 0x7ffffff) % m;
	}
	
	/*private static int hash(String s) {
		return ((s.hashCode() & 0x7ffffff)*11) % m;
	}*/
	
	public static void main(String [] args) {
		
		UIManager.getDefaults().put("OptionPane.background",new Color(119,221,119));
        UIManager.put ("Panel.background", new Color(119,221,119));
		
		String txt[] = StdIn.readAllStrings();
		m = Integer.parseInt(JOptionPane.showInputDialog("Digite um M: "));
		int hashs[] = new int[m];
		
		HashSet<String> palavras = new HashSet<String>();
		
		for(int i=0;i<txt.length;i++){
			palavras.add(txt[i]);
		}
		
		for(String p : palavras) {
			int i = hash(p);
			hashs[i]++;
		}
		
		int media = palavras.size() / m;
		
		new Histograma(media, hashs, m);
		
		/*
	 	//printando as palavras do arquivo
	 	 
		Iterator<String> it = palavras.iterator();
		while(it.hasNext()) {
			StdOut.println(it.next());
		}
		 */
		
	}
}
