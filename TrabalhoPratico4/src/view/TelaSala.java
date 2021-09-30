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
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	private JList<String> listaSalasCadastradas;
	private String[] listaSalas = new String[1000];
	SalaCinema sala = new SalaCinema();
	
	public void mostrarDados(SalaCinema s){
		sala = s;
		
		listaSalas = sala.visualizarNome();
		listaSalasCadastradas = new JList<String>(listaSalas);
		janela = new JFrame("Salas");
		titulo = new JLabel("Salas Cadastradas");
		cadastroSala = new JButton("Cadastrar");
		refreshSala = new JButton("Atualizar");
	
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		cadastroSala.setFont(new Font("Arial", Font.BOLD, 18));
		refreshSala.setFont(new Font("Arial", Font.BOLD, 18));
		listaSalasCadastradas.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setBounds(90, 15, 350, 30);
		panel.setBounds(40, 50, 400, 140);
		ScrollPane.setViewportView(listaSalasCadastradas);
		listaSalasCadastradas.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
//		listaSalasCadastradas.setBounds(40, 50, 400, 140);
//		listaSalasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		listaSalasCadastradas.setVisibleRowCount(10);
	
		cadastroSala.setBounds(70, 210, 150, 50);
		refreshSala.setBounds(250, 210, 150, 50);
	
		janela.setLayout(null);
	
		janela.add(titulo);
		//janela.add(listaSalasCadastradas);
		janela.add(cadastroSala);
		janela.add(refreshSala);
		janela.add(panel);
	
		janela.setSize(500, 325);
		janela.setVisible(true);
	
		cadastroSala.addActionListener(this);
		refreshSala.addActionListener(this);
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