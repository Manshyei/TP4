package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaPessoa implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton cadastroProf;
	private JButton refreshProf;
	private JButton voltar;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	private JList<String> listaClientesCadastrados;
	private JList<String> listaFuncionariosCadastrados;
	private String[] listaNomes = new String[1000];
	ClienteVIP cliente = new ClienteVIP();
	Funcionario funcionario = new Funcionario();
	
	public void mostrarDados(int op, ClienteVIP c, Funcionario f){
		cliente = c;
		funcionario = f;

		switch (op) {
		case 1:// Mostrar dados de alunos cadastrados (JList)
			listaNomes = cliente.visualizarNome();
			listaClientesCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroCliente = new JButton("Cadastrar");
			refreshCliente = new JButton("Atualizar");
			voltar = new JButton("<=");

			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			cadastroCliente.setFont(new Font("Arial", Font.BOLD, 18));
			refreshCliente.setFont(new Font("Arial", Font.BOLD, 18));
			listaClientesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
			voltar.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(90, 15, 350, 30);
//			listaClientesCadastrados.setBounds(40, 50, 400, 140);
//			listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//			listaClientesCadastrados.setVisibleRowCount(10);
			
			panel.setBounds(40, 50, 400, 140);
			ScrollPane.setViewportView(listaClientesCadastrados);
			listaClientesCadastrados.setLayoutOrientation(JList.VERTICAL);
	        panel.add(ScrollPane);

			cadastroCliente.setBounds(166, 210, 150, 50);
			refreshCliente.setBounds(326, 210, 150, 50);
			voltar.setBounds(7, 210, 50, 50);

			janela.setLayout(null);

			janela.add(titulo);
			//janela.add(listaClientesCadastrados);
			janela.add(cadastroCliente);
			janela.add(refreshCliente);
			janela.add(panel);
			janela.add(voltar);

			janela.setSize(500, 325);
			janela.setVisible(true);

			cadastroCliente.addActionListener(this);
			refreshCliente.addActionListener(this);
			voltar.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
			janela.setLocationRelativeTo(null);
			janela.setResizable(false);

			break;

		case 2:// Mostrar dados de professores cadastrados (JList)
			listaNomes = funcionario.visualizarNome();
			listaFuncionariosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Funcionários");
			titulo = new JLabel("Funcionários Cadastrados");
			cadastroProf = new JButton("Cadastrar");
			refreshProf = new JButton("Atualizar");

			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			cadastroProf.setFont(new Font("Arial", Font.BOLD, 18));
			refreshProf.setFont(new Font("Arial", Font.BOLD, 18));
			listaFuncionariosCadastrados.setFont(new Font("Arial", Font.BOLD, 15));

			titulo.setBounds(65, 15, 400, 30);
			panel.setBounds(40, 50, 400, 140);
			ScrollPane.setViewportView(listaFuncionariosCadastrados);
			listaFuncionariosCadastrados.setLayoutOrientation(JList.VERTICAL);
	        panel.add(ScrollPane);

//			listaFuncionariosCadastrados.setBounds(40, 50, 400, 140);
//			listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//			listaFuncionariosCadastrados.setVisibleRowCount(10);


			cadastroProf.setBounds(70, 210, 150, 50);
			refreshProf.setBounds(250, 210, 150, 50);

			janela.setLayout(null);

			janela.add(titulo);
			//janela.add(listaFuncionariosCadastrados);
			janela.add(cadastroProf);
			janela.add(refreshProf);
			janela.add(panel);

			janela.setSize(500, 325);
			janela.setVisible(true);

			cadastroProf.addActionListener(this);
			refreshProf.addActionListener(this);
			listaFuncionariosCadastrados.addListSelectionListener(this);
			janela.setLocationRelativeTo(null);
			janela.setResizable(false);
			
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastroCliente)
			new TelaDetalhePessoa().inserirEditar(1, this, cliente, funcionario, 0);

		//Cadastro de novo professor
		if(src == cadastroProf)
			new TelaDetalhePessoa().inserirEditar(2, this, cliente, funcionario, 0);

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == refreshCliente) {
			listaClientesCadastrados.setListData(cliente.visualizarNome());			
			listaClientesCadastrados.updateUI();
		}

		// Atualiza a lista de nomes de funcionarios mostrada no JList
		if(src == refreshProf) {
			listaFuncionariosCadastrados.setListData(funcionario.visualizarNome());
			listaFuncionariosCadastrados.updateUI();
		}
		
		if (src == voltar ) janela.dispose();

	}
	
	//Função de atualizar automaticamente;
	/*public void refresh(ActionEvent  a, JButton save) {
		Object src = a.getSource();
		listaNomes = cliente.visualizarNome();
		listaClientesCadastrados = new JList<String>(listaNomes);
		
		if(src == save) {
			listaClientesCadastrados.setListData(cliente.visualizarNome());			
			listaClientesCadastrados.updateUI();
		}

	}*/

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			new TelaDetalhePessoa().inserirEditar(3, this, cliente, funcionario,
					listaClientesCadastrados.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaFuncionariosCadastrados) {
			new TelaDetalhePessoa().inserirEditar(4, this, cliente, funcionario,
					listaFuncionariosCadastrados.getSelectedIndex());
		}
	}

}