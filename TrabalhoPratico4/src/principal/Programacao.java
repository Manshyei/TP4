package principal;

import java.util.*;

public class Programacao {

	// ----------------- ATRIBUTOS ----------------- //

	private int horario;
	private String dataExibicao;
	
	
	// ---------------- CONSTRUTOR ---------------- //
	
	public Programacao(int hora, String data_exibicao) {
		horario = hora;
		dataExibicao = data_exibicao;
	}
	
	// ---------------- METODOS ---------------- //
	
	// Funcionalidades:
	
	ArrayList<Programacao> dadosProg = new ArrayList<Programacao>();
	Scanner scan = new Scanner(System.in);
	
	// Pré-cadastro de dados do cliente:
	
	public void dadosPreCadastradosProgramacao() {
		Programacao prog1 = new Programacao(14,"15/03/2021");
		Programacao prog2 = new Programacao(15,"23/08/2020");
		Programacao prog3 = new Programacao(12,"19/10/2021");
		Programacao prog4 = new Programacao(22,"04/12/2021");
		Programacao prog5 = new Programacao(16,"16/12/2021");
		
		dadosProg.add(prog1);
		dadosProg.add(prog2);
		dadosProg.add(prog3);
		dadosProg.add(prog4);
		dadosProg.add(prog5);
	}
	
	public int retornaHora(int pos) {
		return dadosProg.get(pos).getHorario();
	}
	
	public String retornaDataExib(int pos) {
		return dadosProg.get(pos).getDataExibicao();
	}
	
	// ------------ GETTERS AND SETTERS ------------ //
	
	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public String getDataExibicao() {
		return dataExibicao;
	}

	public void setDataExibicao(String dataExibicao) {
		this.dataExibicao = dataExibicao;
	}
	
}