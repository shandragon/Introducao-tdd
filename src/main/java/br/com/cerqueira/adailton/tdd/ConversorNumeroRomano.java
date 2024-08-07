package br.com.cerqueira.adailton.tdd;

import java.util.HashMap;
import java.util.Map;

public class ConversorNumeroRomano {
	
	private Map<Character, Integer> tabela;
	
	public ConversorNumeroRomano() {
		tabela = new HashMap<Character, Integer>();
		tabela.put('I', 1);
		tabela.put('V', 5);
		tabela.put('X', 10);
		tabela.put('L', 50);
		tabela.put('C', 100);
		tabela.put('D', 500);
		tabela.put('M', 1000);
	}
	
	public int converte(String numeroRomano) {
		int acumulador = 0;
		int ultimoVisitado = 0;
		// Inicia a leitura pelo final da string
		for (int i = numeroRomano.length() - 1; i >= 0; i--) {
			// Pega o inteiro a atual
			int atual = tabela.get(numeroRomano.charAt(i));
			
			// Se o inteiro atual for menor que o último
			int multiplicador = (atual < ultimoVisitado) ? -1 : 1;
			
			acumulador += atual * multiplicador;
			
			// Atualiza o último número
			ultimoVisitado = atual;
		}
		return acumulador;
	}
	
	private boolean isNumeroValido(String numeroRomano) {
		return true;
	}
}
