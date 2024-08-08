package br.com.cerqueira.adailton.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cerqueira.adailton.tdd.exception.NumeroRomanoException;

public class ConversorNumeroRomanoTest {	
	@Test
    public void deveEntenderSimboloI() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("I");
        assertEquals(1, numero);
    }
	
	@Test
    public void deveEntenderSimboloV() throws NumeroRomanoException  {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("V");
        assertEquals(5, numero);
    }
	
	@Test
    public void deveEntenderSimboloX() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("X");
        assertEquals(10, numero);
    }
	
	@Test
    public void deveEntenderDoisSimbolos() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("II");
        assertEquals(2, numero);
    }
	
	@Test
    public void deveEntenderQuatroSimbolos() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("XXII");
        assertEquals(22, numero);
    }
	
	@Test
    public void deveEntenderNumerosComoIV() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("IV");
        assertEquals(4, numero);
    }
	
	@Test
    public void deveEntenderNumerosComoXIX() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("XIX");
        assertEquals(19, numero);
    }
	
	@Test
    public void deveVerificarNumerosComoIIII() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        boolean isNumeroRomano = romano.isNumeroValido("IIII");
        assertEquals(false, isNumeroRomano);
    }
	
	@Test
    public void deveVerificarNumerosComoIXXXX() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        boolean isNumeroRomano = romano.isNumeroValido("IXXXX");
        assertEquals(false, isNumeroRomano);
    }
	
	@Test(expected=NumeroRomanoException.class)
    public void naoDeveEntenderNumerosComoIXXXX() throws NumeroRomanoException {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        romano.converte("IXXXX");
    }
}
