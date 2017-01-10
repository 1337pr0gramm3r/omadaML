import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SmartBookOwnerDelOffers {

	private JFrame frame;
	private JTextField txtOfferID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void deleteOffers() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartBookOwnerDelOffers window = new SmartBookOwnerDelOffers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SmartBookOwnerDelOffers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Owner's Panel (Delete Offers)");
		lblNewLabel.setForeground(new Color(255, 102, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(208, 27, 299, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblOfferID = new JLabel("Offer ID");
		lblOfferID.setFont(new Font("Arial", Font.BOLD, 12));
		lblOfferID.setBounds(109, 78, 70, 15);
		frame.getContentPane().add(lblOfferID);
		
		txtOfferID = new JTextField();
		txtOfferID.setFont(new Font("Arial", Font.BOLD, 12));
		txtOfferID.setBounds(176, 70, 61, 31);
		frame.getContentPane().add(txtOfferID);
		txtOfferID.setColumns(10);
		
		JButton btnDelOffer = new JButton("Delete");
		btnDelOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn1 = null;
				Statement stmt1 = null;
				//ResultSet rs1 = null;
				try
				{
					// Main code here
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://127.0.0.1:3306/smartHotel";
					String connectionUser = "root";
					String connectionPassword = "test123";
					conn1 = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					stmt1 = conn1.createStatement();
					stmt1.executeUpdate("DELETE FROM offers WHERE id='"+txtOfferID.getText()+"'");
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnDelOffer.setFont(new Font("Arial", Font.BOLD, 12));
		btnDelOffer.setBounds(255, 70, 117, 31);
		frame.getContentPane().add(btnDelOffer);
		
		JButton btnOffers = new JButton("Offers");
		btnOffers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try
				{
					// Main code here
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://127.0.0.1:3306/smartHotel";
					String connectionUser = "root";
					String connectionPassword = "test123";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM offers");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnOffers.setBounds(390, 70, 117, 31);
		frame.getContentPane().add(btnOffers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 130, 642, 243);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.setBounds(100, 100, 693, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
