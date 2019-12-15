package pilhaDinamicaFinal;

import javax.swing.JOptionPane;

public class ClientePilha {
	
	private static Pilha<String> pilha;
	private static int MAX = 2;
	
	public static void main(String[] args) {
		pilha = new Pilha<String>(MAX);
		int op;
			do {
			op = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n1 - Empilhar\n2 - Desempilhar\n3 - Listar\n4 - Verificar tamanho\n0 - Sair"));
			
				switch(op) {
					case 1: empilhar(); break;
					case 2: desempilhar(); break;
					case 3: listar(); break;
					case 4 : verificarTamanho(); break;
					case 0: break;
					default: JOptionPane.showMessageDialog(null, "Opcao Invalida!"); break;
				}
			}while(op!=0);
	}
	private static void verificarTamanho() {
		float p = pilha.porcentagem(MAX);
		JOptionPane.showMessageDialog(null, "Porcentagem: " + p + "%");
	}
	
	private static void empilhar() {
		String item = JOptionPane.showInputDialog("Item a ser inserido: ");
		pilha.push(item);
	}
	
	private static void desempilhar() {
		if(pilha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pilha vazia");
		} else {
			String item =  (String) pilha.pop();
			JOptionPane.showMessageDialog(null, "Item "+ item+" foi removido");
		}
	}
	private static void listar() {
		JOptionPane.showMessageDialog(null, pilha);

	}
}