package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaFilme implements ActionListener, ListSelectionListener {	
	
	/// Declara��o dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilme;
	private JButton refreshFilme;
	private JButton voltar;
	private JButton pesquisa;
	private JTextField campoBusca;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	
	/// Declara��o de JList para armazenamento de dados
	private JList<String> listaFilmesCadastrados;
	
	/// Declara��o de dados a serem manipulados
	private String[] listaFilmes = new String[1000];
	private String nome;
	private int p;
	Filme filme = new Filme();
	
	public void criaTelaFilme(Filme f){
		filme = f;
		
		listaFilmes = filme.visualizarNome();
		listaFilmesCadastrados = new JList<String>(listaFilmes);
		
		/// Cria um container e seus componentes
		janela = new JFrame("Filmes");
		titulo = new JLabel("Filmes Cadastrados");
		cadastroFilme = new JButton("Cadastrar");
		refreshFilme = new JButton("Atualizar Lista");
		voltar = new JButton("Voltar");
		pesquisa = new JButton("Buscar");
		campoBusca = new JTextField(200);
		
		/// Realiza a sele��o de fontes para cada um dos componentes
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		cadastroFilme.setFont(new Font("Arial", Font.BOLD, 17));
		refreshFilme.setFont(new Font("Arial", Font.BOLD, 17));
		voltar.setFont(new Font("Arial", Font.BOLD, 17));
		pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		listaFilmesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
		
	
		/// Realiza o posicionamento dos componentes
		titulo.setBounds(90, 15, 350, 30);
		cadastroFilme.setBounds(166, 280, 150, 50);
		refreshFilme.setBounds(326, 280, 150, 50);
		voltar.setBounds(7, 280, 150, 50);
		panel.setBounds(40, 110, 400, 140);
		pesquisa.setBounds(290, 70, 100, 25);
		campoBusca.setBounds(90, 70, 185, 25);
		ScrollPane.setViewportView(listaFilmesCadastrados);
		listaFilmesCadastrados.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
	
		janela.setLayout(null);
		
		
		/// Coloca os componentes no container
		janela.add(titulo);
		janela.add(cadastroFilme);
		janela.add(refreshFilme);
		janela.add(panel);
		janela.add(voltar);
		janela.add(pesquisa);
		janela.add(campoBusca);
	
		/// Dados do container
		janela.setSize(500, 390);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	
		/// Detec��o de eventos
		cadastroFilme.addActionListener(this);
		refreshFilme.addActionListener(this);
		voltar.addActionListener(this);
		pesquisa.addActionListener(this);
		listaFilmesCadastrados.addListSelectionListener(this);
		
	}

	

	/// Detec��o de eventos relacionados aos bot�es
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		/// Cadastro de filme
		if(src == cadastroFilme)
			new TelaDetalheFilme().criarTelaDetalheFilme(1, this, filme, 0);

		/// Atualiza a lista de filmes
		if(src == refreshFilme) {
			listaFilmesCadastrados.setListData(filme.visualizarNome());			
			listaFilmesCadastrados.updateUI();
		}
		
		/// Volta para a janela anterior e fecha a atual
		if (src == voltar ) janela.dispose();
		
		if (src == pesquisa) {
			Filme f = new Filme();
			nome = campoBusca.getText();
			p = filme.retornaPos(nome);
			if (p == -1) {
				f.produtoNaoEncontrado();
				listaFilmesCadastrados.setListData(f.visualizarNome());
				listaFilmesCadastrados.updateUI();
			}
			else {
				for (int i = 0; i < p; i ++)
					f.cadastrarvazio();
				f.cadastrar(filme.buscar(nome));
				listaFilmesCadastrados.setListData(f.visualizarNome());
				listaFilmesCadastrados.updateUI();
			
			}
		}

	}
	

	/// Detec��o de eventos relacionados � lista de filmes
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		/// Seleciona algum filme da lista para editar
		if(e.getValueIsAdjusting() && src == listaFilmesCadastrados) {
			new TelaDetalheFilme().criarTelaDetalheFilme(2, this, filme,
					listaFilmesCadastrados.getSelectedIndex());
		}
	}

}