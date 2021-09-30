package view;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import principal.*;

public class TelaIngresso implements ActionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton proximo;
	private JButton voltar;
	private JLabel labelQntddIngressos = new JLabel("Quantidade de Ingressos: ");
	private JTextField valorQntddIngressos;
	private int qntddIngressos;
	VendaIngresso venda = new VendaIngresso();
	private int i = 0;
	
	public void mostrarDados(VendaIngresso v){
		venda = v;
		
		labelQntddIngressos.setFont(new Font("Arial", Font.BOLD, 18));
		labelQntddIngressos.setBounds(20, 80, 300, 100);
		valorQntddIngressos = new JTextField(200);
		valorQntddIngressos.setBounds(255, 118, 180, 25);
		
		janela = new JFrame("Venda de Ingresso");
		titulo = new JLabel("Cadastro de Venda");
		proximo = new JButton("Próximo");
		voltar = new JButton("Voltar");
	
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		proximo.setFont(new Font("Arial", Font.BOLD, 18));
		voltar.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(90, 15, 350, 30);
	
		proximo.setBounds(250, 210, 150, 50);
		voltar.setBounds(50, 210, 150, 50);
	
		janela.setLayout(null);
	
		janela.add(titulo);
		janela.add(proximo);
		janela.add(voltar);
		this.janela.add(labelQntddIngressos);
		this.janela.add(valorQntddIngressos);

		janela.setSize(500, 325);
		janela.setVisible(true);
	
		proximo.addActionListener(this);
		voltar.addActionListener(this);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		
	}

	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
			//Proximo;
			if(src == proximo) {
				qntddIngressos = Integer.parseInt(valorQntddIngressos.getText());
				janela.dispose();
				while (i < qntddIngressos) {
				new TelaDetalheIngresso().inserirEditar(this, venda);
				i ++;
				}
			}
			
			if (src == voltar ) janela.dispose();
	
	}

}