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
		if(numeroRomano.equals("I")) return 1;
		else if(numeroRomano.equals("V")) return 5;
		return tabela.get(numeroRomano.charAt(0));
	}
}
