package bst;

import java.util.Random;

import javax.swing.JOptionPane;

public class ArvoreBinariaApp {

	public static void main(String[] args) {
		ArvoreBinaria<String, Integer> tree = new ArvoreBinaria<String, Integer>();
		Random r = new Random();
		
		String menu = "1.Inserir\n2.Consultar\n3.Informacoes\n4.Altura\n5.Depth\n6.Internal Path Length\n7.Imprimir\n8.Sair\n	";
		String chave;
		while (true) {
			String wOp = JOptionPane.showInputDialog(menu);
			int op = Integer.parseInt(wOp);
			
			switch (op) {
			case 1: // Inserir
				chave = JOptionPane.showInputDialog("Chave:");
				int valor = r.nextInt(100);
				tree.put(chave, valor);
				break;
			case 2: // Consultar
				chave = JOptionPane.showInputDialog("Chave:");
				JOptionPane.showMessageDialog(null, tree.get(chave));
				break;
			case 3: // quantidade de nos			
				JOptionPane.showMessageDialog(null, "Tamanho: "+tree.size());				
				break;
			case 4: // altura da arvore			
				JOptionPane.showMessageDialog(null, "Altura da arvore: "+tree.height());				
				break;
			case 5: // profundidade de um no				
				tree.setDepthField();
				JOptionPane.showMessageDialog(null, "Profundidades dos nós definidas!");
				break;
			case 6: // soma das profundidades de cada no
				if(tree.internalPathLength()==0 && tree.size()>1) {
					JOptionPane.showMessageDialog(null, "A profundidade de cada no nao foi definida!\n"
							+"Selecione a opcao 5 para definir.");
					break;
				}
				JOptionPane.showMessageDialog(null, "Altura da arvore: "+tree.internalPathLength());
				break;
			case 7:
				int opcao;
				do{
					opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção de Impressão:\n1.Pre-Ordem\n2.In-Ordem"
							+ "\n3.Pos-Ordem\n4.Voltar"));
				}while(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4);
				if(opcao==4)
					break;
				JOptionPane.showMessageDialog(null, tree.toString(opcao));
				break;
				
			default:
				System.exit(0);
			}
		}
	}
}