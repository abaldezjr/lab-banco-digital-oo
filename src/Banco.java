import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		contas = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public Conta adicionar(Conta conta){
		contas.add(conta);
		return conta;
	}
	
	public void imprimirClientes() {
		System.out.println("===Lista de clientes==>"+this.getNome());
		for(int i = 0; i < this.contas.size(); i++) {
			System.out.println((i+1) +" -> "+ this.contas.get(i).getCliente().getNome()+" tem uma "+this.contas.get(i).getClass().getCanonicalName());
		}
	}

}
