package principal;
import java.util.*;
public class SalaCinema {
	
	// ----------------- ATRIBUTOS ----------------- //
	
	private int numSala;
	private String tipoSala;
	private int qntddCadeiras;
	private String formato;
	private int qnddLinhasCadeiras;
	private int qnddColunasCadeiras;
	private boolean cadeiraVaga;
	private Ingresso ingresso[];
	
	public SalaCinema(){
		super();
	}
	
	// ---------------- CONSTRUTOR ---------------- //
	
	public SalaCinema(int numero_sala, String tipo_sala, int qtd_cadeiras, String formato_sala, int qtd_linhas, int qtd_colunas, boolean cadeira_vaga) {
		numSala = numero_sala;
		tipoSala = tipo_sala;
		qntddCadeiras = qtd_cadeiras;
		formato = formato_sala;
		qnddLinhasCadeiras = qtd_linhas;
		qnddColunasCadeiras = qtd_colunas;
		cadeiraVaga = cadeira_vaga; 
	}
	
	// ------------- DADOS PR�-CADASTRADOS ----------//
	Scanner input = new Scanner(System.in);	
	ArrayList<SalaCinema> dadosSala = new ArrayList<SalaCinema>();
	
	public void dadosPreCadastradosSala(){
		
		SalaCinema sala1 = new SalaCinema(1,"3D",90,"Quadrado",15,6,true);
		SalaCinema sala2 = new SalaCinema(2,"VIP",50,"Quadrado",25,5,false);
		SalaCinema sala3 = new SalaCinema(3,"Normal",80,"Piramide",20,4,true);
		SalaCinema sala4 = new SalaCinema(4,"Normal",100,"Quadrado",25,5,false);
		SalaCinema sala5 = new SalaCinema(5,"Normal",100,"Quadrado",25,5,true);
		
		dadosSala.add(sala1);
		dadosSala.add(sala2);
		dadosSala.add(sala3);
		dadosSala.add(sala4);
		dadosSala.add(sala5);
		
	}
	
	// ------------------ METODOS ------------------ //

		// Funcao para cadastrar os dados da Sala de Cinema:

			public void cadastrar() {
				String tiposala, formato;
				int numsala, qtdcadeiras,qtdlinhas,qtdcolunas;
				boolean cadeiraVaga;

				System.out.println("Formato da sala: ");
				formato = input.nextLine();
				System.out.println("Tipo da sala: ");
				tiposala = input.nextLine();
				System.out.println("N�mero da sala: ");
				numsala = input.nextInt();
				System.out.println("Quantidade de cadeiras: ");
				qtdcadeiras = input.nextInt();
				System.out.println("Quantidade de linhas: ");
				qtdlinhas = input.nextInt();
				System.out.println("Quantidade de colunas: ");
				qtdcolunas = input.nextInt();
				System.out.println("H� cadeiras vagas? ");
				cadeiraVaga = input.nextBoolean();
				
				SalaCinema sala = new SalaCinema(numsala, tiposala, qtdcadeiras, formato, qtdlinhas, qtdcolunas, cadeiraVaga);
				dadosSala.add(sala);

			}

			// Funcao para editar os dados da sala de Cinema:

			public void editar(SalaCinema sala) {

				int num;

				do {
					System.out.println("Selecione a op��o desejada:\n"
							+ "1-Editar o se existem ou n�o cadeiras vagas\n"
							+ "2-Sair\n");
							

					num = input.nextInt();

					switch (num) {

						case 1: 
							System.out.println("Existem cadeiras vagas? Digite 'true' ou 'false'\n");
							sala.setCadeiraVaga(input.nextBoolean());
							System.out.println("Altera��o feita com sucesso\n");
							break;
						case 2:
							System.out.println("Retornando ao menu...\n");
							break;
						default:
							System.out.println("N�o foi escolhida nenhuma op��o v�lida\n"
											   + "Por favor insira um n�mero novamente");
							break;
					}
				} while (1 > num || num > 2);

			}

			public void deletar(SalaCinema sala) {

				dadosSala.remove(dadosSala.indexOf(sala));

			}

			public String toString() {	
				return "N�mero da sala: " + numSala + "\n" 
					   + "Tipo da sala: " + tipoSala + "\n" 
					   + "Quantidade de cadeiras: " + qntddCadeiras + "\n" 
					   + "Formato: " + formato + "\n"
					   + "Quantidade de linhas: " + qnddLinhasCadeiras + "\n"
					   + "Quantidade de colunas: " + qnddColunasCadeiras + "\n"
					   + "Cadeiras vagas: " + cadeiraVaga + "\n";
					  
			}

			public void visualizar() {
				System.out.println(dadosSala.size());
				for(int i = 0; i < dadosSala.size(); i ++) {
					System.out.println(dadosSala.get(i).toString());
				}
			}
			
			public SalaCinema buscar(int numSala) {
				for(int i = 0; i < dadosSala.size(); i ++) 
					if(numSala == (dadosSala.get(i).getNumSala())) {
						System.out.println(dadosSala.get(i).toString());
						return dadosSala.get(i);
					}
				return null;
			}

	// ------------ GETTERS AND SETTERS ------------ //
	

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getQntddCadeiras() {
		return qntddCadeiras;
	}

	public void setQntddCadeiras(int qntddCadeiras) {
		this.qntddCadeiras = qntddCadeiras;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getQnddLinhasCadeiras() {
		return qnddLinhasCadeiras;
	}

	public void setQnddLinhasCadeiras(int qnddLinhasCadeiras) {
		this.qnddLinhasCadeiras = qnddLinhasCadeiras;
	}

	public int getQnddColunasCadeiras() {
		return qnddColunasCadeiras;
	}

	public void setQnddColunasCadeiras(int qnddColunasCadeiras) {
		this.qnddColunasCadeiras = qnddColunasCadeiras;
	}

	public boolean isCadeiraVaga() {
		return cadeiraVaga;
	}

	public void setCadeiraVaga(boolean cadeiraVaga) {
		this.cadeiraVaga = cadeiraVaga;
	}

}