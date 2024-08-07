# Prática de TDD: Número Romano

Vamos escrever uma pequena funcionalidade que converta os números romanos para os números decimais.

Os números romanos são representados por sete símbolos diferentes:
- I = 1 (um)
- V = 5 (cinco)
- X = 10 (dez)
- L = 50 (cinquenta)
- C = 100 (cem)
- D = 500 (quinhentos)
- M = 1000 (mil)

Além disso, para representar os demais números, os romanos combinavam os símbolos, começando do algarismo de maior valor e seguindo a regra:
- Nenhum símbolo pode ser repetido lado a lado por mais de 3 vezes;
- Algarismos de menor ou igual valor à direita são somados ao algarismo de maior valor;
- Algarismos de menor valor à esquerda são subtraídos do algarismo de maior valor.

### Prática

Primeiro vamos escrever o primeiro teste que verifica o número romando I:

```java
public class ConversorNumeroRomanoTest {
	@Test
    public void deveEntenderSimboloI() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("I");
        assertEquals(1, numero);
    }
}
```

Criamos a função mais simples possível e que irá fazer o teste falhar:

```java
 public class ConversorNumeroRomano {
 	public int converte(String numeroRomano) {
		return 0;
	}
 }
```

Depois vamos corrigir a função da forma mais simples possível e que irá fazer o teste passar:

```java
 public class ConversorNumeroRomano {
 	public int converte(String numeroRomano) {
		return 1;
	}
 }
```

Agora vamos escrever o segundo teste que verifica o número romando V:

```java
	@Test
    public void deveEntenderSimboloV() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("V");
        assertEquals(5, numero);
    }
```

Após executar o novo teste ele irá falhar, então vamos corrigir a função da forma mais simples possível para passar no teste:

```java
 public class ConversorNumeroRomano {
 	public int converte(String numeroRomano) {
 		if (numeroRomano.equals("I")) return 1;
 		else if (numeroRomano.equals("V")) return 5;
		return 0;
	}
 }
```

Agora vamos escrever o terceiro teste que verifica o número romando X:

```java
	@Test
    public void deveEntenderSimboloX() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("X");
        assertEquals(10, numero);
    }
```

Após executar o novo teste ele irá falhar, então precisamos novamente corrigir a função da forma mais simples possível para passar no teste. Neste momento já notamos que escrever uma sequência de ifs encadeados não será uma boa estratégia.

Então seguiremos uma abordagem diferente:

```java
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
		return tabela.get(numeroRomano.charAt(0));
	}
 }
```

Ainda falta testar algumas regras. Por exemplo, algarismos de menor ou igual valor à direita são somados ao algarismo de maior valor

```java
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
```

O passo acima quebrou umas das regras do TDD: "Não escreva mais do que um teste para falhar". Contudo, já podemos notar acelerar os passos, pois sabemos que ao resolver um cenário o outro também deve ser resolvido.

```java
 	public int converte(String numeroRomano) {
	 	int acumulador = 0;
	 	for (int i = 0; i < numeroRomano.length(); i++) {
	 		acumulador += tabela.get(numeroRomano.charAt(i));
	 	}
		return acumulador;
	}
```

Agora vamos testar a regra: Algarismos de menor valor à esquerda são subtraídos do algarismo de maior valor.

```java
	@Test
    public void deveEntenderNumerosComoIV() {
        ConversorNumeroRomano romano = new ConversorNumeroRomano();
        int numero = romano.converte("IV");
        assertEquals(4, numero);
    }
```

Vamos finalizar nossa funcionalidade.

 ```java
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
 }
```

Finalizamos todos os cenários possíveis? Quais outros cenários são possíveis? Todas as regras foram testada?
