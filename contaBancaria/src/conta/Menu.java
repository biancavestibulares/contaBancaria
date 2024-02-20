package conta;

import conta.model.Conta;

public class Menu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Aqui, importamos a classe "Conta" para fazer uso de seus atributos
		Conta novaConta = new Conta("Bianca", 123, 1, 2527, 500.00f);
		
		//Imprimindo os resultados de acordo com a classe do model
		novaConta.visualizar();
		/*novaConta.setAgenciaConta(456);
		System.out.println(novaConta.getAgenciaConta());*/
		
		if(novaConta.sacar(1000)) { //É aqui que declaramos o valor!
			System.out.println("\nSaque efetuado com sucesso! O novo saldo é de: " + novaConta.getSaldo());
		} else {
			System.out.println("\nO saldo é insuficiente!");
		}
	
		novaConta.depositar(5000);
		System.out.println("\nO novo saldo é de: " + novaConta.getSaldo());
		
	}

}
