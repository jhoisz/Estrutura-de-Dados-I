package javaCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Collections {
	private static ArrayList<String> txt = new ArrayList<String>();
	private static ArrayList<Double> tempoInserir = new ArrayList<Double>();
	private static ArrayList<Double> tempoBuscar = new ArrayList<Double>();
	private static ArrayList<Double> tempoExcluir = new ArrayList<Double>();
	private static List<String> palavras = new ArrayList<String>();

	public Collections(ArrayList<String> texto) {
		txt = texto;
		main(null, txt);
	}

	public static void main(String[] args, ArrayList<String> texto) {
		txt = texto;
		List<String> palavras = new ArrayList<String>();
		palavras.add("Lisbon");
		palavras.add("NASA");
		palavras.add("Kyunghee");
		palavras.add("Konkuk");
		palavras.add("Sogang");
		palavras.add("momentarily");
		palavras.add("rubella");
		palavras.add("vaccinations");
		palavras.add("government");
		palavras.add("Authorities");

		vetor();
		linkedList();
		arrayList();
		hashSet();
		linkedHashSet();
		treeSet();
		hashMap();
		linkedHashMap();
		treeMap();

		do {
			String[] choices = { "Insercao", "Busca", "Exclusao" };

			String in = (String) JOptionPane.showInputDialog(null, "Selecione o tempo de desempenho", "Collections",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
			switch (in) {
			case "Insercao":
				new Desempenho(1, tempoInserir);
				break;
			case "Busca":
				new Desempenho(2, tempoBuscar);
				break;
			case "Exclusao":
				new Desempenho(3, tempoExcluir);
				break;
			default:
				break;
			}
		} while (true);
	}

	private static void vetor() {
		int i;
		Vector<String> vetor = new Vector<String>();
		// vetor
		Stopwatch tempo = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			vetor.add(txt.get(i));
		}
		tempoInserir.add(tempo.elapsedTime());
		// System.out.println("vetor: " + tempo1.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : vetor) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : vetor) {
			if (palavras.contains(a)) {
				vetor.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void linkedList() {
		LinkedList<String> linkedlist = new LinkedList<String>();
		int i;

		// LinkedList
		Stopwatch tempo2 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			linkedlist.add(txt.get(i));
		}
		tempoInserir.add(tempo2.elapsedTime());
		// System.out.println("LinkedList: " + tempo3.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : linkedlist) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : linkedlist) {
			if (palavras.contains(a)) {
				linkedlist.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void arrayList() {
		ArrayList<String> arraylist = new ArrayList<String>();
		int i;

		// arrayList
		Stopwatch tempo3 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			arraylist.add(txt.get(i));
		}
		tempoInserir.add(tempo3.elapsedTime());
		// System.out.println("ArrayList: " + tempo2.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : arraylist) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : arraylist) {
			if (palavras.contains(a)) {
				arraylist.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void hashSet() {
		HashSet<String> hashset = new HashSet<String>();
		int i;

		// HashSet
		Stopwatch tempo4 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			hashset.add(txt.get(i));
		}
		tempoInserir.add(tempo4.elapsedTime());
		// System.out.println("HashSet: " + tempo4.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : hashset) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : hashset) {
			if (palavras.contains(a)) {
				hashset.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void linkedHashSet() {
		LinkedHashSet<String> linkedhashset = new LinkedHashSet<String>();
		int i;
		// LinkedHashSet
		Stopwatch tempo5 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			linkedhashset.add(txt.get(i));
		}
		tempoInserir.add(tempo5.elapsedTime());
		// System.out.println("LinkedHashSet: " + tempo5.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : linkedhashset) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : linkedhashset) {
			if (palavras.contains(a)) {
				linkedhashset.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void treeSet() {
		TreeSet<String> treeset = new TreeSet<String>();
		int i;

		// HashMap
		Stopwatch tempo = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			treeset.add(txt.get(i));
		}
		tempoInserir.add(tempo.elapsedTime());
		// System.out.println("treeSet: " + tempo6.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : treeset) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : treeset) {
			if (palavras.contains(a)) {
				treeset.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void hashMap() {
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		int i;

		// HashMap
		Stopwatch tempo6 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			hashmap.put(txt.get(i), null);
		}
		tempoInserir.add(tempo6.elapsedTime());
		// System.out.println("HashMap: " + tempo6.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : hashmap.keySet()) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : hashmap.keySet()) {
			if (palavras.contains(a)) {
				hashmap.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}

	private static void linkedHashMap() {
		LinkedHashMap<String, Integer> linkedhashmap = new LinkedHashMap<String, Integer>();
		int i;

		// LinkedHashMap
		Stopwatch tempo7 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			linkedhashmap.put(txt.get(i), null);
		}
		tempoInserir.add(tempo7.elapsedTime());
		// System.out.println("LinkedHashMap: " + tempo7.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : linkedhashmap.keySet()) {
			palavras.contains(a);
		}
		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : linkedhashmap.keySet()) {
			if (palavras.contains(a)) {
				linkedhashmap.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());

	}

	private static void treeMap() {
		TreeMap<String, Integer> treemap = new TreeMap<String, Integer>();
		int i;

		// TreeMap
		Stopwatch tempo8 = new Stopwatch();
		for (i = 0; i < txt.size(); i++) {
			treemap.put(txt.get(i), null);
		}
		tempoInserir.add(tempo8.elapsedTime());
		// System.out.println("TreeMap: " + tempo8.elapsedTime());

		Stopwatch tempoB = new Stopwatch();
		for (String a : treemap.keySet()) {
			palavras.contains(a);
		}

		tempoBuscar.add(tempoB.elapsedTime());

		Stopwatch tempoE = new Stopwatch();
		for (String a : treemap.keySet()) {
			if (palavras.contains(a)) {
				treemap.remove(a);
			}
		}
		tempoExcluir.add(tempoE.elapsedTime());
	}
}
