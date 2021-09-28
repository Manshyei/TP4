/*package principal;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		// Funcionalidades:
		int num1, num2, numsala; //num1 � uma vari�vel de controle pro primeiro menu, e num2 � uma vari�vel de controle pro segundo menu.
		Scanner input = new Scanner(System.in);	//declara��o de vari�veis para receber entrada do usu�rio do tipo String.
		Scanner ler = new Scanner(System.in); //declara��o de vari�veis para receber entrada do usu�rio do tipo Int.
		ClienteVIP cliente = new ClienteVIP(); //cria��o do objeto cliente.
		String cpf, nomefilme;
		VendaIngresso ingresso = new VendaIngresso(); //cria��o do objeto ingresso
		Filme filme = new Filme(); // cria��o do objeto filme
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
			System.out.println("Selecione a op��o desejada:\n"
					+ "1-Cliente VIP\n"
					+ "2-Filme\n"
					+ "3-Funcion�rio\n"
					+ "4-Ingresso\n"
					+ "5-Sala de Cinema\n"
					+ "6-Sair\n");
			
			num1 = ler.nextInt();
			
			switch (num1) {
				
				/// usu�rio escolhe Cliente VIP:
				case 1: 
					System.out.println("Selecione a op��o desejada:\n"
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
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
						break;
					case 4:
						cliente.visualizar();
						System.out.println("Digite o CPF do Cliente a ser deletado:\n");
						cpf = input.nextLine();
						if (cliente.buscar(cpf) != null)
							cliente.deletar(cliente.buscar(cpf));
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
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
						System.out.println("N�o foi escolhida nenhuma op��o v�lida\n"
										   + "Voltando ao menu!");
						break;
					}
				break;
				
				// usu�rio escolhe Filme
				case 2:
					System.out.println("Selecione a op��o desejada:\n"
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
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
						break;
					case 4:
						cliente.visualizar();
						System.out.println("Digite o nome do filme a ser deletado:\n");
						nomefilme = input.nextLine();
						if (filme.buscar(nomefilme) != null)
							filme.deletar(filme.buscar(nomefilme));
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
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
						System.out.println("N�o foi escolhida nenhuma op��o v�lida\n"
										   + "Voltando ao menu!");
					break;
					}
				break;
					
					
				// usu�rio escolhe Funcion�rio
				
				case 3:
					System.out.println("Selecione a op��o desejada:\n"
							+ "1-Cadastrar funcion�rio\n"
							+ "2-Visualizar funcion�rios\n"
							+ "3-Editar funcion�rios\n"
							+ "4-Deletar funcion�rio\n"
							+ "5-Buscar funcion�rio por CPF\n"
							+ "6-Sair\n");
					
					/// --- ENTRA MENU 2 PRO FUNCION�RIO
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
						System.out.println("Digite o CPF do funcion�rio a ser editado:\n");
						cpf = input.nextLine();
						if (funcionario.buscar(cpf) != null)
							funcionario.editar(funcionario.buscar(cpf));
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
						break;
					case 4:
						funcionario.visualizar();
						System.out.println("Digite o CPF do funcion�rio a ser deletado:\n");
						cpf = input.nextLine();
						if (funcionario.buscar(cpf) != null)
							funcionario.deletar(funcionario.buscar(cpf));
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
						break;
					case 5:
						System.out.println("Digite o CPF do funcion�rio a ser procurado:\n");
						cpf = input.nextLine();
						if (funcionario.buscar(cpf) != null)
							funcionario.buscar(cpf);
						break;
					case 6:
						System.out.println("Retornando ao menu\n");
						break;
					default:
						System.out.println("N�o foi escolhida nenhuma op��o v�lida\n"
										   + "Voltando ao menu!");
						break;
					}
					break;
					
				/// usu�rio escolhe Ingresso
				case 4:
					System.out.println("Selecione a op��o desejada:\n"
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
						System.out.println("N�o foi escolhida nenhuma op��o v�lida\n"
										   + "Voltando ao menu!");
						break;
					}
					break;
					
				/// usu�rio escolhe Sala de cinema
				case 5:
					System.out.println("Selecione a op��o desejada:\n"
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
						System.out.println("Digite o n�mero da sala a ser editado:\n");
						numsala = input.nextInt();
						if (sala.buscar(numsala) != null)
							sala.editar(sala.buscar(numsala));
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
						break;
					case 4:
						sala.visualizar();
						System.out.println("Digite o n�mero da sala a ser deletado:\n");
						numsala = input.nextInt();
						if (sala.buscar(numsala) != null)
							sala.deletar(sala.buscar(numsala));
						else System.out.println("Op��o inv�lida, voltando ao menu!\n");
						break;
					case 5:
						System.out.println("Digite o n�mero da sala a ser procurado:\n");
						numsala = ler.nextInt();
						if (sala.buscar(numsala) != null)
							sala.buscar(numsala);
						break;
					case 6:
						System.out.println("Retornando ao menu\n");
						break;
					default:
						System.out.println("N�o foi escolhida nenhuma op��o v�lida\n"
										   + "Voltando ao menu!");
						break;
					}
					break;
					
				///usu�rio escolhe sair do menu
				case 6:
					System.out.println("Saindo... Volte Sempre!");
					break;
					
				///usu�rio n�o escolhe nenhuma op��o entre as op��es acima
				default:
					System.out.println("Voc� n�o inseriu nenhuma op��o v�lida. Por favor, escolha novamente!\n");
					break;	
			}
			
			if (num1 == 6) break; // Saida do Programa
			
		} while (true);

	
	}
}*/