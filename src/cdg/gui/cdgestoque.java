package cdg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.estoqueDAO;
import DTO.estoqueDTO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class cdgestoque extends JFrame {

	private JPanel contentPane;
	private JTextField txProduto;
	private JTextField txQuantidade;
	private JTextField txCodigo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cdgestoque frame = new cdgestoque();
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
	public cdgestoque() {
		setTitle("CADASTRAR PRODUTOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Desktop\\A3\\Logo CDG.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Cadastrar");
		Image img = new ImageIcon (this.getClass () .getResource ("/SignUpIcon.png")) .getImage();
		btnNewButton.setIcon (new ImageIcon (img));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {

				String produto = txProduto.getText();
				int quantidade = Integer.parseUnsignedInt(txQuantidade.getText());

				estoqueDTO estoqueDTO1 = new estoqueDTO();
				estoqueDTO1.setProduto(produto);
				estoqueDTO1.setQuantidade(quantidade);

				estoqueDAO estoqueDAO = new estoqueDAO();
				estoqueDAO.cadastroEstoque(estoqueDTO1);
				;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(323, 227, 101, 23);
		contentPane.add(btnNewButton);

		txProduto = new JTextField();
		txProduto.setBounds(10, 51, 276, 20);
		contentPane.add(txProduto);
		txProduto.setColumns(10);

		JLabel lbProduto = new JLabel("Produto:");
		lbProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbProduto.setBounds(10, 26, 70, 14);
		contentPane.add(lbProduto);

		txQuantidade = new JTextField();
		txQuantidade.setBounds(10, 126, 276, 20);
		contentPane.add(txQuantidade);
		txQuantidade.setColumns(10);

		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbQuantidade.setBounds(10, 101, 86, 14);
		contentPane.add(lbQuantidade);

		JButton btnRemover = new JButton("Remover");
		Image img3 = new ImageIcon (this.getClass () .getResource ("/CancelarIcon.png")) .getImage();
		btnRemover.setIcon (new ImageIcon (img3));
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemover.setBounds(323, 193, 101, 23);
		contentPane.add(btnRemover);

		JButton btnAlterar = new JButton("Alterar");
		Image img4 = new ImageIcon (this.getClass () .getResource ("/AlterarIcon.png")) .getImage();
		btnAlterar.setIcon (new ImageIcon (img4));
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(323, 159, 101, 23);
		contentPane.add(btnAlterar);

		JButton btnMenu = new JButton("Menu");
		Image img1 = new ImageIcon (this.getClass () .getResource ("/MenuIcon.png")) .getImage();
		btnMenu.setIcon (new ImageIcon (img1));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgInicial menu = new cdgInicial();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenu.setBounds(10, 227, 89, 23);
		contentPane.add(btnMenu);

		JButton btnEstoque = new JButton("Estoque");
		Image img2 = new ImageIcon (this.getClass () .getResource ("/EstoqueIcon.png")) .getImage();
		btnEstoque.setIcon (new ImageIcon (img2));
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgestoquelistar menu2 = new cdgestoquelistar();
				menu2.setVisible(true);
				dispose();
			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEstoque.setBounds(323, 22, 101, 23);
		contentPane.add(btnEstoque);

		txCodigo = new JTextField();
		txCodigo.setColumns(10);
		txCodigo.setBounds(91, 179, 195, 20);
		contentPane.add(txCodigo);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(10, 182, 86, 14);
		contentPane.add(lblCodigo);
	}

}