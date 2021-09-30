package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaFilme implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilme;
	private JButton refreshFilme;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	private JList<String> listaFilmesCadastrados;
	private String[] listaFilmes = new String[1000];
	Filme filme = new Filme();
	
	public void mostrarDados(Filme f){
		filme = f;
		
		listaFilmes = filme.visualizarNome();
		listaFilmesCadastrados = new JList<String>(listaFilmes);
		janela = new JFrame("Filmes");
		titulo = new JLabel("Filmes Cadastrados");
		cadastroFilme = new JButton("Cadastrar");
		refreshFilme = new JButton("Atualizar");
	
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		cadastroFilme.setFont(new Font("Arial", Font.BOLD, 18));
		refreshFilme.setFont(new Font("Arial", Font.BOLD, 18));
		listaFilmesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(90, 15, 350, 30);
		panel.setBounds(40, 50, 400, 140);
		ScrollPane.setViewportView(listaFilmesCadastrados);
		listaFilmesCadastrados.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
//		listaFilmesCadastrados.setBounds(40, 50, 400, 140);
//		listaFilmesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		listaFilmesCadastrados.setVisibleRowCount(10);
	
		cadastroFilme.setBounds(70, 210, 150, 50);
		refreshFilme.setBounds(250, 210, 150, 50);
	
		janela.setLayout(null);
	
		janela.add(titulo);
		//janela.add(listaFilmesCadastrados);
		janela.add(cadastroFilme);
		janela.add(refreshFilme);
		janela.add(panel);
	
		janela.setSize(500, 325);
		janela.setVisible(true);
	
		cadastroFilme.addActionListener(this);
		refreshFilme.addActionListener(this);
		listaFilmesCadastrados.addListSelectionListener(this);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);

		
	}

	

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastroFilme)
			new TelaDetalheFilme().inserirEditar(1, this, filme, 0);

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == refreshFilme) {
			listaFilmesCadastrados.setListData(filme.visualizarNome());			
			listaFilmesCadastrados.updateUI();
		}

	}
	

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaFilmesCadastrados) {
			new TelaDetalheFilme().inserirEditar(2, this, filme,
					listaFilmesCadastrados.getSelectedIndex());
		}
	}

}