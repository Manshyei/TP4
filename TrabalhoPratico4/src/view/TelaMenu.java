package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import principal.*;

public class TelaMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Cinema");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton clienteVIP = new JButton("Cliente VIP");
	private static JButton filme = new JButton("Filme");
	private static JButton funcionario = new JButton("Funcionário");
	private static JButton sala = new JButton("Sala de Cinema");
	private static JButton ingresso = new JButton("Ingresso");
	ClienteVIP cliente = new ClienteVIP();
	Funcionario func = new Funcionario();
	//public static ControleDados dados = new ControleDados();
	
	public TelaMenu() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		clienteVIP.setFont(new Font("Arial", Font.BOLD, 18));
		filme.setFont(new Font("Arial", Font.BOLD, 18));
		funcionario.setFont(new Font("Arial", Font.BOLD, 18));
		sala.setFont(new Font("Arial", Font.BOLD, 18));
		ingresso.setFont(new Font("Arial", Font.BOLD, 18));
		
		titulo.setBounds(140, 0, 300, 75);
		clienteVIP.setBounds(60, 75, 150, 50);
		filme.setBounds(60, 135, 150, 50);
		funcionario.setBounds(260, 75, 150, 50);
		sala.setBounds(140, 200, 200, 50);
		ingresso.setBounds(260, 135, 150, 50);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(clienteVIP);
		janela.add(filme);
		janela.add(funcionario);
		janela.add(sala);
		janela.add(ingresso);
		
		janela.setSize(500, 325);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	}
	
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		clienteVIP.addActionListener(menu);
		filme.addActionListener(menu);
		funcionario.addActionListener(menu);
		sala.addActionListener(menu);
		ingresso.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == clienteVIP)
			new TelaPessoa().mostrarDados(1);
		
		if(src == funcionario)
			new TelaPessoa().mostrarDados(2);
		
		/*if(src == filme)
			new TelaFilme().mostrarDados(dados, 3);
		
		if(src == sala)
			new TelaSala().mostrarDados(dados, 4);
		
		if(src == ingresso)
			new TelaIngresso().mostrarDados(dados, 5);*/
	}
}

