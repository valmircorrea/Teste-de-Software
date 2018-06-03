package aposentadoria;
/*
 =====================================================================================
 ARQUIVO............: Aposentadoria.java
 DESCRICAO..........: Codigo fonte referente a uma classe a ser testada, representando
 					  uma aposentadoria.
 AUTOR..............: Valmir Correa (valmir.jr.correa@gmail.com)
 CRIADO EM..........: 02/06/2018
 MODIFICADO EM......: 02/06/2018
 =====================================================================================
*/

/*
===================================================================
Atividade de Análise de valor limite - Teste de Software 1

Alunos: Valmir Correa e Shirley Ohara

- Só me aposento INTEGRAL com:
	- Idade minima de 60 anos e tempo de Contribuição de 30 anos.

	y = idade e x = tempo de contribuição.

	Integral - y >= 60 e x >= 30.

- Só me aposento PARCIAL com:
	- Idade mínima de 60 e tempo de contribuição entre 20 e 29 anos.

	y = idade e x = tempo de contribuição.

	Parcial  - y >= 60 e 20 <= x <= 29.
====================================================================
*/

/**
 * @author Valmir
 * Classe que representa uma aposentadoria.
 */
public class Aposentadoria {
	
	String aposentadoria;
	
	/**
	 * Construtor padrão. 
	 */
	public Aposentadoria() {
		aposentadoria = "NEGADO";
	}
	
	/**
	 * Define critérios para aposentadoria Integral e parcial.
	 * @param idade
	 * @param tempoContribuicao
	 * @return Tipo de aposentadoria que se enquadra.
	 */
	public String deveSeAposentar (int idade, int tempoContribuicao) {
		if (idade >= 60) {
			if ((tempoContribuicao >= 30) ) {
				aposentadoria = "INTEGRAL";
			} else if ((tempoContribuicao >= 20) && (tempoContribuicao <= 29)) {
				aposentadoria = "PARCIAL";
			}
		}
		return aposentadoria;
	}
}
