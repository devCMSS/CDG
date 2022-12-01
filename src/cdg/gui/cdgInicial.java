package cdg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class cdgInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cdgInicial frame = new cdgInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cdgInicial() {
		setTitle("MENU EMPRESA");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Downloads\\cdgLogo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton Tickets = new JButton("SUPORTE");
		Image img2 = new ImageIcon(this.getClass().getResource("/SuporteIcon.png")).getImage();
		Tickets.setIcon(new ImageIcon(img2));
		Tickets.setBounds(138, 83, 138, 23);
		Tickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgMTickets j2 = new cdgMTickets();
				j2.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(Tickets);

		JButton btnNewButton_1 = new JButton("PRODUTOS");
		Image img3 = new ImageIcon(this.getClass().getResource("/ProdutosIcon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgestoque estoque = new cdgestoque();
				estoque.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(138, 129, 138, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("ESTOQUE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgestoquelistar menu2 = new cdgestoquelistar();
				menu2.setVisible(true);
				dispose();
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/EstoqueIcon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img4));
		btnNewButton_2.setBounds(138, 180, 138, 23);
		contentPane.add(btnNewButton_2);

		JButton btTrocaUsuario = new JButton("TROCAR USUÁRIO");
		Image img5 = new ImageIcon(this.getClass().getResource("/TrocarIcon.png")).getImage();
		btTrocaUsuario.setIcon(new ImageIcon(img5));
		btTrocaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdglogin login = new cdglogin();
				login.setVisible(true);
				dispose();
			}
		});
		btTrocaUsuario.setBounds(10, 227, 159, 23);
		contentPane.add(btTrocaUsuario);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cdgLogo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(187, 11, 89, 61);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 11, 434, 61);
		contentPane.add(panel);
	}
}