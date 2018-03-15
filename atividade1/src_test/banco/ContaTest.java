package banco;

//São para os testes com @Test
import static org.junit.Assert.*;


import junit.framework.TestCase;

public class ContaTest extends TestCase {

	public void testDebitarSucesso() throws OperacaoIlegalException{
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10,c.getSaldo(),0.0);
	}

/* ---------------------------------------- ATIVIDADE ---------------------------------------------- */
	/**
	 * Teste para verificar a corretude do algoritmo de transferência bancária.
	 * @throws OperacaoIlegalException
	 */
	public void testTransferencia () throws OperacaoIlegalException {
		
		Conta c1 = new Conta ("1234", 100);
		Conta c2 = new Conta ("12345", 0);
		
		System.out.println("Teste de transferência...");
		
		try {
			
			c1.transferir(c2, 50);
			
			assertEquals(c1.getSaldo(),50.0);
			assertEquals(c2.getSaldo(),50.0);
			
			System.out.println("Sucesso!");

		} catch (OperacaoIlegalException ex) {
			System.out.println("Não foi possivel realizar a trasferência");
		}
		
	}
	
	/**
	 * Método para verificar se a exceção esta correta. 
	 * @throws OperacaoIlegalException
	 */
	public void testTransferenciaEx () throws OperacaoIlegalException {
		
		Conta c1 = new Conta ("1234", 100);
		Conta c2 = new Conta ("12345", 0);
		
		System.out.println("Teste de exceção...");
		
		try {
			
			c1.transferir(c2, -1);
			
			assertEquals(c1.getSaldo(),50.0);
			assertEquals(c2.getSaldo(),50.0);
			
			fail("Exceção não foi lançada!");
			
		} catch (OperacaoIlegalException ex) {
			System.out.println("Exceção lançada com sucesso: Não foi possivel realizar a trasferência!");
		}
	}
}
