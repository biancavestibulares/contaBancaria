package conta.model;

public class ContaPoupanca extends Conta{ //Herdando os atributos da classe Conta
	
	//Variável
	private String dataAniversario;
	
	//Construtor
	public ContaPoupanca(String nomeTitular, int agenciaConta, int tipoConta, int numeroConta, float saldo, String dataAniversario) {
		super(nomeTitular, agenciaConta, tipoConta, numeroConta, saldo); //Construtor da classe-mãe (Conta)
		this.dataAniversario = dataAniversario;
	}

	//Getter e Setter da variável dataAniversario
	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	//Criando um método para visualização da data de aniversário da conta
	//No caso, irei definir a data pelo dia em que o Menu for executado
	@Override//Para poder usar um método já existente na classe-mãe
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + this.dataAniversario);
	}

}
