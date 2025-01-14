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

public class TelaDetalheIngresso implements ActionListener {
	
	/// Declara��o dos componentes da GUI
	private JFrame janela;
	private JLabel labelForPag = new JLabel("Forma de Pagamento: ");
	private JTextField valorForPag;
	private JLabel labelPreco = new JLabel("Pre�o: ");
	private JTextField valorPreco;
	private JLabel labelRecibo = new JLabel("Recibo: "); 
	private JTextField valorRecibo;
	private JLabel labelTipoIngresso = new JLabel("Tipo de Ingresso: ");
	private JTextField valorTipoIngresso;
	private JLabel labelNumSala = new JLabel("N�mero da Sala: ");
	private JTextField valorNumSala;
	private JLabel labelTipoSala = new JLabel("Tipo da Sala: ");
	private JTextField valorTipoSala;
	private JLabel labelNumCadeira = new JLabel("N�mero da Cadeira: ");
	private JTextField valorNumCadeira;
	private JLabel labelLetraCadeira = new JLabel("Letra da Cadeira: ");
	private JTextField valorLetraCadeira;
	private JLabel labelNomeFilme = new JLabel("Nome do Filme: ");
	private JTextField valorNomeFilme;
	private JLabel labelIdioma = new JLabel("Idioma do Filme: ");
	private JTextField valorIdioma;
	private JLabel labelHora = new JLabel("Hor�rio do Filme: ");
	private JTextField valorHora;
	private JLabel labelData = new JLabel("Data do Filme: ");
	private JTextField valorData;
	private JButton botaoCancelar = new JButton("Cancelar");
	private JButton botaoSalvar = new JButton("Salvar");
	
	/// Declara��o de dados a serem manipulados
	private String[] novoDado = new String[13];
	VendaIngresso venda = new VendaIngresso();
	
	public void criarTelaDetalheIngresso(TelaIngresso p, VendaIngresso vi) {
		
		venda = vi;

		/// Cria um container e seus componentes
		janela = new JFrame("Venda de Ingresso");
		valorForPag = new JTextField(200);
		valorPreco = new JTextField(200);
		valorRecibo = new JTextField(200);
		valorTipoIngresso = new JTextField(200);
		valorNumSala = new JTextField(200);
		valorTipoSala = new JTextField(200);
		valorNumCadeira = new JTextField(200);	
		valorLetraCadeira = new JTextField(200);
		valorNomeFilme = new JTextField(200);
		valorIdioma = new JTextField(200);
		valorHora = new JTextField(200);
		valorData = new JTextField(200);

		/// Realiza o posicionamento dos componentes
		labelForPag.setBounds(10, 10, 150, 25);
		valorForPag.setBounds(145, 10, 185, 25);
		labelRecibo.setBounds(10, 40, 150, 25);
		valorRecibo.setBounds(145, 40, 185, 25);
		labelPreco.setBounds(10, 70, 180, 25);
		valorPreco.setBounds(145, 70, 185, 25);		
		labelTipoIngresso.setBounds(10, 100, 150, 25);
		valorTipoIngresso.setBounds(145, 100, 185, 25);
		labelNumSala.setBounds(10, 130, 150, 25);
		valorNumSala.setBounds(145, 130, 185, 25);
		labelTipoSala.setBounds(10, 160, 150, 25);
		valorTipoSala.setBounds(145, 160, 185, 25);
		labelNumCadeira.setBounds(10, 190, 150, 25);
		valorNumCadeira.setBounds(145, 190, 185, 25);
		labelLetraCadeira.setBounds(10, 220, 180, 25);
		valorLetraCadeira.setBounds(145, 220, 185, 25);		
		labelNomeFilme.setBounds(10, 250, 150, 25);
		valorNomeFilme.setBounds(145, 250, 185, 25);
		labelIdioma.setBounds(10, 280, 150, 25);
		valorIdioma.setBounds(145, 280, 185, 25);
		labelHora.setBounds(10, 310, 150, 25);
		valorHora.setBounds(145, 310, 185, 25);
		labelData.setBounds(10, 340, 150, 25);
		valorData.setBounds(145, 340, 185, 25);
		botaoSalvar.setBounds(180, 375, 150, 50);
		botaoCancelar.setBounds(10, 375, 150, 50);
		
		/// Realiza a sele��o de fontes para os bot�es "salvar" e "cancelar"
		botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));
		botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));
		
		/// Coloca os componentes no container
		this.janela.add(botaoCancelar);
		this.janela.add(botaoSalvar);
		this.janela.add(labelForPag);
		this.janela.add(valorForPag);
		this.janela.add(labelTipoIngresso);
		this.janela.add(valorTipoIngresso);
		this.janela.add(labelNumSala);
		this.janela.add(valorNumSala);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelRecibo);
		this.janela.add(valorRecibo);
		this.janela.add(labelTipoSala);
		this.janela.add(valorTipoSala);
		this.janela.add(labelNumCadeira);
		this.janela.add(valorNumCadeira);
		this.janela.add(labelLetraCadeira);
		this.janela.add(valorLetraCadeira);
		this.janela.add(labelNomeFilme);
		this.janela.add(valorNomeFilme);
		this.janela.add(labelIdioma);
		this.janela.add(valorIdioma);
		this.janela.add(labelHora);
		this.janela.add(valorHora);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		/// Dados do container
		this.janela.setSize(365, 480);
		this.janela.setVisible(true);
		this.janela.setLocationRelativeTo(null);
		this.janela.setResizable(false);

		/// Detec��o de eventos
		botaoSalvar.addActionListener(this);
		botaoCancelar.addActionListener(this);
	}

	/// Detec��o de eventos relacionados aos dados do ingresso
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {				
				novoDado[0] = valorForPag.getText();
				novoDado[1] = valorTipoIngresso.getText();
				novoDado[2] = valorNumSala.getText();
				novoDado[3] = valorPreco.getText();
				novoDado[4] = valorRecibo.getText();
				novoDado[5] = valorTipoSala.getText();
				novoDado[6] = valorNumCadeira.getText();
				novoDado[7] = valorLetraCadeira.getText();
				novoDado[8] = valorNomeFilme.getText();
				novoDado[9] = valorIdioma.getText();
				novoDado[10] = valorHora.getText();
				novoDado[11] = valorData.getText();

				Ingresso novoIngresso = new Ingresso(novoDado[1], Integer.parseInt(novoDado[2]), novoDado[5], 
						Integer.parseInt(novoDado[6]), novoDado[6].charAt(0), novoDado[8], novoDado[9], 
						Integer.parseInt(novoDado[10]), novoDado[11]);
				
				VendaIngresso novavenda = new VendaIngresso(novoDado[0], Double.parseDouble(novoDado[3]), Integer.parseInt(novoDado[4]), novoIngresso);
				
				venda.cadastrar(novavenda);
					
				mensagemSucessoCadastro();
				
		}

		/// Cancela a compra do ingresso e fecha a janela
		if(src == botaoCancelar) {
				janela.dispose();
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!\n"
				+ "O pre�o do pedido foi de " + novoDado[3] + ",00 R$.", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

}