package banco;


public class Conta{

	private String codigo;
	private double saldo = 0;

	public Conta (String p_id, double p_saldo) { 
		this.saldo = p_saldo;
	    this.codigo = p_id;
	}
	
	public double getSaldo() {
		return saldo;
	} 

	public double debitar (double valor) throws OperacaoIlegalException {
		
		
		if(valor > 0 && saldo >= valor){
	         saldo = saldo-valor; 
	    }
		else{
			throw new OperacaoIlegalException();
		}
	   return saldo;

	}


	public double creditar (double valor) throws OperacaoIlegalException {
		
		if(valor > 0 ){
	         saldo = saldo+valor; 
	    }
		else{
			throw new OperacaoIlegalException();
		}
	   return saldo;

	}

/* ------------------------------------- ATIVIDADE ---------------------------------------------- */
	/**
	 * Realiza a transferência entre duas contas.
	 * @param c Conta que receberá a transferência
	 * @param val Valor a ser transferência 
	 * @return Saldo da conta atual
	 * @throws OperacaoIlegalException
	 */
	public double transferir (Conta c, double val) throws OperacaoIlegalException {
		
		c.creditar(val);
		this.debitar(val);
		
		return this.saldo;
	}
}

	

