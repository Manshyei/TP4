package principal;

import java.util.*;

public class ClienteVIP extends Pessoa {
	
	// ----------------- ATRIBUTOS ----------------- //
	
	private String generoFavorito;
	private int qntddFilmesVistos;
	private String planoAssinatura;
	
	public ClienteVIP(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- // 
	
	// Sobrecarga
	public ClienteVIP(String primNome, String ultNome, String data, String c, String numCel, String email, String genFav, int qntddFilmesVistos, String planAss) {
		primeiroNome = primNome;
		ultimoNome = ultNome;
		dataNascimento = data;
		cpf = c;
		numCelular = numCel;
		this.email = email;
		generoFavorito = genFav;
		this.qntddFilmesVistos = qntddFilmesVistos;
		planoAssinatura = planAss;
	}
	
	public ClienteVIP(String primNome, String ultNome, String data, String c, String numCel, String email) {
		primeiroNome = primNome;
		ultimoNome = ultNome;
		dataNascimento = data;
		cpf = c;
		numCelular = numCel;
		this.email = email;
	}
	
	// Funcionalidades:
	
	Scanner input = new Scanner(System.in);	
	Scanner ler = new Scanner(System.in);
	ArrayList<ClienteVIP> dadosCliente = new ArrayList<ClienteVIP>();
	
	// Pré-cadastro de dados do cliente:
	
	public void dadosPreCadastradosClientes() {
		ClienteVIP cliente1 = new ClienteVIP("Caio", "Oliveira", "19/10/2001", "014.123.456-43", "(61)-99321-4506", "caioOliveira@hotmail.com", "Ação", 5, "Mensal");
		ClienteVIP cliente2 = new ClienteVIP("Lucas", "Queiroz", "23/08/2001", "324.576.472-04", "(61)-99431-4792", "lucasQueiroz@hotmail.com", "Comédia", 3, "Anual");
		ClienteVIP cliente3 = new ClienteVIP("Joana", "Barboza", "01/01/1999", "577.165.890-81", "(62)-98232-9175", "joanaBarboza@gmail.com", "Aventura", 10, "Semestral");
		ClienteVIP cliente4 = new ClienteVIP("Maicon", "Torres", "10/09/2002", "768.019.355-91", "(61)-98651-0194", "maiconTorres@hotmail.com", "Terror", 2, "Mensal");
		ClienteVIP cliente5 = new ClienteVIP("Maria", "Monaliza", "07/12/1998", "943.987.185-01", "(62)-99184-0192", "mariaMonaliza@hotmail.com", "Policial", 20, "Mensal");
		
		dadosCliente.add(cliente1);
		dadosCliente.add(cliente2);
		dadosCliente.add(cliente3);
		dadosCliente.add(cliente4);
		dadosCliente.add(cliente5);
	}
	
	// ------------------ METODOS ------------------- //
	
	// Funcao para cadastrar os dados de Cliente:
	
	/*public void cadastrar() {
		String primNome, ultNome, data, cpf, numCel, email, genFav, planAss;
		int qntdFilmesVistos;
				
		System.out.println("Primeiro Nome: ");
		primNome = input.nextLine();
		System.out.println("Último Nome: ");
		ultNome = input.nextLine();
		System.out.println("Data de Nascimento: ");
		data = input.nextLine();
		System.out.println("CPF: ");
		cpf = input.nextLine();
		System.out.println("Número de Celular: ");
		numCel = input.nextLine();
		System.out.println("E-mail: ");
		email = input.nextLine();
		System.out.println("Gênero Favorito: ");
		genFav = input.nextLine();
		System.out.println("Plano de Assinatura: ");
		planAss = input.nextLine();
		System.out.println("Quantidade de Filmes Vistos: ");
		qntdFilmesVistos = ler.nextInt();
		
		ClienteVIP cliente = new ClienteVIP(primNome, ultNome, data, cpf, numCel, email, genFav, qntdFilmesVistos, planAss);
		dadosCliente.add(cliente);
		
	}*/
	
	public void cadastrar(ClienteVIP cliente) {
		dadosCliente.add(cliente);
	}
	
	// Funcao para buscar um Cliente Especifico por CPF:
	public ClienteVIP buscar(String cpf) {
		for(int i = 0; i < dadosCliente.size(); i ++) 
			if(cpf.equals(dadosCliente.get(i).getCpf())) {
				System.out.println(dadosCliente.get(i).toString());
				return dadosCliente.get(i);
			}
		return null;
	}
	
	// Funcao para editar os dados de Cliente:
	
	/*public void editar(ClienteVIP cliente) {
		
		int num;
		
		do {
			System.out.println("Selecione a opção desejada:\n"
					+ "1-Editar o número de celular\n"
					+ "2-Editar o genêro favorito\n"
					+ "3-Editar o e-mail\n"
					+ "4-Editar a quantidade de filmes vistos\n"
					+ "5-Editar o plano de assinatura\n"
					+ "6-Sair\n");
			
			num = ler.nextInt();
			
			switch (num) {
				
				case 1: 
					System.out.println("Digite o novo número de celular do cliente:\n");
					cliente.setNumCelular(input.nextLine());
					break;
				case 2:
					System.out.println("Digite o novo gênero favorito do cliente:\n");
					cliente.setGeneroFavorito(input.nextLine());
					break;
				case 3:
					System.out.println("Digite o novo e-mail:\n");
					cliente.setEmail(input.nextLine());
					break;
				case 4:
					System.out.println("Digite a nova quantidade de filmes vistos do cliente:\n");
					cliente.setQntddFilmesVistos(ler.nextInt());
					break;
				case 5:
					System.out.println("Digite o novo plano de assinatura do cliente:\n");
					cliente.setPlanoAssinatura(input.nextLine());
					break;
				case 6:
					System.out.println("Retornando ao menu\n");
					break;
				default:
					System.out.println("Não foi escolhida nenhuma opção válida\n"
									   + "Por favor insira um número novamente");
					break;
			}
		} while (1 > num || num > 6);
			
	}*/
	
	/*public void deletar(ClienteVIP cliente) {
		
		dadosCliente.remove(dadosCliente.indexOf(cliente));
		
	}*/
	
	public void deletar(int pos) {
		dadosCliente.remove(dadosCliente.get(pos));
	}
	
	public String toString() {	
		return "Nome do cliente VIP: " + primeiroNome + " " + ultimoNome + "\n" 
			   + "Data de Nascimento: " + dataNascimento + "\n" + "CPF: " + cpf + "\n" 
			   + "Número de Celular: " + numCelular + "\n" + "E-mail:" + email + "\n" 
			   + "Gênero Favorito: " + generoFavorito + "\n" + "Quantidade de Filmes Vistos: "
			   + qntddFilmesVistos + "\n" + "Plano de Assinatura: " + planoAssinatura + "\n";
	}
	
	public void visualizar() {
		for(int i = 0; i < dadosCliente.size(); i ++) {
			System.out.println(dadosCliente.get(i).toString());
		}
	}
	
	public String[] visualizarNome() {
		String[] var = new String [1000];
		for(int i = 0; i < dadosCliente.size(); i ++) {
			var[i] = dadosCliente.get(i).getPrimeiroNome();
			//System.out.println(dadosCliente.get(i).getPrimeiroNome());
		}
		return var;
	}
	
	public String retornaPrimNome(int pos) {
			return dadosCliente.get(pos).getPrimeiroNome();
	}
	
	public String retornaData(int pos) {
		return dadosCliente.get(pos).getDataNascimento();
	}
	
	public String retornaUltNome(int pos) {
		return dadosCliente.get(pos).getUltimoNome();
	}
	
	public String retornaCPF(int pos) {
		return dadosCliente.get(pos).getCpf();
	}
	
	public String retornaNumCel(int pos) {
		return dadosCliente.get(pos).getNumCelular();
	}
	
	public String retornaEmail(int pos) {
		return dadosCliente.get(pos).getEmail();
	}
	
	public String retornaGenFav(int pos) {
		return dadosCliente.get(pos).getGeneroFavorito();
	}
	
	public int retornaQntddFilmesVistos(int pos) {
		return dadosCliente.get(pos).getQntddFilmesVistos();
	}
	
	public String retornaPlanoAss(int pos) {
		return dadosCliente.get(pos).getPlanoAssinatura();
	}
	
	// ------------ GETTERS AND SETTERS ------------ //
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGeneroFavorito() {
		return generoFavorito;
	}
	
	public void setGeneroFavorito(String generoFavorito) {
		this.generoFavorito = generoFavorito;
	}
	
	public int getQntddFilmesVistos() {
		return qntddFilmesVistos;
	}
	
	public void setQntddFilmesVistos(int qntddFilmesVistos) {
		this.qntddFilmesVistos = qntddFilmesVistos;
	}
	
	public String getPlanoAssinatura() {
		return planoAssinatura;
	}
	
	public void setPlanoAssinatura(String planoAssinatura) {
		this.planoAssinatura = planoAssinatura;
	}
		
	
}
