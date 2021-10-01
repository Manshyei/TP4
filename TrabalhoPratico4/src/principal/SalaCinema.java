package principal;
import java.util.*;
public class SalaCinema {
	
	// ----------------- ATRIBUTOS ----------------- //
	
	private String numSala;
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
	
	public SalaCinema(String numero_sala, String tipo_sala, int qtd_cadeiras, String formato_sala, int qtd_linhas, int qtd_colunas, boolean cadeira_vaga) {
		numSala = numero_sala;
		tipoSala = tipo_sala;
		qntddCadeiras = qtd_cadeiras;
		formato = formato_sala;
		qnddLinhasCadeiras = qtd_linhas;
		qnddColunasCadeiras = qtd_colunas;
		cadeiraVaga = cadeira_vaga; 
	}
	
	// ------------- DADOS PRÉ-CADASTRADOS ----------//
	Scanner input = new Scanner(System.in);	
	ArrayList<SalaCinema> dadosSala = new ArrayList<SalaCinema>();
	
	public void dadosPreCadastradosSala(){
		
		SalaCinema sala1 = new SalaCinema("Sala 1","3D",90,"Quadrado",15,6,true);
		SalaCinema sala2 = new SalaCinema("Sala 2","VIP",50,"Quadrado",25,5,false);
		SalaCinema sala3 = new SalaCinema("Sala 3","Normal",80,"Piramide",20,4,true);
		SalaCinema sala4 = new SalaCinema("Sala 4","Normal",100,"Quadrado",25,5,false);
		SalaCinema sala5 = new SalaCinema("Sala 5","Normal",100,"Quadrado",25,5,true);
		
		dadosSala.add(sala1);
		dadosSala.add(sala2);
		dadosSala.add(sala3);
		dadosSala.add(sala4);
		dadosSala.add(sala5);
		
	}
	
	// ------------------ METODOS ------------------ //

		// Funcao para cadastrar os dados da Sala de Cinema:

//			public void cadastrar() {
//				String tiposala, formato;
//				int numsala, qtdcadeiras,qtdlinhas,qtdcolunas;
//				boolean cadeiraVaga;
//
//				System.out.println("Formato da sala: ");
//				formato = input.nextLine();
//				System.out.println("Tipo da sala: ");
//				tiposala = input.nextLine();
//				System.out.println("Número da sala: ");
//				numsala = input.nextInt();
//				System.out.println("Quantidade de cadeiras: ");
//				qtdcadeiras = input.nextInt();
//				System.out.println("Quantidade de linhas: ");
//				qtdlinhas = input.nextInt();
//				System.out.println("Quantidade de colunas: ");
//				qtdcolunas = input.nextInt();
//				System.out.println("Há cadeiras vagas? ");
//				cadeiraVaga = input.nextBoolean();
//				
//				SalaCinema sala = new SalaCinema(numsala, tiposala, qtdcadeiras, formato, qtdlinhas, qtdcolunas, cadeiraVaga);
//				dadosSala.add(sala);
//
//			}
	
			public void cadastrar(SalaCinema sala) {
				dadosSala.add(sala);
			}
			
			public void cadastrarvazio() {
				SalaCinema sala = new SalaCinema("","", 0,"",0,0,false);
				dadosSala.add(sala);
			}
			
			public void produtoNaoEncontrado() {
				SalaCinema sala = new SalaCinema("Não foram encontrados resultados...","", 0,"",0,0,false);
				dadosSala.add(sala);
			}

			// Funcao para editar os dados da sala de Cinema:

//			public void editar(SalaCinema sala) {
//
//				int num;
//
//				do {
//					System.out.println("Selecione a opção desejada:\n"
//							+ "1-Editar o se existem ou não cadeiras vagas\n"
//							+ "2-Sair\n");
//							
//
//					num = input.nextInt();
//
//					switch (num) {
//
//						case 1: 
//							System.out.println("Existem cadeiras vagas? Digite 'true' ou 'false'\n");
//							sala.setCadeiraVaga(input.nextBoolean());
//							System.out.println("Alteração feita com sucesso\n");
//							break;
//						case 2:
//							System.out.println("Retornando ao menu...\n");
//							break;
//						default:
//							System.out.println("Não foi escolhida nenhuma opção válida\n"
//											   + "Por favor insira um número novamente");
//							break;
//					}
//				} while (1 > num || num > 2);
//
//			}
			
			public void editar(SalaCinema sala, int pos) {
				deletar(pos);
				cadastrar(sala);
				
//				dadosSala.get(pos).numSala = sala.numSala;
//				dadosSala.get(pos).tipoSala = sala.tipoSala;
//				dadosSala.get(pos).qntddCadeiras = sala.qntddCadeiras;
//				dadosSala.get(pos).formato = sala.formato;
//				dadosSala.get(pos).qnddLinhasCadeiras = sala.qnddLinhasCadeiras;
//				dadosSala.get(pos).qnddColunasCadeiras = sala.qnddColunasCadeiras;
//				dadosSala.get(pos).cadeiraVaga = sala.cadeiraVaga;
			}

//			public void deletar(SalaCinema sala) {
//
//				dadosSala.remove(dadosSala.indexOf(sala));
//
//			}
			
			public void deletar(int pos) {
				dadosSala.remove(dadosSala.get(pos));
			}

			public String toString() {	
				return "Número da sala: " + numSala + "\n" 
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
			
			public SalaCinema buscar(String salaNum) {
				for(int i = 0; i < dadosSala.size(); i ++) 
					if(salaNum.equals(dadosSala.get(i).getNumSala())) {
						return dadosSala.get(i);
					}
				return null;
			}
			
			public int retornaPos(String salaNum) {
				for(int i = 0; i < dadosSala.size(); i ++) 
					if(salaNum.equals(dadosSala.get(i).getNumSala())) {
						return i;
					}
				return -1;
			}
		
			public String[] visualizarNome() {
				String[] var = new String [1000];
				for(int i = 0; i < dadosSala.size(); i ++) {
					var[i] = String.valueOf(dadosSala.get(i).getNumSala());
					//System.out.println(dadosSala.get(i).getPrimeiroNome());
				}
				return var;
			}
			
		public String retornaNumSala(int pos) {
			return dadosSala.get(pos).getNumSala();
		}
		
		public String retornaTipoSala(int pos) {
			return dadosSala.get(pos).getTipoSala();
		}
		
		public int retornaQntddCadeiras(int pos) {
			return dadosSala.get(pos).getQntddCadeiras();
		}
		
		public String retornaFormato(int pos) {
			return dadosSala.get(pos).getFormato();
		}
		
		public int retornaQntddLinhasCadeiras(int pos) {
			return dadosSala.get(pos).getQnddLinhasCadeiras();
		}
		
		public int retornaQntddColunasCadeiras(int pos) {
			return dadosSala.get(pos).getQnddColunasCadeiras();
		} 
		
		public boolean retornaCadeiraVaga(int pos) {
			return dadosSala.get(pos).isCadeiraVaga();
		} 

	// ------------ GETTERS AND SETTERS ------------ //
	

	public String getNumSala() {
		return numSala;
	}

	public void setNumSala(String numSala) {
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