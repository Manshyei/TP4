package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import principal.*;

public class TelaDetalhePessoa implements ActionListener {

	private JFrame janela;
	private JLabel labelPrimNome = new JLabel("Primeiro Nome: ");
	private JTextField valorPrimNome;
	private JLabel labelUltNome = new JLabel("Último Nome: ");
	private JTextField valorUltNome;
	private JLabel labelData = new JLabel("Data: ");
	private JTextField valorData;
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelNumCel = new JLabel("Número de Celular: ");
	private JTextField valorNumCel;
	private JLabel labelEmail = new JLabel("e-mail: ");
	private JTextField valorEmail;
	private JLabel labelGenFav = new JLabel("Gênero Favorito: ");
	private JTextField valorGenFav;
	private JLabel labelQntddFilmesVistos = new JLabel("Filmes Vistos: ");
	private JTextField valorQntddFilmesVistos;
	private JLabel labelPlanoAss = new JLabel("Plano de Assinatura: ");
	private JTextField valorPlanoAss;
	private JLabel labelFuncao = new JLabel("Função: ");
	private JTextField valorFuncao;
	private JLabel labelEndereco = new JLabel("Endereço: ");
	private JTextField valorEndereco;
	private JLabel labelSalario = new JLabel("Salário: ");
	private JTextField valorSalario;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoCancelar = new JButton("Cancelar");
	private String[] novoDado = new String[12];
	private int posicao;
	private int opcao;
	private String s;
	ClienteVIP cliente = new ClienteVIP();
	Funcionario funcionario = new Funcionario();
	
	public void inserirEditar(int op, 
		TelaPessoa p, ClienteVIP c, Funcionario f, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		cliente = c;
		funcionario = f;

		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Cadastro de Funcionário";
		if (op == 3) s = "Detalhe de Cliente";
		if (op == 4) s = "Detalhe de Funcionário";

		janela = new JFrame(s);

		if (op == 1) {
			valorPrimNome = new JTextField(200);
			valorUltNome = new JTextField(200);
			valorData = new JTextField(200);
			valorCPF = new JTextField(200);
			valorNumCel = new JTextField(200);
			valorEmail = new JTextField(200);
			valorGenFav = new JTextField(200);	
			valorQntddFilmesVistos = new JTextField(200);
			valorPlanoAss = new JTextField(200);
			valorFuncao = new JTextField(200);	
			valorEndereco = new JTextField(200);
			valorSalario = new JTextField(200);
			
		} else if (op == 2) {
			valorPrimNome = new JTextField(200);
			valorUltNome = new JTextField(200);
			valorData = new JTextField(200);
			valorCPF = new JTextField(200);
			valorNumCel = new JTextField(200);
			valorEmail = new JTextField(200);
			valorGenFav = new JTextField(200);	
			valorQntddFilmesVistos = new JTextField(200);
			valorPlanoAss = new JTextField(200);
			valorFuncao = new JTextField(200);	
			valorEndereco = new JTextField(200);
			valorSalario = new JTextField(200);
			
		} else if (op == 3) { //Preenche dados com dados do cliente clicado
			valorPrimNome = new JTextField(cliente.retornaPrimNome(posicao), 200);
			valorUltNome = new JTextField(cliente.retornaUltNome(posicao),200);
			valorData = new JTextField(cliente.retornaData(posicao), 200);
			valorCPF = new JTextField(cliente.retornaCPF(posicao), 200);
			valorNumCel = new JTextField(cliente.retornaNumCel(posicao), 200);
			valorEmail = new JTextField(cliente.retornaEmail(posicao), 200);
			valorGenFav = new JTextField(cliente.retornaGenFav(posicao), 200);	
			valorQntddFilmesVistos = new JTextField(String.valueOf
					(cliente.retornaQntddFilmesVistos(posicao)), 200);
			valorPlanoAss = new JTextField(cliente.retornaPlanoAss(posicao), 200);
			valorFuncao = new JTextField(200);	
			valorEndereco = new JTextField(200);
			valorSalario = new JTextField(200);

		} else if (op == 4) { //Preenche dados com dados do funcionário clicado 
			valorPrimNome = new JTextField(funcionario.retornaPrimNome(posicao), 200);
			valorUltNome = new JTextField(funcionario.retornaUltNome(posicao),200);
			valorData = new JTextField(funcionario.retornaData(posicao), 200);
			valorCPF = new JTextField(funcionario.retornaCPF(posicao), 200);
			valorNumCel = new JTextField(funcionario.retornaNumCel(posicao), 200);
			valorEmail = new JTextField(funcionario.retornaEmail(posicao), 200);
			valorFuncao = new JTextField(funcionario.retornaFuncao(posicao), 200);	
			valorEndereco = new JTextField(funcionario.retornaEndereco(posicao), 200);
			valorSalario = new JTextField(String.valueOf
					(funcionario.retornaSalario(posicao)), 200);
			valorGenFav = new JTextField( 200);	
			valorQntddFilmesVistos = new JTextField(200);
			valorPlanoAss = new JTextField(200);

		} 

		labelPrimNome.setBounds(10, 10, 150, 25);
		valorPrimNome.setBounds(145, 10, 185, 25);
		labelData.setBounds(10, 40, 150, 25);
		valorData.setBounds(145, 40, 185, 25);
		labelUltNome.setBounds(10, 70, 180, 25);
		valorUltNome.setBounds(145, 70, 185, 25);		
		labelCPF.setBounds(10, 100, 150, 25);
		valorCPF.setBounds(145, 100, 185, 25);
		labelNumCel.setBounds(10, 130, 150, 25);
		valorNumCel.setBounds(145, 130, 185, 25);
		labelEmail.setBounds(10, 160, 150, 25);
		valorEmail.setBounds(145, 160, 185, 25);
		labelGenFav.setBounds(10, 190, 150, 25);
		valorGenFav.setBounds(145, 190, 185, 25);
		labelQntddFilmesVistos.setBounds(10, 220, 180, 25);
		valorQntddFilmesVistos.setBounds(145, 220, 185, 25);		
		labelPlanoAss.setBounds(10, 250, 150, 25);
		valorPlanoAss.setBounds(145, 250, 185, 25);
		labelFuncao.setBounds(10, 190, 150, 25);
		valorFuncao.setBounds(145, 190, 185, 25);
		labelEndereco.setBounds(10, 220, 150, 25);
		valorEndereco.setBounds(145, 220, 185, 25);
		labelSalario.setBounds(10, 250, 150, 25);
		valorSalario.setBounds(145, 250, 185, 25);

		//Coloca os campos relacionados a endereco se aluno
		if (op == 1 || op == 3 ) {
			this.janela.add(labelGenFav);
			this.janela.add(valorGenFav);
			this.janela.add(labelQntddFilmesVistos);
			this.janela.add(valorQntddFilmesVistos);
			this.janela.add(labelPlanoAss);
			this.janela.add(valorPlanoAss);

		}

		//Coloca campos relacionados a valor hora/aula se professor
		if (op == 2 || op == 4) {
			this.janela.add(labelFuncao);
			this.janela.add(valorFuncao);
			this.janela.add(labelEndereco);
			this.janela.add(valorEndereco);
			this.janela.add(labelSalario);
			this.janela.add(valorSalario);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(180, 290, 150, 50);
			botaoExcluir.setBounds(10, 290, 150, 50);
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoExcluir.setFont(new Font("Arial", Font.BOLD, 18));
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
		}
		
		if (op == 1 || op  == 2) {
			botaoSalvar.setBounds(180, 290, 150, 50);
			botaoCancelar.setBounds(10, 290, 150, 50);
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
			this.janela.add(botaoSalvar);
		}

		this.janela.add(labelPrimNome);
		this.janela.add(valorPrimNome);
		this.janela.add(labelCPF);
		this.janela.add(valorCPF);
		this.janela.add(labelNumCel);
		this.janela.add(valorNumCel);
		this.janela.add(labelUltNome);
		this.janela.add(valorUltNome);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(labelEmail);
		this.janela.add(valorEmail);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoCancelar);

		this.janela.setLayout(null);

		this.janela.setSize(365, 390);
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
				novoDado[0] = valorPrimNome.getText();
				novoDado[1] = valorCPF.getText();
				novoDado[2] = valorNumCel.getText();
				novoDado[3] = valorUltNome.getText();
				novoDado[4] = valorData.getText();
				novoDado[5] = valorEmail.getText();
				novoDado[6] = valorGenFav.getText();
				novoDado[7] = valorQntddFilmesVistos.getText();
				novoDado[8] = valorPlanoAss.getText();
				novoDado[9] = valorFuncao.getText();
				novoDado[10] = valorEndereco.getText();
				novoDado[11] = valorSalario.getText();

				if (opcao == 1) {
					ClienteVIP novoCliente = new ClienteVIP(novoDado[0], novoDado[3], 
							novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[6], 
							Integer.parseInt(novoDado[7]), novoDado[8]);
					cliente.cadastrar(novoCliente);
					
				} else if (opcao == 2){
					Funcionario novoFuncionario = new Funcionario(novoDado[0], novoDado[3], 
							novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[9], 
							novoDado[10], Double.parseDouble(novoDado[11]));
					funcionario.cadastrar(novoFuncionario);
					
				} else if (opcao == 3) {
					ClienteVIP attCliente = new ClienteVIP(novoDado[0], novoDado[3], 
							novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[6], 
							Integer.parseInt(novoDado[7]), novoDado[8]);
					cliente.editar(attCliente, posicao);
					
				} else if (opcao == 4) {
					Funcionario attFuncionario = new Funcionario(novoDado[0], novoDado[3], 
							novoDado[4], novoDado[1], novoDado[2], novoDado[5], novoDado[9], 
							novoDado[10], Double.parseDouble(novoDado[11]));
					funcionario.editar(attFuncionario, posicao);
					
				}
				mensagemSucessoCadastro();

			
		}

		if(src == botaoExcluir) {

			if (opcao == 3) {//exclui cliente
				cliente.deletar(posicao);
				mensagemSucessoExclusao();
			}
				
			if (opcao == 4){ //exclui professor
				funcionario.deletar(posicao);
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
	
	public void mensagemErroExclusaoProf() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o professor está responsável\n"
				+ "por alguma disciplina. Se sim, substitua\n "
				+ "o professor e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
