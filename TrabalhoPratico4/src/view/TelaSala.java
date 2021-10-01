package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaSala implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroSala;
	private JButton refreshSala;
	private JButton voltar;
	private JButton pesquisa;
	private JTextField campoBusca;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	private JList<String> listaSalasCadastradas;
	//private String[] listaSalas = new String[1000];
	private String nome;
	SalaCinema sala = new SalaCinema();
	
	public void criaTelaSala(SalaCinema s){
		sala = s;
		
		campoBusca = new JTextField(200);
		
		//listaSalas = sala.visualizarNome();
		listaSalasCadastradas = new JList<String>(sala.visualizarNome());
		janela = new JFrame("Salas");
		titulo = new JLabel("Salas Cadastradas");
		cadastroSala = new JButton("Cadastrar");
		refreshSala = new JButton("Atualizar Lista");
		voltar = new JButton("Voltar");
		pesquisa = new JButton("Buscar");
	
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		cadastroSala.setFont(new Font("Arial", Font.BOLD, 17));
		refreshSala.setFont(new Font("Arial", Font.BOLD, 17));
		voltar.setFont(new Font("Arial", Font.BOLD, 17));
		pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		listaSalasCadastradas.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(90, 15, 350, 30);
		panel.setBounds(40, 110, 400, 140);
		ScrollPane.setViewportView(listaSalasCadastradas);
		listaSalasCadastradas.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
//		listaSalasCadastradas.setBounds(40, 50, 400, 140);
//		listaSalasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		listaSalasCadastradas.setVisibleRowCount(10);
	
        cadastroSala.setBounds(166, 280, 150, 50);
		refreshSala.setBounds(326, 280, 150, 50);
		voltar.setBounds(7, 280, 150, 50);
		pesquisa.setBounds(290, 70, 100, 25);
		
		campoBusca.setBounds(90, 70, 185, 25);
	
		janela.setLayout(null);
	
		janela.add(titulo);
		//janela.add(listaSalasCadastradas);
		janela.add(cadastroSala);
		janela.add(refreshSala);
		janela.add(voltar);
		janela.add(pesquisa);
		janela.add(panel);
		janela.add(campoBusca);
	
		janela.setSize(500, 390);
		janela.setVisible(true);
	
		cadastroSala.addActionListener(this);
		refreshSala.addActionListener(this);
		voltar.addActionListener(this);
		pesquisa.addActionListener(this);
		listaSalasCadastradas.addListSelectionListener(this);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	
	}

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastroSala)
			new TelaDetalheSala().inserirEditar(1, this, sala, 0);

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == refreshSala) {
			listaSalasCadastradas.setListData(sala.visualizarNome());			
			listaSalasCadastradas.updateUI();
		}
		
		if (src == voltar ) janela.dispose();
		
		if (src == pesquisa) {
			nome = campoBusca.getText();
			SalaCinema sl = new SalaCinema();
			sl.cadastrar(sala.buscar(nome));
			listaSalasCadastradas.setListData(sl.visualizarNome());
			listaSalasCadastradas.updateUI();
			
		}

	}
	

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaSalasCadastradas) {
			new TelaDetalheSala().inserirEditar(2, this, sala,
					listaSalasCadastradas.getSelectedIndex());
		}
	}

}