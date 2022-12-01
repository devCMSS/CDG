package cdg.gui;

import java.awt.BorderLayout;
 
import java.awt.EventQueue;
import java.awt.Image;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
import DAO.usuarioDAO;
import DTO.usuarioDTO;
 
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
 
@SuppressWarnings("unused")
public class cdglogin extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txUsuario;
	private JPasswordField txSenha;
 
	/**
	 * @author CMSdev
	 */
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cdglogin frame = new cdglogin();
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
	public cdglogin() {
		setBackground(new Color(72, 209, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Desktop\\A3\\Logo CDG.png"));
		setTitle("Login - CDG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(178, 78, 46, 14);
		contentPane.add(lblUsuario);
 
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(178, 134, 46, 14);
		contentPane.add(lblSenha);
 
		JButton btnEntrar = new JButton("Entrar");
		Image img2 = new ImageIcon (this.getClass () .getResource ("/EntradaIcon.png")) .getImage();
		btnEntrar.setIcon (new ImageIcon (img2));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnEntrar.setBounds(159, 193, 89, 23);
		contentPane.add(btnEntrar);
 
		txUsuario = new JTextField();
		txUsuario.setBounds(90, 103, 239, 20);
		contentPane.add(txUsuario);
		txUsuario.setColumns(10);
 
		txSenha = new JPasswordField();
		txSenha.setBounds(90, 159, 239, 23);
		contentPane.add(txSenha);
 
		JButton btCadastroEmpresa = new JButton("CADASTRAR USUÁRIO");
		Image img = new ImageIcon (this.getClass () .getResource ("/SignUpIcon.png")) .getImage();
		btCadastroEmpresa.setIcon (new ImageIcon (img));
		btCadastroEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar2();
			}
		});
		btCadastroEmpresa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btCadastroEmpresa.setBounds(113, 227, 180, 23);
		contentPane.add(btCadastroEmpresa);
 
		JLabel lblNewLabel = new JLabel("");
		Image img3 = new ImageIcon (this.getClass () .getResource ("/cdgLogo.png")) .getImage();
		lblNewLabel.setIcon (new ImageIcon (img3));
		lblNewLabel.setBounds(178, 11, 108, 56);
		contentPane.add(lblNewLabel);
 
		JLabel lblNewLabel_1 = new JLabel("");
		Image img4 = new ImageIcon (this.getClass () .getResource ("/UserIcon.png")) .getImage();
		lblNewLabel_1.setIcon (new ImageIcon (img4));
		lblNewLabel_1.setBounds(168, 78, 10, 14);
		contentPane.add(lblNewLabel_1);
 
		JLabel lblNewLabel_1_1 = new JLabel("");
		Image img5 = new ImageIcon (this.getClass () .getResource ("/SenhaIcon.png")) .getImage();
		lblNewLabel_1_1.setIcon (new ImageIcon (img5));
		lblNewLabel_1_1.setBounds(168, 134, 10, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 11, 434, 56);
		contentPane.add(panel);
 
	}
 
	private void logar() {
 
		try {
			String nome_empresa;
			String senha_empresa;
			nome_empresa = txUsuario.getText();
			senha_empresa = txSenha.getText();
 
			usuarioDTO objdto = new usuarioDTO();
			objdto.setLogin_empresa(nome_empresa);
			objdto.setSenha_empresa(senha_empresa);
 
			usuarioDAO objdao = new usuarioDAO();
			ResultSet rsusuariodao = objdao.autenticarUsuario(objdto);
 
			if (rsusuariodao.next()) {
				cdgInicial menu = new cdgInicial();
				menu.setVisible(true);
				dispose();
			} else {
 
				JOptionPane.showInternalMessageDialog(null, "Usuário ou senha incorretos!");
 
			}
 
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "CDGLOGIN: " + erro);
		}
 
	}
 
	private void logar2() {
 
		try {
			String nome_empresa;
			String senha_empresa;
			nome_empresa = txUsuario.getText();
			senha_empresa = txSenha.getText();
 
			usuarioDTO objdto = new usuarioDTO();
			objdto.setLogin_empresa(nome_empresa);
			objdto.setSenha_empresa(senha_empresa);
 
			usuarioDAO objdao = new usuarioDAO();
			ResultSet rsusuariodao = objdao.autenticarUsuario(objdto);
 
			if (rsusuariodao.next()) {
				cdgCadastroUsuario menu = new cdgCadastroUsuario();
				menu.setVisible(true);
				dispose();
			} else {
 
				JOptionPane.showInternalMessageDialog(null, "Usuário ou senha incorretos!");
 
			}
 
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "CDGLOGIN: " + erro);
		}
 
	}
 
	public boolean checkLogin(String login, String senha) {
		return login.equals("empresa1") && senha.equals("123");
		// LOGIN ANTIGO
	}
}