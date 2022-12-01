package cdg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.classeConexao;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ticketslistar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketslistar frame = new ticketslistar();
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
	public ticketslistar() {
		setTitle("LISTA TICKETS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Downloads\\cdgLogo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 179);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnListar = new JButton("ATUALIZAR");
		Image img2 = new ImageIcon (this.getClass () .getResource ("/AtualizarIcon.png")) .getImage();
		btnListar.setIcon (new ImageIcon (img2));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();

			}
		});
		btnListar.setBounds(281, 227, 143, 23);
		contentPane.add(btnListar);

		btnNewButton = new JButton("MENU");
		Image img3 = new ImageIcon (this.getClass () .getResource ("/MenuIcon.png")) .getImage();
		btnNewButton.setIcon (new ImageIcon (img3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgMTickets menu = new cdgMTickets();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 143, 23);
		contentPane.add(btnNewButton);
	}

	private void listar() {
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
		try {
			conexao = classeConexao.Conectar();
			comando = conexao.createStatement();
			String meu_sql = "SELECT * FROM tickets";
			resultado = comando.executeQuery(meu_sql);
			table.setModel(DbUtils.resultSetToTableModel(resultado));

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