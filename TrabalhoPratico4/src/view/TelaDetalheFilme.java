package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import principal.*;

public class TelaDetalheFilme implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNomeFilme = new JLabel("Nome do Filme: ");
	private JTextField valorNomeFilme;
	
	private JLabel labelDurFilme = new JLabel("Duração do Filme: ");
	private JTextField valorDurFilme;
	
	private JLabel labelClasIndic = new JLabel("Classificação Indicativa: ");
	private JTextField valorClasIndic;
	
	private JLabel labelIdioma = new JLabel("Idioma do Filme: ");
	private JTextField valorIdioma;
	
	private JLabel labelSinopse = new JLabel("Sinopse: ");
	private JTextField valorSinopse;
	
	private JLabel labelGenero = new JLabel("Gênero: ");
	private JTextField valorGenero;
	
	private JLabel labelDataLanc = new JLabel("Data de Lançamento: ");
	private JTextField valorDataLanc;
	
	private JLabel labelSalaTrans = new JLabel("Sala de Transmissão: ");
	private JTextField valorSalaTrans;
	
	private JLabel labelHora = new JLabel("Horário de Exibição: ");
	private JTextField valorHora;
	
	private JLabel labelDataExib = new JLabel("Data de Exibição: ");
	private JTextField valorDataExib;
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[11];
	private int posicao;
	private int opcao;
	private String s;
	Filme filme = new Filme();
	//Programacao prog = new Programacao();
	
	public void inserirEditar(int op, 
		TelaFilme p, Filme f, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		filme = f;

		if (op == 1) s = "Cadastro do Filme";
		if (op == 2) s = "Detalhe do Filme";

		janela = new JFrame(s);

		if (op == 1) {
			valorNomeFilme = new JTextField(200);
			valorDurFilme = new JTextField(200);
			valorClasIndic = new JTextField(200);
			valorIdioma = new JTextField(200);
			valorSinopse = new JTextField(200);
			valorGenero = new JTextField(200);
			valorDataLanc = new JTextField(200);	
			valorSalaTrans = new JTextField(200);
			valorHora = new JTextField(200);
			valorDataExib = new JTextField(200);
			
		} else if (op == 2) { //Preenche dados com dados do sala clicado
			valorNomeFilme = new JTextField(filme.retornaNomeFilme(posicao), 200);
			valorDurFilme = new JTextField(String.valueOf(filme.retornaDuracao(posicao)),200);
			valorClasIndic = new JTextField(String.valueOf(filme.retornaClasIndic(posicao)), 200);
			valorIdioma = new JTextField(filme.retornaIdioma(posicao), 200);
			valorSinopse = new JTextField(filme.retornaSinopse(posicao), 200);
			valorGenero = new JTextField(filme.retornaGenero(posicao), 200);
			valorDataLanc = new JTextField(filme.retornaDataLanc(posicao), 200);	
			valorSalaTrans = new JTextField(String.valueOf(filme.retornaSalaTrans(posicao)), 200);
			valorHora = new JTextField(String.valueOf(filme.retornaHorario(posicao)), 200);
			valorDataExib = new JTextField(filme.retornaDataExib(posicao), 200);

		} 

		labelNomeFilme.setBounds(10, 10, 150, 25);
		valorNomeFilme.setBounds(145, 10, 180, 25);
		labelClasIndic.setBounds(10, 57, 150, 25);
		valorClasIndic.setBounds(145, 57, 180, 25);
		labelDurFilme.setBounds(10, 104, 180, 25);
		valorDurFilme.setBounds(145, 104, 180, 25);		
		labelIdioma.setBounds(10, 151, 150, 25);
		valorIdioma.setBounds(145, 151, 180, 25);
		labelSinopse.setBounds(10, 199, 150, 25);
		valorSinopse.setBounds(145, 199, 180, 25);
		labelGenero.setBounds(10, 246, 150, 25);
		valorGenero.setBounds(145, 246, 180, 25);
		labelDataLanc.setBounds(10, 293, 150, 25);
		valorDataLanc.setBounds(145, 293, 180, 25);
		labelSalaTrans.setBounds(10, 199, 150, 25);
		valorSalaTrans.setBounds(145, 199, 180, 25);
		labelHora.setBounds(10, 246, 150, 25);
		valorHora.setBounds(145, 246, 180, 25);
		labelDataExib.setBounds(10, 293, 150, 25);
		valorDataExib.setBounds(145, 293, 180, 25);

		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(330, 50, 150, 50);
			botaoExcluir.setBounds(330, 190, 150, 50);
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoExcluir.setFont(new Font("Arial", Font.BOLD, 18));
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
		}
		
		if (op == 1) {
			botaoSalvar.setBounds(330, 120, 150, 50);
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			this.janela.add(botaoSalvar);
		}

		this.janela.add(labelNomeFilme);
		this.janela.add(valorNomeFilme);
		this.janela.add(labelIdioma);
		this.janela.add(valorIdioma);
		this.janela.add(labelSinopse);
		this.janela.add(valorSinopse);
		this.janela.add(labelDurFilme);
		this.janela.add(valorDurFilme);
		this.janela.add(labelClasIndic);
		this.janela.add(valorClasIndic);
		this.janela.add(labelGenero);
		this.janela.add(valorGenero);
		this.janela.add(labelDataLanc);
		this.janela.add(valorDataLanc);
		this.janela.add(labelSalaTrans);
		this.janela.add(valorSalaTrans);
		this.janela.add(labelHora);
		this.janela.add(valorHora);
		this.janela.add(labelDataExib);
		this.janela.add(valorDataExib);

		this.janela.add(botaoSalvar);
		

		this.janela.setLayout(null);

		this.janela.setSize(500, 325);
		this.janela.setVisible(true);
		this.janela.setLocationRelativeTo(null);
		this.janela.setResizable(false);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {				
				novoDado[0] = valorNomeFilme.getText();
				novoDado[1] = valorIdioma.getText();
				novoDado[2] = valorSinopse.getText();
				novoDado[3] = valorDurFilme.getText();
				novoDado[4] = valorClasIndic.getText();
				novoDado[5] = valorGenero.getText();
				novoDado[6] = valorDataLanc.getText();
				novoDado[7] = valorSalaTrans.getText();
				novoDado[8] = valorHora.getText();
				novoDado[9] = valorDataExib.getText();

				if (opcao == 1) {
					Programacao novaprog = new Programacao(Integer.parseInt(novoDado[8]), novoDado[9]);
					
					Filme novoFilme = new Filme(novoDado[0], Integer.parseInt(novoDado[3]), 
							Integer.parseInt(novoDado[4]), novoDado[1], novoDado[5], 
							novoDado[2], novoDado[6], Integer.parseInt(novoDado[7]), novaprog);
					
					filme.cadastrar(novoFilme);
					
				} else if (opcao == 2) {
					Programacao novaprog = new Programacao(Integer.parseInt(novoDado[8]), novoDado[9]);
					
					Filme attFilme = new Filme(novoDado[0], Integer.parseInt(novoDado[3]), 
							Integer.parseInt(novoDado[4]), novoDado[1], novoDado[5], 
							novoDado[2], novoDado[6], Integer.parseInt(novoDado[7]), novaprog);
					filme.editar(attFilme, posicao);
				}
				mensagemSucessoCadastro();
				
		}

		if(src == botaoExcluir) {
			if (opcao == 2) {//exclui sala
				filme.deletar(posicao);
				mensagemSucessoExclusao();
			}
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, identidade, DDD e telefone não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAluno() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno está matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
