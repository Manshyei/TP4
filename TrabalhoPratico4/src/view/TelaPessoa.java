package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaPessoa implements ActionListener, ListSelectionListener {		
	
	/// Declaração dos componentes da GUI
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton cadastroFuncionario;
	private JButton refreshFuncionario;
	private JButton voltar;
	private JPanel panel = new JPanel(new BorderLayout());
	private JScrollPane ScrollPane = new JScrollPane();
	
	/// Declaração de JLists para armazenamento de dados
	private JList<String> listaClientesCadastrados;
	private JList<String> listaFuncionariosCadastrados;
	
	/// Declaração de dados a serem manipulados
	private String[] listaNomes = new String[1000];
	ClienteVIP cliente = new ClienteVIP();
	Funcionario funcionario = new Funcionario();
	
	public void criaTelaPessoa(int op, ClienteVIP c, Funcionario f){
		cliente = c;
		funcionario = f;

		
		switch (op) {
		
		/* "op" é uma variável que define se o programa está trabalhando
			com funcionários, se op = 2,  ou com clientes, se op = 1 */
	
		
		case 1:/// Mostrar dados de clientes cadastrados (JList)
			
			listaNomes = cliente.visualizarNome();
			listaClientesCadastrados = new JList<String>(listaNomes);
			
			/// Cria um container e seus componentes
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroCliente = new JButton("Cadastrar");
			refreshCliente = new JButton("Atualizar Lista");
			voltar = new JButton("Voltar");

			
			/// Realiza a seleção de fontes para cada um dos componentes
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			cadastroCliente.setFont(new Font("Arial", Font.BOLD, 17));
			refreshCliente.setFont(new Font("Arial", Font.BOLD, 17));
			listaClientesCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
			voltar.setFont(new Font("Arial", Font.BOLD, 17));

			/// Realiza o posicionamento dos componentes
			titulo.setBounds(90, 15, 350, 30);
			panel.setBounds(40, 110, 400, 140);
			cadastroCliente.setBounds(166, 280, 150, 50);
			refreshCliente.setBounds(326, 280, 150, 50);
			voltar.setBounds(7, 280, 150, 50);
			ScrollPane.setViewportView(listaClientesCadastrados);
			listaClientesCadastrados.setLayoutOrientation(JList.VERTICAL);
	        panel.add(ScrollPane);

			janela.setLayout(null);

			
			/// Coloca os componentes no container
			janela.add(titulo);
			janela.add(cadastroCliente);
			janela.add(refreshCliente);
			janela.add(panel);
			janela.add(voltar);

			/// Dados do container
			janela.setSize(500, 390);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setResizable(false);

			/// Detecção de eventos
			cadastroCliente.addActionListener(this);
			refreshCliente.addActionListener(this);
			voltar.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
			

			break;

		case 2:// Mostrar dados de funcionários cadastrados (JList)
			
			listaNomes = funcionario.visualizarNome();
			listaFuncionariosCadastrados = new JList<String>(listaNomes);
			
			/// Cria um container e seus componentes
			janela = new JFrame("Funcionários");
			titulo = new JLabel("Funcionários Cadastrados");
			cadastroFuncionario = new JButton("Cadastrar");
			refreshFuncionario = new JButton("Atualizar Lista");
			voltar = new JButton("Voltar");

			/// Realiza a seleção de fontes para cada um dos componentes
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			cadastroFuncionario.setFont(new Font("Arial", Font.BOLD, 17));
			refreshFuncionario.setFont(new Font("Arial", Font.BOLD, 17));
			listaFuncionariosCadastrados.setFont(new Font("Arial", Font.BOLD, 15));
			voltar.setFont(new Font("Arial", Font.BOLD, 17));

			/// Realiza o posicionamento dos componentes
			titulo.setBounds(65, 15, 400, 30);
			panel.setBounds(40, 110, 400, 140);
			ScrollPane.setViewportView(listaFuncionariosCadastrados);
			listaFuncionariosCadastrados.setLayoutOrientation(JList.VERTICAL);
	        panel.add(ScrollPane);
			cadastroFuncionario.setBounds(166, 280, 150, 50);
			refreshFuncionario.setBounds(326, 280, 150, 50);
			voltar.setBounds(7, 280, 150, 50);

			janela.setLayout(null);

			
			/// Coloca os componentes no container
			janela.add(titulo);
			janela.add(cadastroFuncionario);
			janela.add(refreshFuncionario);
			janela.add(voltar);
			janela.add(panel);

			/// Dados do container
			janela.setSize(500, 390);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setResizable(false);

			/// Detecção de eventos
			cadastroFuncionario.addActionListener(this);
			refreshFuncionario.addActionListener(this);
			voltar.addActionListener(this);
			listaFuncionariosCadastrados.addListSelectionListener(this);
			
			break;

			/// Caso em que, por algum motivo, op não recebe nem 1 nem 2
		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/// Detecção de eventos relacionados aos botões
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		/// Cadastro de cliente
		if(src == cadastroCliente)
			new TelaDetalhePessoa().inserirEditar(1, this, cliente, funcionario, 0);

		/// Cadastro de funcionário
		if(src == cadastroFuncionario)
			new TelaDetalhePessoa().inserirEditar(2, this, cliente, funcionario, 0);

		/// Atualiza a lista de clientes
		if(src == refreshCliente) {
			listaClientesCadastrados.setListData(cliente.visualizarNome());			
			listaClientesCadastrados.updateUI();
		}

		/// Atualiza a lista de funcionários
		if(src == refreshFuncionario) {
			listaFuncionariosCadastrados.setListData(funcionario.visualizarNome());
			listaFuncionariosCadastrados.updateUI();
		}
		
		/// Volta para a janela anterior e fecha a atual
		if (src == voltar ) janela.dispose();

	}
	
	/// Função de atualizar automaticamente(UNFINISHED);
	/*public void refresh(ActionEvent  a, JButton save) {
		Object src = a.getSource();
		listaNomes = cliente.visualizarNome();
		listaClientesCadastrados = new JList<String>(listaNomes);
		
		if(src == save) {
			listaClientesCadastrados.setListData(cliente.visualizarNome());			
			listaClientesCadastrados.updateUI();
		}

	}*/

	/// Detecção de eventos relacionados à lista de clientes ou funcionários
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		/// Seleciona algum cliente da lista para editar
		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			new TelaDetalhePessoa().inserirEditar(3, this, cliente, funcionario,
					listaClientesCadastrados.getSelectedIndex());
		}
		
		/// Seleciona algum funcionário da lista para editar
		if(e.getValueIsAdjusting() && src == listaFuncionariosCadastrados) {
			new TelaDetalhePessoa().inserirEditar(4, this, cliente, funcionario,
					listaFuncionariosCadastrados.getSelectedIndex());
		}
	}

}