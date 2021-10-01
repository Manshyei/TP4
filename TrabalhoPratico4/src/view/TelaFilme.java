package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaFilme implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilme;
	private JButton refreshFilme;
	private JButton voltar;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	private JList<String> listaFilmesCadastrados;
	private String[] listaFilmes = new String[1000];
	Filme filme = new Filme();
	
	public void mostrarDados(Filme f){
		filme = f;
		
		listaFilmes = filme.visualizarNome();
		listaFilmesCadastrados = new JList<String>(listaFilmes);
		
		//Título;
		titulo = new JLabel("Filmes Cadastrados");
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setBounds(90, 15, 350, 30);
		
		//Botão;
		cadastroFilme = new JButton("Cadastrar");
		cadastroFilme.setFont(new Font("Arial", Font.BOLD, 18));
		cadastroFilme.setBounds(166, 280, 150, 50);
		refreshFilme = new JButton("Atualizar");
		refreshFilme.setFont(new Font("Arial", Font.BOLD, 18));
		refreshFilme.setBounds(326, 280, 150, 50);
		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Arial", Font.BOLD, 18));
		voltar.setBounds(7, 280, 150, 50);
		
		//Lista
		listaFilmesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
		panel.setBounds(40, 110, 400, 140);
		ScrollPane.setViewportView(listaFilmesCadastrados);
		listaFilmesCadastrados.setLayoutOrientation(JList.VERTICAL);
        panel.add(ScrollPane);
	
        //Janela
      	janela = new JFrame("Filmes");
		janela.setLayout(null);
	
		janela.add(titulo);
		janela.add(cadastroFilme);
		janela.add(refreshFilme);
		janela.add(panel);
		janela.add(voltar);
	
		janela.setSize(500, 390);
		janela.setVisible(true);
		
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	
		cadastroFilme.addActionListener(this);
		refreshFilme.addActionListener(this);
		voltar.addActionListener(this);
		listaFilmesCadastrados.addListSelectionListener(this);
		
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
		
		if (src == voltar ) janela.dispose();

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