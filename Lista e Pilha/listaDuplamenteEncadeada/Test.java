package listaDuplamenteEncadeada;

import static org.junit.Assert.*;

import org.junit.Before;

public class Test {
	@org.junit.Test
	public void test() {
		Lista<String> lista = new Lista<String>();
		
		lista.inserir("1");
		lista.inserir("2");
		lista.inserir("3");
		
		assertEquals("1", lista.inicio.getElem());
		assertEquals("2", lista.inicio.prox.getElem());
		assertEquals("3", lista.inicio.prox.prox.getElem());

		
		assertEquals("1", lista.inicio.prox.ant.getElem());
		assertEquals("2", lista.inicio.prox.prox.ant.getElem());
//		assertEquals("3", lista.inicio.prox.prox.prox.ant.getElem());
	
		assertEquals("3", lista.fim.getElem());
	
		//lista.remover();
		//assertEquals("2", lista.inicio.getElem());
	
		lista.remover(lista.inicio.prox.prox.getElem());
		assertEquals(null, lista.inicio.prox.prox);
		assertEquals("1", lista.inicio.prox.ant.getElem());
		
		lista.inserir("4");
		assertEquals("4", lista.inicio.prox.prox.getElem());
		assertEquals("2", lista.inicio.prox.prox.ant.getElem());
		System.out.println(lista);
	}
}