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
	
	/// Declara��o dos componentes da GUI
	private JFrame janela;
	private JLabel labelNomeFilme = new JLabel("Nome do Filme: ");
	private JTextField valorNomeFilme;
	private JLabel labelDurFilme = new JLabel("Dura��o do Filme: ");
	private JTextField valorDurFilme;
	private JLabel labelClasIndic = new JLabel("Classifica��o Indicativa: ");
	private JTextField valorClasIndic;
	private JLabel labelIdioma = new JLabel("Idioma do Filme: ");
	private JTextField valorIdioma;
	private JLabel labelSinopse = new JLabel("Sinopse: ");
	private JTextField valorSinopse;
	private JLabel labelGenero = new JLabel("G�nero: ");
	private JTextField valorGenero;
	private JLabel labelDataLanc = new JLabel("Data de Lan�amento: ");
	private JTextField valorDataLanc;
	private JLabel labelSalaTrans = new JLabel("Sala de Transmiss�o: ");
	private JTextField valorSalaTrans;
	private JLabel labelHora = new JLabel("Hor�rio de Exibi��o: ");
	private JTextField valorHora;
	private JLabel labelDataExib = new JLabel("Data de Exibi��o: ");
	private JTextField valorDataExib;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoCancelar = new JButton("Cancelar");

	/// Declara��o de dados a serem manipulados
	private String[] novoDado = new String[11];
	private int posicao;
	private int opcao;
	private String s;
	Filme filme = new Filme();
	
	
	public void criarTelaDetalheFilme(int op, 
		TelaFilme p, Filme f, int pos) {
		
		this.opcao = op;
		this.posicao = pos;
		filme = f;

		/* "op" � uma vari�vel que define se o programa est� trabalhando
		com o cadastro de filmes, se op = 1, ou com altera��o/exclus�o
		de filmes, se op = 2.                                           */ 
		
		if (op == 1) s = "Cadastro do Filme";
		if (op == 2) s = "Detalhes do Filme";

		/// Cria um container
		janela = new JFrame(s);

		if (op == 1) {
			/// Cria os componentes do container
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
			
		} else if (op == 2) { 
			/// Cria os componentes do container
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
		
		/// Realiza o posicionamento dos componentes
		labelNomeFilme.setBounds(10, 10, 150, 25);
		valorNomeFilme.setBounds(145, 10, 180, 25);
		labelClasIndic.setBounds(10, 40, 150, 25);
		valorClasIndic.setBounds(145, 40, 180, 25);
		labelDurFilme.setBounds(10, 70, 180, 25);
		valorDurFilme.setBounds(145, 70, 180, 25);		
		labelIdioma.setBounds(10, 100, 150, 25);
		valorIdioma.setBounds(145, 100, 180, 25);
		labelSinopse.setBounds(10, 130, 150, 25);
		valorSinopse.setBounds(145, 130, 180, 25);
		labelGenero.setBounds(10, 160, 150, 25);
		valorGenero.setBounds(145, 160, 180, 25);
		labelDataLanc.setBounds(10, 190, 150, 25);
		valorDataLanc.setBounds(145, 190, 180, 25);
		labelSalaTrans.setBounds(10, 220, 150, 25);
		valorSalaTrans.setBounds(145, 220, 180, 25);
		labelHora.setBounds(10, 250, 150, 25);
		valorHora.setBounds(145, 250, 180, 25);
		labelDataExib.setBounds(10, 280, 150, 25);
		valorDataExib.setBounds(145, 280, 180, 25);

		/// Caso de altera��o/remo��o
		if (op == 2) {
			
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(175, 320, 150, 50);
			botaoExcluir.setBounds(10, 320, 150, 50);
			
			/// Realiza a sele��o de fontes para os bot�es "salvar" e "excluir"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoExcluir.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca os componentes exclusivos no container
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
		}
		
		/// Caso de cadastramento
		if (op == 1) {
			/// Realiza o posicionamento dos componentes exclusivos.
			botaoSalvar.setBounds(175, 320, 150, 50);
			botaoCancelar.setBounds(10, 320, 150, 50);
			
			/// Realiza a sele��o de fontes para os bot�es "salvar" e "cancelar"
			botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
			botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
			
			/// Coloca os componentes exclusivos no container
			this.janela.add(botaoSalvar);
			this.janela.add(botaoCancelar);
		}

		/// Coloca os componentes no container
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

		/// Dados do container
		this.janela.setSize(365, 420);
		this.janela.setVisible(true);
		this.janela.setLocationRelativeTo(null);
		this.janela.setResizable(false);

		/// Detec��o de eventos
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoCancelar.addActionListener(this);
	}

	/// Detec��o de eventos relacionados aos dados do filme
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

				/// Caso de cadastramento
				if (opcao == 1) {	
					Filme novoFilme = new Filme(novoDado[0], Integer.parseInt(novoDado[3]), 
							Integer.parseInt(novoDado[4]), novoDado[1], novoDado[5], 
							novoDado[2], novoDado[6], Integer.parseInt(novoDado[7]), 
							Integer.parseInt(novoDado[8]), novoDado[9]);
					
					filme.cadastrar(novoFilme);
				}
				
				/// Caso de altera��o/remo��o
				else if (opcao == 2) {
					Filme attFilme = new Filme(novoDado[0], Integer.parseInt(novoDado[3]), 
							Integer.parseInt(novoDado[4]), novoDado[1], novoDado[5], 
							novoDado[2], novoDado[6], Integer.parseInt(novoDado[7]), 
							Integer.parseInt(novoDado[8]), novoDado[9]);
					filme.editar(attFilme, posicao);
				}
				mensagemSucessoCadastro();
				
		}

		/// Exclui o filme
		if(src == botaoExcluir) {
			if (opcao == 2) {
				filme.deletar(posicao);
				mensagemSucessoExclusao();
			}
		}
		
		/// Cancela o cadastramento e fecha a janela
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

}