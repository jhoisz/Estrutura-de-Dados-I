package priorityQueue;

public class Clientes implements Comparable<Clientes> {
	
	private String cliente;
	private int insercao;
	
	public Clientes(String cliente, int insercao) {
		this.cliente = cliente;
		this.insercao = insercao;
	}


	public Clientes() {
		// TODO Auto-generated constructor stub
	}


	public int compareTo(Clientes c) {
		if (this.insercao == (c.insercao)){
			return 0;
		}else if(this.insercao > c.insercao) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public String getCliente() {
		return cliente;
	}


	public int getInsercao() {
		return insercao;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public void setInsercao(int insercao) {
		this.insercao = insercao;
	}
	
	
	
}
