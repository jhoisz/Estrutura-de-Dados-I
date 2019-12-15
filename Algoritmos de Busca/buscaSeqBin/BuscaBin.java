package buscaSeqBin;

 //metodo de implementacao do professor
public class BuscaBin {
	public static int buscaBin(int []a, int el) {
		int fim = a.length - 1;
		int ini = 0;
		
		while(ini<=fim) {
			int meio = (ini + fim)/2;
			if(a[meio]<el) {
				ini = meio + 1;
			}else {
				if(a[meio]>el) {
					fim = meio - 1;
				}else {
					return meio;
				}
			}
		}
		return -1;
	}

/*
//metodo de implementacao que vi na interweb
public class BuscaBin {
	public static int buscaBin(int []a, int el) {
		 int n = a.length;     
		 int aux = 0;     
		         
		    for(int i = 0; i < n-1; i++){   
		        for(int j = i+1 ; j < n; j++){    
		            if(a[i] > a[j]){   
		                aux = a[j];     
		                a[j] = a[i];     
		                a[i] = aux;     
		            }     
		        }     
		    }     
		
		int fim = a.length - 1;
		int ini = 0;
		
		while(ini<=fim) {
			int meio = (ini + fim)/2;
			if(a[meio]==el) {
				return meio-1;
			}
			if(a[meio]>el) {
				fim = meio - 1;
			}else {
				ini = meio + 1;
			}
		}
		return -1;
	}
*/
	public static void main(String[] args) {
		int []vet = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(buscaBin(vet, 32));
		System.out.println(buscaBin(vet, 53));
	}

}
