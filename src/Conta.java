
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private StatusConta status;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.status = StatusConta.ATIVADA;
	}

	@Override
	public boolean sacar(double valor) {
		if(valor > saldo) {
			System.out.println("Impossível sacar o valor de "+valor+" já que seu saldo é de "+saldo);
			return false;
		}else {
			System.out.println("O valor de "+saldo+" foi sacado na conta de "+this.getCliente().getNome());
			saldo -= valor;
			return true;
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("O valor de "+saldo+" foi depositado na conta de "+this.getCliente().getNome());
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(this.sacar(valor)) {
			contaDestino.depositar(valor);
			System.out.println("Transferencia efetuada entre os clientes("+this.getCliente().getNome()+","+contaDestino.getCliente().getNome()+")");
		}else {
			System.out.println("Impossível a transferencia.");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
		
	public Cliente getCliente() {
		return cliente;
	}

	public void fechar() {
		if(this.saldo == 0) {
			System.out.println("Conta foi desativada.");
			this.status = StatusConta.DESATIVADA;
		}else if(this.saldo > 0) {
			System.out.println("Você deve sacar a quantia de "+this.saldo+" antes de fechar a conta.");
		}else if(this.saldo < 0) {
			System.out.println("Você deve depositar a quantia de "+this.saldo+" antes de fechar a conta.");
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Status: %s", this.status));
	}
}
