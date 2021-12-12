
public class Main {

	public static void main(String[] args) {
		Banco itau = new Banco("Itau");
		Banco brasil = new Banco("Brasil");
		
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Cliente baldez = new Cliente();
		baldez.setNome("Baldez");
		
		Conta cc = new ContaCorrente(venilton);
		itau.adicionar(cc);
		cc.imprimirExtrato();
		
		Conta poupanca = new ContaPoupanca(baldez);
		brasil.adicionar(poupanca);
		poupanca.imprimirExtrato();
		
		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		itau.imprimirClientes();
		brasil.imprimirClientes();
		
		
	}

}
