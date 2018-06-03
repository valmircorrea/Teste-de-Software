package aposentadoriaTeste;

import aposentadoria.Aposentadoria;
import junit.framework.TestCase;

/*
=================================================================================
ARQUIVO............: AposentadoriaTest.java
DESCRICAO..........: Codigo fonte referente a uma classe de testes parametrizados
					 para o método "deveSeAposentar" da classe "Aposentadoria".
					 Baseado em uma atividade feita anteriormente em uma análise
					 de valor limite.
AUTOR..............: Valmir Correa (valmir.jr.correa@gmail.com)
CRIADO EM..........: 02/06/2018
MODIFICADO EM......: 02/06/2018
=================================================================================
*/

/*
==========================================================
Atividade de Análise de valor limite - Teste de Software 1

Alunos: Valmir Correa e Shirley Ohara.

	y = idade e x = tempo de contribuição.

	Integral - y >= 60 e x >= 30.

- IN : y = 65 e x = 50. - Faz condição ser TRUE.
- OUT: y = 10 e x = 12. - Faz condição ser FALSE.
- ON : y = 60 e x = 30. - Exatamente na fronteira.
- OFF: y = 59 e x = 29. - Fora do dominio, sendo o mais próximo possível.

	y = idade e x = tempo de contribuição.

	Parcial - y >= 60 e 20 <= x <= 29.
 
- IN : y = 65 e x = 22.
- OUT: y = 10 e x = 69.
- ON : y = 60 e x = 20 ou y = 60 e x = 29.
- OFF: y = 59 e x = 19 ou y = 59 e x = 30.
===========================================================
*/

/**
 * @author valmir
 * Classe teste
 */
public class AposentadoriaTest extends TestCase {
	
	Aposentadoria ap;
	
	/**
	 * Contrutor padrão
	 */
	public AposentadoriaTest() {
		super();
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		ap = new Aposentadoria();
	}
	
	// ======================== INTEGRAL ============================ //
	
	/**
	 * Teste para Aposentadoria INTEGRAL - IN 
	 */
	public void testInIntegral () {
		assertEquals("INTEGRAL", ap.deveSeAposentar(65, 50));
	}
	
	/**
	 * Teste para Aposentadoria INTEGRAL - OUT
	 */
	public void testOutIntegral () {
		assertEquals("NEGADO", ap.deveSeAposentar(10, 12));
	}
	
	/**
	 * Teste para Aposentadoria INTEGRAL - ON
	 */
	public void testOnIntegral () {
		assertEquals("INTEGRAL", ap.deveSeAposentar(60, 30));
	}
	
	/**
	 * Teste para Aposentadoria INTEGRAL - OFF 
	 */
	public void testOffIntegral () {
		assertEquals("NEGADO", ap.deveSeAposentar(59, 29));
	}

	// ======================= PARCIAL ============================= //
	
	/**
	 * Teste para Aposentadoria PARCIAL - IN
	 */
	public void testInParcial() {
		assertEquals("PARCIAL", ap.deveSeAposentar(65, 22));
	}
	
	/**
	 * Teste para Aposentadoria PARCIAL - OUT
	 */
	public void testOutParcial() {
		assertEquals("NEGADO", ap.deveSeAposentar(10, 69));
	}
	
	/**
	 * Teste para Aposentadoria PARCIAL - ON
	 */
	public void testOnParcial() {
		assertEquals("PARCIAL", ap.deveSeAposentar(60, 20));
	}
	
	/**
	 * Teste para Aposentadoria PARCIAL - OFF
	 */
	public void testOffnParcial() {
		assertEquals("NEGADO", ap.deveSeAposentar(59, 19));
	}
}
