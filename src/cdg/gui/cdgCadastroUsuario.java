package cdg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cdgCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txNome;
	private JPasswordField txSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cdgCadastroUsuario frame = new cdgCadastroUsuario();
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
	public cdgCadastroUsuario() {
		setTitle("CADASTRAR USUÁRIO\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Desktop\\A3\\Logo CDG.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(10, 11, 86, 14);
		contentPane.add(lbNome);
		
		txNome = new JTextField();
		txNome.setBounds(10, 36, 414, 20);
		contentPane.add(txNome);
		txNome.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(10, 81, 46, 14);
		contentPane.add(lbSenha);
		
		txSenha = new JPasswordField();
		txSenha.setBounds(10, 106, 414, 20);
		contentPane.add(txSenha);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(300, 227, 124, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setBounds(300, 193, 124, 23);
		contentPane.add(btnRemover);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cdglogin menu2 = new cdglogin();
				menu2.setVisible(true);
				dispose();
				
			}
		});
		btnMenu.setBounds(10, 227, 89, 23);
		contentPane.add(btnMenu);
	}
}
