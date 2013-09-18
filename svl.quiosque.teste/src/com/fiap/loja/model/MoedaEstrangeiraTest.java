package com.fiap.loja.model;

import static org.junit.Assert.*;

import org.junit.Test;

/***
 * Teste de regressão com Junit 4 para o projeto svl.quiosque
 * @author alexbc
 * 
 */
public class MoedaEstrangeiraTest {

	@Test
	public void testConverterDolarParaReal() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testConverterDolarParaRealValorZerado() {
		MoedaEstrangeira a = new MoedaEstrangeira();
		assertEquals("Calculo com valor positivo", 0, a.converterDolarParaReal(0));
	}

	@Test
	public void testConverterDolarParaRealValorPositivo() {
		MoedaEstrangeira a = new MoedaEstrangeira();
		assertEquals("Calculo com valor positivo", 4, a.converterDolarParaReal(2));
	}

}
