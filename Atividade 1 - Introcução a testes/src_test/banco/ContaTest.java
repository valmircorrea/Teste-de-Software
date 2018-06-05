package banco;

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
		
		System.out.println("Teste de transferência com valores dentro do padrão...");
		
		try {
			
			c1.transferir(c2, 50);
			
			assertEquals(c1.getSaldo(),50.0);
			assertEquals(c2.getSaldo(),50.0);
			
			System.out.println("- Sucesso!");

		} catch (OperacaoIlegalException ex) {
			System.out.println("Não foi possivel realizar a trasferência");
		}
		
	}
	
	/**
	 * Verifica se a exceção esta correta para valores negativos.
	 * @throws OperacaoIlegalException
	 */
	public void testTransferenciaNegativa () throws OperacaoIlegalException {
		
		Conta c1 = new Conta ("1234", 100);
		Conta c2 = new Conta ("12345", 0);
		
		System.out.println("Teste de transferência com valores negativos...");
		
		try {
			
			c1.transferir(c2, -1);
			
			assertEquals(c1.getSaldo(),99.0);
			assertEquals(c2.getSaldo(),1.0);
			
			fail("Exceção não foi lançada!");
			
		} catch (OperacaoIlegalException ex) {
			System.out.println("- Não é possivel realizar transferência com valores negativos!");
		}
	}
	
	/**
	 * Verifica se a exceção esta correta para transferência com valores acima do que há na conta. 
	 * @throws OperacaoIlegalException
	 */
	public void testTransferenciaAcima () throws OperacaoIlegalException {
		
		Conta c1 = new Conta ("1234", 100);
		Conta c2 = new Conta ("12345", 0);
		
		System.out.println("Teste de transferência com valores maiores que o da conta...");
		
		try {
			
			c1.transferir(c2, 150);
			
			assertEquals(c1.getSaldo(),99.0);
			assertEquals(c2.getSaldo(),1.0);
			
			fail("Exceção não foi lançada!");
			
		} catch (OperacaoIlegalException ex) {
			System.out.println("- Não há valor suficiente para realizar a transferência!");
		}
	}
}
