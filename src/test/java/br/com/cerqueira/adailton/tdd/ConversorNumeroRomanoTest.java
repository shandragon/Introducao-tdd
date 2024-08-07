package br.com.cerqueira.adailton.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConversorNumeroRomanoTest {
	@Test
    public void deveEntenderSimboloI() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("I");
        assertEquals(1, numero);
    }
	
	@Test
    public void deveEntenderSimboloV() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("V");
        assertEquals(5, numero);
    }
	
	@Test
    public void deveEntenderSimboloX() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("X");
        assertEquals(10, numero);
    }
	
	@Test
    public void deveEntenderDoisSimbolos() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("II");
        assertEquals(2, numero);
    }
	
	@Test
    public void deveEntenderQuatroSimbolos() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("XXII");
        assertEquals(22, numero);
    }
	
	@Test
    public void deveEntenderNumerosComoIV() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("IV");
        assertEquals(4, numero);
    }
	
	@Test
    public void deveEntenderNumerosComoXIX() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("XIX");
        assertEquals(19, numero);
    }
}
