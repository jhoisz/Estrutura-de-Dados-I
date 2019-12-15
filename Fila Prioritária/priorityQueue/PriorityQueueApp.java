package priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

public class PriorityQueueApp {

	public static void main(String[] args) {
		Clientes cliente;
		PriorityQueue<Clientes> filaNormal = new PriorityQueue<Clientes>();
		PriorityQueue<Clientes> filaPrioridade = new PriorityQueue<Clientes>();
		String op = "";
		String nome = "";
		String prioridade = "";
		int tamanho = 0;
		int quant = 0;
		int numNormal = 0;
		int numPrioridade = 0;

		do {
			String[] choices = { "Inserir cliente na fila", "Atender cliente", "Verficar tamanho da fila",
					"Quantidade de clientes atendidos", "Listar clientes" };

			String in = (String) JOptionPane.showInputDialog(null, "Selecione uma opcao", "Fila com prioridade",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
			switch (in) {
			
			case "Inserir cliente na fila":
				//prioridade = JOptionPane.showInputDialog("Cliente prioritario? [1 - Sim | 2 - Nao]");
				String[] choices2 = { "Sim", "Nao"};
				String in2 = (String) JOptionPane.showInputDialog(null, "Cliente prioritario?", "Atendimento",
						JOptionPane.QUESTION_MESSAGE, null, choices2, choices2[0]);
				switch (in2) {
					case "Sim":
						op = "Digite o nome do cliente: ";
						nome = JOptionPane.showInputDialog(op);
						cliente = new Clientes(nome, numPrioridade);
						filaPrioridade.add(cliente);
						numPrioridade++;
						break;
					case "Nao":
						op = "Digite o nome do cliente: ";
						nome = JOptionPane.showInputDialog(op);
						cliente = new Clientes(nome, numNormal);
						filaNormal.add(cliente);
						numNormal++;
						break;
					default:
						break;
				}
				break;
				
			case "Atender cliente":
				Clientes removido = null;
				if (filaPrioridade.size() != 0) {
					removido = filaPrioridade.remove();		
					quant++;
				} else if (filaNormal.size() != 0) {
					removido = filaNormal.remove();
					quant++;
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum cliente na fila!");
					break;
				}
				JOptionPane.showMessageDialog(null, "Cliente " +removido.getCliente()+ " atendido!");
				break;
				
			case "Verficar tamanho da fila":
				if (filaNormal.isEmpty() && filaPrioridade.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum cliente na fila!");
				}else {
					tamanho = filaNormal.size() + filaPrioridade.size();
					JOptionPane.showMessageDialog(null, "Quantidade de clientes presentes na fila: " + tamanho);
				}
				break;
				
			case "Quantidade de clientes atendidos":
				JOptionPane.showMessageDialog(null, "Clientes atendidos: " + quant);
				break;
				
			case "Listar clientes":
				if (filaNormal.size() == 0 && filaPrioridade.size() == 0)
					JOptionPane.showMessageDialog(null, "Nenhum Cliente na fila!");
				String str = "";
				if (filaPrioridade.size() != 0) {
					for (Clientes a : filaPrioridade) {
						str += (a.getCliente() + " - ");
					}
				}
				if (filaNormal.size() != 0) {
					for (Clientes a : filaNormal) {
						str += (a.getCliente() + " - ");
					}
				}
				JOptionPane.showMessageDialog(null, str);
				break;
				
			default:
				break;
			} //fim do switch
			
		} while (true);
	}
}