package cdg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
import DAO.estoqueDAO;
import DAO.ticketsDAO;
import DTO.estoqueDTO;
import DTO.ticketsDTO;
 
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
 
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
 
public class cdgMTickets extends JFrame {
 
	private JPanel contentPane;
	private JTextField txDesc;
	private JTextField txNome;
 
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cdgMTickets frame = new cdgMTickets();
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
	public cdgMTickets() {
		setTitle("SUPORTE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talen\\Desktop\\A3\\Logo CDG.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		txDesc = new JTextField();
		txDesc.setBounds(10, 120, 313, 130);
		contentPane.add(txDesc);
		txDesc.setColumns(10);
 
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Prioridade");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Baixo", "Médio", "Alto" }));
		comboBox.setBounds(333, 20, 91, 22);
		contentPane.add(comboBox);
 
		JLabel lblPrioridade = new JLabel("Nível de prioridade:");
		lblPrioridade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrioridade.setBounds(215, 24, 108, 14);
		contentPane.add(lblPrioridade);
 
		JButton btCancelar = new JButton("Cancelar");
		Image img3 = new ImageIcon (this.getClass () .getResource ("/CancelarIcon.png")) .getImage();
		btCancelar.setIcon (new ImageIcon (img3));
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdgInicial menu = new cdgInicial();
				menu.setVisible(true);
				dispose();
			}
		});
		btCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btCancelar.setBounds(333, 178, 89, 23);
		contentPane.add(btCancelar);
 
		JButton btnEnviar = new JButton("Enviar");
		Image img4 = new ImageIcon (this.getClass () .getResource ("/EnviarIcon.png")) .getImage();
		btnEnviar.setIcon (new ImageIcon (img4));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
				String usuario_ticket = txNome.getText();
				String desc_ticket = txDesc.getText();
 
				ticketsDTO ticketsDTO1 = new ticketsDTO();
				ticketsDTO1.setUsuario_ticket(usuario_ticket);
				ticketsDTO1.setDesc_ticket(desc_ticket);
 
				ticketsDAO ticketsDAO = new ticketsDAO();
				ticketsDAO.cadastroEstoque(ticketsDTO1);
				;
 
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBounds(333, 215, 89, 23);
		contentPane.add(btnEnviar);
 
		JLabel lblNewLabel = new JLabel("Descreva sua solicitação:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 82, 177, 27);
		contentPane.add(lblNewLabel);
 
		txNome = new JTextField();
		txNome.setBounds(10, 51, 177, 20);
		contentPane.add(txNome);
		txNome.setColumns(10);
 
		JLabel lbNome = new JLabel("Nome da empresa:");
		lbNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbNome.setBounds(10, 11, 177, 27);
		contentPane.add(lbNome);
 
		JButton btnNewButton = new JButton("Tickets");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketslistar menu = new ticketslistar();
				menu.setVisible(true);
				dispose();
			}
		});
		Image img2 = new ImageIcon (this.getClass () .getResource ("/TicketsIcon.png")) .getImage();
		btnNewButton.setIcon (new ImageIcon (img2));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(333, 144, 89, 23);
		contentPane.add(btnNewButton);
 
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon (this.getClass () .getResource ("/LogoAzul.png")) .getImage();
		lblNewLabel_1.setIcon (new ImageIcon (img));
		lblNewLabel_1.setBounds(353, 51, 71, 67);
		contentPane.add(lblNewLabel_1);
 
	}
}