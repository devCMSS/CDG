package cdg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
 
import DAO.classeConexao;
import DAO.conexaoDAO;
import DAO.estoqueDAO;
import DTO.estoqueDTO;
import net.proteanit.sql.DbUtils;
 
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
 
public class cdgestoquelistar extends JFrame {
 
	private JPanel contentPane;
	private JTable tabelaEstoque;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cdgestoquelistar frame = new cdgestoquelistar();
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
	public cdgestoquelistar() {
		setTitle("Estoque");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Downloads\\cdgLogo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 213);
		contentPane.add(scrollPane);
 
		tabelaEstoque = new JTable();
		scrollPane.setViewportView(tabelaEstoque);
 
		JButton btInserir = new JButton("CADASTRAR");
		Image img = new ImageIcon (this.getClass () .getResource ("/SignUpIcon.png")) .getImage();
		btInserir.setIcon (new ImageIcon (img));
		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgestoque menu2 = new cdgestoque();
				menu2.setVisible(true);
				dispose();
			}
		});
		btInserir.setBounds(297, 235, 127, 23);
		contentPane.add(btInserir);
 
		JButton btnAtualizar = new JButton("ATUALIZAR");
		Image img2 = new ImageIcon (this.getClass () .getResource ("/AtualizarIcon.png")) .getImage();
		btnAtualizar.setIcon (new ImageIcon (img2));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnAtualizar.setBounds(159, 235, 118, 23);
		contentPane.add(btnAtualizar);
 
		JButton btnVoltar = new JButton("MENU");
		Image img3 = new ImageIcon (this.getClass () .getResource ("/MenuIcon.png")) .getImage();
		btnVoltar.setIcon (new ImageIcon (img3));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgInicial menu1 = new cdgInicial();
				menu1.setVisible(true);
				dispose();
 
			}
		});
		btnVoltar.setBounds(10, 235, 118, 23);
		contentPane.add(btnVoltar);
	}
 
//	private void listarEstoque() {
//
//		try {
//			estoqueDAO estoquedao1 = new estoqueDAO();
//			DefaultTableModel model = (DefaultTableModel) tabelaEstoque.getModel();
//			model.setNumRows(0);
//			ArrayList<estoqueDTO> lista = estoquedao1.pesquisarEstoque();
//
//			for (int num = 0; num < lista.size(); num++) {
//				model.addRow(new Object[] { lista.get(num).getCodigo(), lista.get(num).getProduto(),
//						lista.get(num).getQuantidade() });
//
//			}
//
//		} catch (SQLException erro) {
//			JOptionPane.showMessageDialog(contentPane, "LISTAR_ESTOQUE: " + erro);
//		}
 
//	}
 
	private void listar() {
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
		try {
			conexao = classeConexao.Conectar();
			comando = conexao.createStatement();
			String meu_sql = "SELECT * FROM estoque";
			resultado = comando.executeQuery(meu_sql);
			tabelaEstoque.setModel(DbUtils.resultSetToTableModel(resultado));
 
		} catch (SQLException e2) {
			e2.printStackTrace();
 
		} finally {
			classeConexao.FecharConexao(conexao);
			try {
				comando.close();
				resultado.close();
 
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
	}
 
}