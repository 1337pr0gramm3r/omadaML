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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SMEmployerEdit {

	private JFrame frame;
	private JTextField txtRoom;
	private JTextField txtPersons;
	private JTextField txtBeds;
	private JTextField txtDateFrom;
	private JTextField txtSingleBed;
	private JTextField txtDateTo;
	private JTextField txtDoubleBed;
	private JTextField txtCategory;
	private JTextField txtName;
	private JTextField txtPrice;
	private JButton btnAddRoom;
	private JTextField txtRoomsID;
	private JButton btnDeleteRoom;
	private JLabel lblRoom;
	private JLabel lblBeds;
	private JLabel lblSingleBed;
	private JLabel DoubleBed;
	private JLabel lblCategory;
	private JLabel lblName;
	private JLabel lblPersons;
	private JLabel lblDateFrom;
	private JLabel lblDateTo;
	private JLabel lblPrice;
	private JLabel lblRoomsID;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnRooms;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtID;
	private JButton btnUpdate;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JLabel lblID;

	/**
	 * Launch the application.
	 */
	public static void editRooms() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SMEmployerEdit window = new SMEmployerEdit();
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
	public SMEmployerEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployersPaneledit = new JLabel("Employee's Panel (Edit Rooms)");
		lblEmployersPaneledit.setForeground(new Color(255, 102, 0));
		lblEmployersPaneledit.setFont(new Font("Arial", Font.BOLD, 18));
		lblEmployersPaneledit.setBounds(386, 30, 281, 27);
		frame.getContentPane().add(lblEmployersPaneledit);
		
		btnRooms = new JButton("Rooms");
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn1 = null;
				Statement stmt1 = null;
				ResultSet rs1 = null;
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
					rs1 = stmt1.executeQuery("SELECT * FROM rooms");
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					rs1.close();
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnRooms.setFont(new Font("Arial", Font.BOLD, 12));
		btnRooms.setBounds(33, 32, 248, 25);
		frame.getContentPane().add(btnRooms);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRoom.setBounds(33, 97, 114, 19);
		frame.getContentPane().add(txtRoom);
		txtRoom.setColumns(10);
		
		txtPersons = new JTextField();
		txtPersons.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPersons.setBounds(167, 140, 114, 19);
		frame.getContentPane().add(txtPersons);
		txtPersons.setColumns(10);
		
		txtBeds = new JTextField();
		txtBeds.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBeds.setBounds(33, 141, 114, 19);
		frame.getContentPane().add(txtBeds);
		txtBeds.setColumns(10);
		
		txtDateFrom = new JTextField();
		txtDateFrom.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDateFrom.setBounds(167, 187, 114, 19);
		frame.getContentPane().add(txtDateFrom);
		txtDateFrom.setColumns(10);
		
		txtSingleBed = new JTextField();
		txtSingleBed.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSingleBed.setBounds(33, 187, 114, 19);
		frame.getContentPane().add(txtSingleBed);
		txtSingleBed.setColumns(10);
		
		txtDateTo = new JTextField();
		txtDateTo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDateTo.setBounds(167, 236, 114, 19);
		frame.getContentPane().add(txtDateTo);
		txtDateTo.setColumns(10);
		
		txtDoubleBed = new JTextField();
		txtDoubleBed.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDoubleBed.setBounds(33, 235, 114, 19);
		frame.getContentPane().add(txtDoubleBed);
		txtDoubleBed.setColumns(10);
		
		txtCategory = new JTextField();
		txtCategory.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCategory.setBounds(33, 283, 114, 19);
		frame.getContentPane().add(txtCategory);
		txtCategory.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Arial", Font.PLAIN, 12));
		txtName.setBounds(167, 96, 114, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPrice.setBounds(167, 283, 114, 19);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		btnAddRoom = new JButton("Add Room");
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				//Statement stmt = null;
				//ResultSet rs = null;
			try
			{
				// Main code here
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String connectionUrl = "jdbc:mysql://127.0.0.1:3306/smartHotel";
				String connectionUser = "root";
				String connectionPassword = "test123";
				conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				String query = "INSERT INTO rooms (room, beds, singlebed, doublebed, category, name, persons, datefrom, dateto, price, discount, DiscFrom, DiscTo) VALUES (?,?,?,?,?,?,?,?,?,?,'0','-','-')";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			    preparedStmt.setString (1, txtRoom.getText());
			    preparedStmt.setString (2, txtBeds.getText());
			    preparedStmt.setString (3, txtSingleBed.getText());
			    preparedStmt.setString (4, txtDoubleBed.getText());
			    preparedStmt.setString (5, txtCategory.getText());
			    preparedStmt.setString (6, txtName.getText());
			    preparedStmt.setString (7, txtPersons.getText());
			    preparedStmt.setString (8, txtDateFrom.getText());
			    preparedStmt.setString (9, txtDateTo.getText());
			    preparedStmt.setString (10, txtPrice.getText());
			    preparedStmt.execute();
			    
			    
			    preparedStmt.close();
			    frame.setVisible(false);
			    }
			    catch (Exception ex)
			    {
			      System.err.println("Got an exception!");
			      System.err.println(ex.getMessage());
			      ex.printStackTrace();
			    }
			}
		});
		btnAddRoom.setFont(new Font("Arial", Font.BOLD, 12));
		btnAddRoom.setBounds(30, 314, 251, 25);
		frame.getContentPane().add(btnAddRoom);
		
		txtRoomsID = new JTextField();
		txtRoomsID.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRoomsID.setBounds(30, 386, 114, 19);
		frame.getContentPane().add(txtRoomsID);
		txtRoomsID.setColumns(10);
		
		btnDeleteRoom = new JButton("Delete Room");
		btnDeleteRoom.addActionListener(new ActionListener() {
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
					stmt1.executeUpdate("DELETE FROM rooms WHERE id='"+txtRoomsID.getText()+"'");
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnDeleteRoom.setFont(new Font("Arial", Font.BOLD, 12));
		btnDeleteRoom.setBounds(164, 383, 117, 25);
		frame.getContentPane().add(btnDeleteRoom);
		
		lblRoom = new JLabel("Room");
		lblRoom.setFont(new Font("Arial", Font.BOLD, 12));
		lblRoom.setBounds(33, 70, 70, 15);
		frame.getContentPane().add(lblRoom);
		
		lblBeds = new JLabel("Beds");
		lblBeds.setFont(new Font("Arial", Font.BOLD, 12));
		lblBeds.setBounds(33, 117, 70, 15);
		frame.getContentPane().add(lblBeds);
		
		lblSingleBed = new JLabel("SingleBed");
		lblSingleBed.setFont(new Font("Arial", Font.BOLD, 12));
		lblSingleBed.setBounds(33, 160, 70, 15);
		frame.getContentPane().add(lblSingleBed);
		
		DoubleBed = new JLabel("DoubleBed");
		DoubleBed.setFont(new Font("Arial", Font.BOLD, 12));
		DoubleBed.setBounds(33, 206, 70, 15);
		frame.getContentPane().add(DoubleBed);
		
		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Arial", Font.BOLD, 12));
		lblCategory.setBounds(33, 256, 70, 15);
		frame.getContentPane().add(lblCategory);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setBounds(167, 69, 70, 15);
		frame.getContentPane().add(lblName);
		
		lblPersons = new JLabel("Persons");
		lblPersons.setFont(new Font("Arial", Font.BOLD, 12));
		lblPersons.setBounds(167, 113, 70, 15);
		frame.getContentPane().add(lblPersons);
		
		lblDateFrom = new JLabel("Date From");
		lblDateFrom.setFont(new Font("Arial", Font.BOLD, 12));
		lblDateFrom.setBounds(167, 160, 70, 15);
		frame.getContentPane().add(lblDateFrom);
		
		lblDateTo = new JLabel("Date To");
		lblDateTo.setFont(new Font("Arial", Font.BOLD, 12));
		lblDateTo.setBounds(167, 209, 70, 15);
		frame.getContentPane().add(lblDateTo);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrice.setBounds(167, 256, 70, 15);
		frame.getContentPane().add(lblPrice);
		
		lblRoomsID = new JLabel("Room's ID");
		lblRoomsID.setFont(new Font("Arial", Font.BOLD, 12));
		lblRoomsID.setBounds(30, 359, 70, 15);
		frame.getContentPane().add(lblRoomsID);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 69, 710, 486);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtFrom = new JTextField();
		txtFrom.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFrom.setBounds(30, 454, 114, 19);
		frame.getContentPane().add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTo.setBounds(167, 454, 114, 19);
		frame.getContentPane().add(txtTo);
		txtTo.setColumns(10);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 12));
		txtID.setBounds(30, 502, 114, 19);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
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
					stmt1.executeUpdate("UPDATE rooms SET datefrom='"+txtFrom.getText()+"', dateto='"+txtTo.getText()+"' WHERE id='"+txtID.getText()+"'");
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 12));
		btnUpdate.setBounds(167, 499, 117, 25);
		frame.getContentPane().add(btnUpdate);
		
		lblFrom = new JLabel("Date From");
		lblFrom.setFont(new Font("Arial", Font.BOLD, 12));
		lblFrom.setBounds(33, 427, 70, 15);
		frame.getContentPane().add(lblFrom);
		
		lblTo = new JLabel("Date To");
		lblTo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTo.setBounds(167, 427, 70, 15);
		frame.getContentPane().add(lblTo);
		
		lblID = new JLabel("Room's ID");
		lblID.setFont(new Font("Arial", Font.BOLD, 12));
		lblID.setBounds(33, 475, 70, 15);
		frame.getContentPane().add(lblID);
		frame.setBounds(100, 100, 1041, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
