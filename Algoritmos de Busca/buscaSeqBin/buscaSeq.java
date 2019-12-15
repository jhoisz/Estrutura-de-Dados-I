package buscaSeqBin;

public class buscaSeq {
	
	public static int buscaSeq(int []a, int el) {
		for(int i = 0; i<a.length; i++) {
			if(a[i]==el) {
				return i;
			}
		}
		return -1;
	}
		public static void main(String[] args) {
		int []vet = {52, 125, -4, 32, 55, 6, -78, 200, 0, 63};
		
		System.out.println(buscaSeq(vet, 32));
		System.out.println(buscaSeq(vet, 53));

	}

}
