/*
=================================================================================
ARQUIVO............: AposentadoriaValidTest.java
DESCRICAO..........: Codigo fonte referente a uma classe de testes parametrizados
					 para o método "deveSeAposentar" da classe "Aposentadoria".
					 Baseado em uma atividade feita anteriormente em uma análise
					 de valor limite.
AUTOR..............: Valmir Correa (valmir.jr.correa@gmail.com)
CRIADO EM..........: 02/06/2018
MODIFICADO EM......: 02/06/2018
=================================================================================
*/

package aposentadoriaTeste;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import aposentadoria.Aposentadoria;

@RunWith(Parameterized.class)
public class AposentadoriaValidTest {

	@Parameters(name = "[index]: deveSeAposentar[{0},{1}]")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { 	{65, 	50, 	"INTEGRAL"	}, 
												{10, 	12, 	"NEGADO"	},
												{60, 	30, 	"INTEGRAL" 	},
												{59, 	29, 	"NEGADO"	},
												{65, 	22, 	"PARCIAL"	},
												{10,	69, 	"NEGADO"	},
												{60, 	20, 	"PARCIAL"	},
												{59, 	19, 	"NEGADO"	} 		});
	}
	
	/**
	 * Idade.
	 */
	private int fInputIdade;
	
	/**
	 * Tempo de Contribuição.
	 */
	private int fInputTempoContribuicao;
	
	/**
	 * Resultado esperado.
	 */
	private String fExpected;
	
	/**
	 * Instancia para a verificação da aposentadoria.
	 */
	private Aposentadoria aposentadoria;
	
	/**
	 * Construtor parametrizado
	 */
	public AposentadoriaValidTest (int fInputIdade, int fInputTempoContribuicao, String fExpected) {
		this.fInputIdade = fInputIdade;
		this.fInputTempoContribuicao = fInputTempoContribuicao;
		this.fExpected = fExpected;
		aposentadoria = new Aposentadoria();
	}
	
	@Test
	public void TestdeveSeAposentar () {
		assertEquals(this.fExpected, aposentadoria.deveSeAposentar(this.fInputIdade, this.fInputTempoContribuicao));
	}
	
}
