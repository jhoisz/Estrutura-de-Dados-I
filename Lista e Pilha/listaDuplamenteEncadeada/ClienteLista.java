package listaDuplamenteEncadeada;

import javax.swing.JOptionPane;

public class ClienteLista {

	public static void main(String[] args) {
		Lista<String> lista = new Lista<String>();
	
		while(true) {
			String item;
			int opcao = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha uma das opcoes:" +
					"\n1 - Solicitar impressao\n2 - Atender pedido\n3 - Cancelar pedido nao atendido\n4 - Listar pedidos\n0 - Sair"));
			switch (opcao) {
			case 1: 
				item = JOptionPane.showInputDialog("Item a ser inserido");
				lista.inserir(item);
				break;
			case 2: 
				lista.remover();
				break;
			case 3:
				item = JOptionPane.showInputDialog("Item a ser excluido");
				lista.remover(item);
				break;
			case 4: 
				JOptionPane.showMessageDialog(null, lista);
				break;
			default: return;
			}
		}

	}
}