/*package principal;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		// Funcionalidades:
		int num1, num2, numsala; //num1 é uma variável de controle pro primeiro menu, e num2 é uma variável de controle pro segundo menu.
		Scanner input = new Scanner(System.in);	//declaração de variáveis para receber entrada do usuário do tipo String.
		Scanner ler = new Scanner(System.in); //declaração de variáveis para receber entrada do usuário do tipo Int.
		ClienteVIP cliente = new ClienteVIP(); //criação do objeto cliente.
		String cpf, nomefilme;
		VendaIngresso ingresso = new VendaIngresso(); //criação do objeto ingresso
		Filme filme = new Filme(); // criação do objeto filme
		Funcionario funcionario = new Funcionario();
		SalaCinema sala = new SalaCinema();
		
		// Dados Pre Cadastrados:
		cliente.dadosPreCadastradosClientes();
		filme.dadosPreCadastradosFilmes();
		funcionario.dadosPreCadastradosFuncionario();
		ingresso.dadosPreCadastradosVendaIngresso();
		sala.dadosPreCadastradosSala();
		
		// Menu:
		do {
			System.out.println("Selecione a opção desejada:\n"
					+ "1-Cliente VIP\n"
					+ "2-Filme\n"
					+ "3-Funcionário\n"
					+ "4-Ingresso\n"
					+ "5-Sala de Cinema\n"
					+ "6-Sair\n");
			
			num1 = ler.nextInt();
			
			switch (num1) {
				
				/// usuário escolhe Cliente VIP:
				case 1: 
					System.out.println("Selecione a opção desejada:\n"
							+ "1-Cadastrar Cliente VIP\n"
							+ "2-Visualizar Clientes VIPs\n"
							+ "3-Editar Cliente VIP\n"
							+ "4-Deletar Cliente VIP\n"
							+ "5-Buscar Cliente VIP por CPF\n"
							+ "6-Sair\n");
					
					num2 = ler.nextInt();
					
					switch (num2) {
					
					case 1:
						cliente.cadastrar();
						break;
					case 2:
						cliente.visualizar();
						break;
					case 3:
						cliente.visualizar();
						System.out.println("Digite o CPF do Cliente a ser editado:\n");
						cpf = input.nextLine();
						if (cliente.buscar(cpf) != null)
							cliente.editar(cliente.buscar(cpf));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 4:
						cliente.visualizar();
						System.out.println("Digite o CPF do Cliente a ser deletado:\n");
						cpf = input.nextLine();
						if (cliente.buscar(cpf) != null)
							cliente.deletar(cliente.buscar(cpf));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 5:
						System.out.println("Digite o CPF do Cliente a ser procurado:\n");
						cpf = input.nextLine();
						if (cliente.buscar(cpf) != null)
							cliente.buscar(cpf);
						break;
					case 6:
						System.out.println("Retornando ao menu\n");
						break;
					default:
						System.out.println("Não foi escolhida nenhuma opção válida\n"
										   + "Voltando ao menu!");
						break;
					}
				break;
				
				// usuário escolhe Filme
				case 2:
					System.out.println("Selecione a opção desejada:\n"
							+ "1-Cadastrar filme\n"
							+ "2-Visualizar filmes\n"
							+ "3-Editar filme\n"
							+ "4-Deletar filme\n"
							+ "5-Buscar filme por nome\n"
							+ "6-Sair\n");
					
					// --- ENTRA MENU 2 PRO FILME
					num2 = ler.nextInt();
					switch (num2) {
					
					case 1:
						filme.cadastrar();
						break;
					case 2:
						filme.visualizar();
						break;
					case 3:
						filme.visualizar();
						System.out.println("Digite o nome do filme a ser editado:\n");
						nomefilme = input.nextLine();
						if (filme.buscar(nomefilme) != null)
							filme.editar(filme.buscar(nomefilme));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 4:
						cliente.visualizar();
						System.out.println("Digite o nome do filme a ser deletado:\n");
						nomefilme = input.nextLine();
						if (filme.buscar(nomefilme) != null)
							filme.deletar(filme.buscar(nomefilme));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 5:
						System.out.println("Digite o nome do filme a ser procurado:\n");
						nomefilme = input.nextLine();
						if (filme.buscar(nomefilme) != null)
							filme.buscar(nomefilme);
						break;
					case 6:
						System.out.println("Retornando ao menu\n");
						break;
					default:
						System.out.println("Não foi escolhida nenhuma opção válida\n"
										   + "Voltando ao menu!");
					break;
					}
				break;
					
					
				// usuário escolhe Funcionário
				
				case 3:
					System.out.println("Selecione a opção desejada:\n"
							+ "1-Cadastrar funcionário\n"
							+ "2-Visualizar funcionários\n"
							+ "3-Editar funcionários\n"
							+ "4-Deletar funcionário\n"
							+ "5-Buscar funcionário por CPF\n"
							+ "6-Sair\n");
					
					/// --- ENTRA MENU 2 PRO FUNCIONÁRIO
					num2 = ler.nextInt();
					switch (num2) {
					
					case 1:
						funcionario.cadastrar();
						break;
					case 2:
						funcionario.visualizar();
						break;
					case 3:
						funcionario.visualizar();
						System.out.println("Digite o CPF do funcionário a ser editado:\n");
						cpf = input.nextLine();
						if (funcionario.buscar(cpf) != null)
							funcionario.editar(funcionario.buscar(cpf));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 4:
						funcionario.visualizar();
						System.out.println("Digite o CPF do funcionário a ser deletado:\n");
						cpf = input.nextLine();
						if (funcionario.buscar(cpf) != null)
							funcionario.deletar(funcionario.buscar(cpf));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 5:
						System.out.println("Digite o CPF do funcionário a ser procurado:\n");
						cpf = input.nextLine();
						if (funcionario.buscar(cpf) != null)
							funcionario.buscar(cpf);
						break;
					case 6:
						System.out.println("Retornando ao menu\n");
						break;
					default:
						System.out.println("Não foi escolhida nenhuma opção válida\n"
										   + "Voltando ao menu!");
						break;
					}
					break;
					
				/// usuário escolhe Ingresso
				case 4:
					System.out.println("Selecione a opção desejada:\n"
							+ "1-Cadastrar ingresso\n"
							+ "2-Sair\n" );
					
					/// --- ENTRA MENU 2 PRO INGRESSO
					num2 = ler.nextInt();
					switch (num2) {
					
					case 1:
						ingresso.cadastrar();
						break;
		
					case 2:
						System.out.println("Retornando ao menu\n");
						break;
						
					default:
						System.out.println("Não foi escolhida nenhuma opção válida\n"
										   + "Voltando ao menu!");
						break;
					}
					break;
					
				/// usuário escolhe Sala de cinema
				case 5:
					System.out.println("Selecione a opção desejada:\n"
							+ "1-Cadastrar sala de cinema\n"
							+ "2-Visualizar salas de cinema\n"
							+ "3-Editar sala de cinema\n"
							+ "4-Deletar sala de cinema\n"
							+ "5-Sair\n");
					
					/// --- ENTRA MENU 2 PRA SALA DE CINEMA
					num2 = ler.nextInt();
					switch (num2) {
					
					case 1:
						sala.cadastrar();
						break;
					case 2:
						sala.visualizar();
						break;
					case 3:
						sala.visualizar();
						System.out.println("Digite o número da sala a ser editado:\n");
						numsala = input.nextInt();
						if (sala.buscar(numsala) != null)
							sala.editar(sala.buscar(numsala));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 4:
						sala.visualizar();
						System.out.println("Digite o número da sala a ser deletado:\n");
						numsala = input.nextInt();
						if (sala.buscar(numsala) != null)
							sala.deletar(sala.buscar(numsala));
						else System.out.println("Opção inválida, voltando ao menu!\n");
						break;
					case 5:
						System.out.println("Digite o número da sala a ser procurado:\n");
						numsala = ler.nextInt();
						if (sala.buscar(numsala) != null)
							sala.buscar(numsala);
						break;
					case 6:
						System.out.println("Retornando ao menu\n");
						break;
					default:
						System.out.println("Não foi escolhida nenhuma opção válida\n"
										   + "Voltando ao menu!");
						break;
					}
					break;
					
				///usuário escolhe sair do menu
				case 6:
					System.out.println("Saindo... Volte Sempre!");
					break;
					
				///usuário não escolhe nenhuma opção entre as opções acima
				default:
					System.out.println("Você não inseriu nenhuma opção válida. Por favor, escolha novamente!\n");
					break;	
			}
			
			if (num1 == 6) break; // Saida do Programa
			
		} while (true);

	
	}
}*/