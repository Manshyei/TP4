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

public class TelaDetalheSala implements ActionListener {

	private JFrame janela;
	private JLabel labelNumSala = new JLabel("Número da Sala: ");
	private JTextField valorNumSala;
	private JLabel labelTipoSala = new JLabel("Tipo de Sala: ");
	private JTextField valorTipoSala;
	private JLabel labelQntddCadeiras = new JLabel("Número de Cadeiras: ");
	private JTextField valorQntddCadeiras;
	private JLabel labelFormSala = new JLabel("Formato da Sala: ");
	private JTextField valorFormSala;
	private JLabel labelQntddColunas = new JLabel("Colunas de cadeiras: ");
	private JTextField valorQntdColunas;
	private JLabel labelQntddLinhas = new JLabel("Linhas de cadeiras: ");
	private JTextField valorQntddLinhas;
	private JLabel labelCadeiraVaga = new JLabel("Cadeira Vaga: ");
	private JTextField valorCadeiraVaga;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoCancelar = new JButton("Cancelar");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[8];
	private int posicao;
	private int opcao;
	private String s;
	SalaCinema sala = new SalaCinema();
	
	public void criarTelaDetalheSala(int op, 
		TelaSala p, SalaCinema sla, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		sala = sla;

		if (op == 1) s = "Cadastro de Sala";
		if (op == 2) s = "Detalhe de Sala";

		janela = new JFrame(s);

		if (op == 1) {
			valorNumSala = new JTextField(200);
			valorTipoSala = new JTextField(200);
			valorQntddCadeiras = new JTextField(200);
			valorFormSala = new JTextField(200);
			valorQntdColunas = new JTextField(200);
			valorQntddLinhas = new JTextField(200);
			valorCadeiraVaga = new JTextField(200);	
			
		} else if (op == 2) { //Preenche dados com dados do sala clicado
			valorNumSala = new JTextField(sala.retornaNumSala(posicao), 200);
			valorTipoSala = new JTextField(sala.retornaTipoSala(posicao),200);
			valorQntddCadeiras = new JTextField(String.valueOf(sala.retornaQntddCadeiras(posicao)), 200);
			valorFormSala = new JTextField(sala.retornaFormato(posicao), 200);
			valorQntdColunas = new JTextField(String.valueOf(sala.retornaQntddColunasCadeiras(posicao)), 200);
			valorQntddLinhas = new JTextField(String.valueOf(sala.retornaQntddLinhasCadeiras(posicao)), 200);
			valorCadeiraVaga = new JTextField(String.valueOf(sala.retornaCadeiraVaga(posicao)), 200);	

		}

		labelNumSala.setBounds(10, 10, 150, 25);
		valorNumSala.setBounds(145, 10, 185, 25);
		labelQntddCadeiras.setBounds(10, 40, 150, 25);
		valorQntddCadeiras.setBounds(145, 40, 185, 25);
		labelTipoSala.setBounds(10, 70, 180, 25);
		valorTipoSala.setBounds(145, 70, 185, 25);		
		labelFormSala.setBounds(10, 100, 150, 25);
		valorFormSala.setBounds(145, 100, 185, 25);
		labelQntddColunas.setBounds(10, 130, 150, 25);
		valorQntdColunas.setBounds(145, 130, 185, 25);
		labelQntddLinhas.setBounds(10, 160, 150, 25);
		valorQntddLinhas.setBounds(145, 160, 185, 25);
		labelCadeiraVaga.setBounds(10, 190, 150, 25);
		valorCadeiraVaga.setBounds(145, 190, 185, 25);

		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(180, 198, 150, 50);
			botaoExcluir.setBounds(10, 198, 150, 50);
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoExcluir.setFont(new Font("Arial", Font.BOLD, 18));
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
		}
		
		if (op == 1) {
			botaoSalvar.setBounds(180, 198, 150, 50);
			botaoCancelar.setBounds(10, 198, 150, 50);
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
			this.janela.add(botaoSalvar);
		}

		this.janela.add(labelNumSala);
		this.janela.add(valorNumSala);
		this.janela.add(labelFormSala);
		this.janela.add(valorFormSala);
		this.janela.add(labelQntddColunas);
		this.janela.add(valorQntdColunas);
		this.janela.add(labelTipoSala);
		this.janela.add(valorTipoSala);
		this.janela.add(labelQntddCadeiras);
		this.janela.add(valorQntddCadeiras);
		this.janela.add(labelQntddLinhas);
		this.janela.add(valorQntddLinhas);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoCancelar);

		this.janela.setLayout(null);

		this.janela.setSize(365, 300);
		this.janela.setVisible(true);
		this.janela.setLocationRelativeTo(null);
		this.janela.setResizable(false);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoCancelar.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {				
				novoDado[0] = valorNumSala.getText();
				novoDado[1] = valorFormSala.getText();
				novoDado[2] = valorQntdColunas.getText();
				novoDado[3] = valorTipoSala.getText();
				novoDado[4] = valorQntddCadeiras.getText();
				novoDado[5] = valorQntddLinhas.getText();
				novoDado[6] = valorCadeiraVaga.getText();

				if (opcao == 1) {
					SalaCinema novasala = new SalaCinema(novoDado[0], novoDado[3], 
							Integer.parseInt(novoDado[4]), novoDado[1], Integer.parseInt(novoDado[5]), 
							Integer.parseInt(novoDado[2]), Boolean.valueOf(novoDado[6]));
					
					sala.cadastrar(novasala);
					
				} else if (opcao == 2) {
					SalaCinema attsala = new SalaCinema(novoDado[0], novoDado[3], 
							Integer.parseInt(novoDado[4]), novoDado[1], Integer.parseInt(novoDado[5]), 
							Integer.parseInt(novoDado[2]), Boolean.valueOf(novoDado[6]));
					sala.editar(attsala, posicao);
				}
				mensagemSucessoCadastro();
				
		}

		if(src == botaoExcluir) {
			if (opcao == 2) {//exclui sala
				sala.deletar(posicao);
				mensagemSucessoExclusao();
			}
		}
		
		if(src == botaoCancelar) janela.dispose();
		
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
