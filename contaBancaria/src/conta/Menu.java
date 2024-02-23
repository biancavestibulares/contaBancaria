package conta;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		//Importação da classe "Conta" para fazer uso de seus atributos
		Conta novaConta = new Conta(null, 0, 0, 0, 0) { //Aqui, declaramos os atributos com valores vazios para que o usuário os registre
			//Temos que importar a Conta desta forma por ela ser uma classe abstract
		};
		//É imaginado que o usuário seja algum REPRESENTANTE do banco
		//Import de outras classes
		ContaCorrente contaCorrente = new ContaCorrente(null, 0, 0, 0, 0, 0);
		ContaPoupanca contaPoupanca = new ContaPoupanca(null, 0, 0, 0, 0, null);
		Cores cores = new Cores();

		//Criando uma lista para adicionar diferentes contas
		//Queue<String> clientesBanco = new LinkedList<String>();

		//Variável para o Menu
		int opcao = 0;

		while(true) {
			//Imprimindo no console as opções do menu
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("                                                 ");
			System.out.println("                BIANCA TRUST BANK                ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("     Opção 1 - Criar conta                       ");
			System.out.println("     Opção 2 - Listar todas as contas            ");
			System.out.println("     Opção 3 - Buscar conta por número           ");
			System.out.println("     Opção 4 - Atualizar dados da conta          ");
			System.out.println("     Opção 5 - Apagar conta                      ");
			System.out.println("     Opção 6 - Sacar                             ");
			System.out.println("     Opção 7 - Depositar                         ");
			System.out.println("     Opção 8 - Tranferir valores entre contas    ");
			System.out.println("     Opção 9 - Sair                              ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println(Cores.TEXT_RESET);
			System.out.print("Insira a opção desejada: ");
			System.out.println("                                                 ");

			//Criando um TryCatch no caso do usuário digitar uma String ao invés de um int
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) { //InputMismatchException é um erro captado quando a devolução não é um int
				System.err.println("\nExceção: " + e); //System.err.println imprime a exceção/erro - informa o usuário do problema encontrado
				leia.nextLine();
				System.out.println(Cores.TEXT_WHITE_BOLD + "Por favor, escolha uma das opções do Menu" + Cores.TEXT_RESET); //Instrução
			}

			//Criando casos para cada uma das opções
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                 ");
				System.out.println("                   CRIAR CONTA                   ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");
				System.out.println("                                                 ");

				System.out.println("Digite o nome do titular:                        ");
				leia.nextLine();
				String nomeTitular = leia.nextLine();
				novaConta.setNomeTitular(nomeTitular);

				System.out.println("Digite o número da agência:                      ");
				int agenciaConta = leia.nextInt();
				novaConta.setAgenciaConta(agenciaConta);

				System.out.println("Digite o tipo da conta, 1 corrente, 2 poupança:  ");
				int tipoConta = leia.nextInt();
				novaConta.setTipoConta(tipoConta);
				
				if(tipoConta == 1) {
					System.out.println("Digite o saldo mensal da conta:                  ");
					float saldo = leia.nextFloat();
					novaConta.setSaldo(saldo);
					
					System.out.println("Limite de crédito da conta:                      ");
					float limiteSaque = saldo * 0.90f; //Aqui, estamos declarando que o limite será igual a 90% do saldo, 
					//assim o usuário não poderá sacar mais do que tem na conta e também não poderá deixar sua conta vazia
					contaCorrente.setLimite(limiteSaque);
					System.out.println(limiteSaque);
				
				} else if(tipoConta == 2) {
					//Método para data de aniversário da conta bancária
					LocalDate dataAniv = LocalDate.now(); //LocalDate é capaz de pegar a data em tempo real
					DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Definindo o formato que a data será exibida
					String dataFormatada = dataAniv.format(formatadorData); //Formatando dataAniv
					contaPoupanca.setDataAniversario(dataFormatada);

					System.out.println("Aniversário da conta: " + dataFormatada);
					
				} else {
					System.out.println("                                                 ");
					System.out.println(Cores.TEXT_RED_BOLD + "Tipo de conta inválida!" + Cores.TEXT_RESET);
				}
				
				System.out.println("                                                 ");
				System.out.println("*************************************************");
				System.out.println("                                                 ");
				System.out.println(Cores.TEXT_RESET);
				
				continuarPrograma();
				break;

			case 2:
				System.out.println("                                                 ");
				System.out.println("             Listar todas as contas              ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 3:
				System.out.println("                                                 ");
				System.out.println("            Buscar conta por número              ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 4:
				System.out.println("                                                 ");
				System.out.println("            Atualizar dados da conta             ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 5:
				System.out.println("                                                 ");
				System.out.println("                   Apagar conta                  ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 6:
				System.out.println("                                                 ");
				System.out.println("                      Sacar                      ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 7:
				System.out.println("                                                 ");
				System.out.println("                    Depositar                    ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 8:
				System.out.println("                                                 ");
				System.out.println("          Tranferir valores entre contas         ");
				System.out.println("                                                 ");
				System.out.println("*************************************************");

				break;

			case 9:
				System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                 ");
				System.out.println("  BIANCA TRUST BANK agradeçe pela confiança ;)   ");
				novaConta.sobre();
				System.out.println(Cores.TEXT_RESET);
				System.exit(0);

				continuarPrograma();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!" + Cores.TEXT_RESET);
				continuarPrograma();
				break;
			}

		} //Fim do While

	}

	//Método que permite a execução do programa contínua
	public static void continuarPrograma() {
		try {
			System.out.println("                                                 ");
			System.out.println("Pressione Enter para continuar");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Pressione ENTER para continuar");
		}
	}

}
