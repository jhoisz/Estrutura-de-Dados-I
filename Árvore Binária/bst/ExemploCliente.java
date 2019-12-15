package bst;

import java.util.Random;

import javax.swing.JOptionPane;

import hash.StdIn;

public class ExemploCliente {

	public static void main(String[] args) {
		ArvoreBinaria<String, Integer> tree = new ArvoreBinaria<String, Integer>();
		Random r = new Random();
		String txt[] = StdIn.readAllStrings();
		String menu = "1.Consultar Chave\n2.Tamanho da Arvore\n3.Altura da Arvore\n4.Definir Profundidade\n5.Comprimento Interno da Arvore\n6.Imprimir Chaves\n7.Sair\n	";
		String chave;
		
		//inserindo chaves
		for(int i=0;i<txt.length;i++) {
			int valor = r.nextInt(txt.length);
			tree.put(txt[i], valor);	
		}
		while (true) {
			String wOp = JOptionPane.showInputDialog(menu);
			int op = Integer.parseInt(wOp);
			switch (op) {
			case 1: // Consultar
				chave = JOptionPane.showInputDialog("Chave:");
				JOptionPane.showMessageDialog(null, tree.get(chave));
				break;
			case 2: // quantidade de nos			
				JOptionPane.showMessageDialog(null, "Tamanho: "+tree.size());				
				break;
			case 3: // altura da arvore			
				JOptionPane.showMessageDialog(null, "Altura da arvore: "+tree.height());				
				break;
			case 4: // profundidade de um no				
				tree.setDepthField();
				JOptionPane.showMessageDialog(null, "Profundidades dos nós definidas!");
				break;
			case 5: // soma das profundidades de cada no
				if(tree.internalPathLength()==0 && tree.size()>1) {
					JOptionPane.showMessageDialog(null, "A profundidade de cada no nao foi definida!\nSelecione a opcao 4 para definir.",
							"Alerta", JOptionPane.ERROR_MESSAGE);
					break;
				}
				JOptionPane.showMessageDialog(null, "Comprimento interno: "+tree.internalPathLength());
				break;
			case 6:
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