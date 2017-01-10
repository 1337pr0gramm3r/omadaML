import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class SmartBookingClient {

	private JFrame frame;
	private JTextField txtArrival;
	private JTextField txtDeparture;
	private JTextField txtPeople;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void Client() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartBookingClient window = new SmartBookingClient();
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
	public SmartBookingClient() {
		initialize();
	}
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Smart Hotel !");
		label.setForeground(new Color(255, 51, 0));
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setBounds(281, 39, 313, 35);
		frame.getContentPane().add(label);
		
		JLabel lblThePlaceThat = new JLabel("The place that makes you smarter!");
		lblThePlaceThat.setForeground(new Color(255, 102, 51));
		lblThePlaceThat.setFont(new Font("Arial", Font.BOLD, 14));
		lblThePlaceThat.setBounds(323, 75, 239, 15);
		frame.getContentPane().add(lblThePlaceThat);
		
		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setFont(new Font("Arial", Font.BOLD, 12));
		lblArrival.setBounds(240, 118, 58, 15);
		frame.getContentPane().add(lblArrival);
		
		txtArrival = new JTextField();
		txtArrival.setFont(new Font("Arial", Font.BOLD, 12));
		txtArrival.setBounds(240, 145, 148, 27);
		frame.getContentPane().add(txtArrival);
		txtArrival.setColumns(10);
		
		txtDeparture = new JTextField();
		txtDeparture.setBounds(400, 145, 148, 27);
		frame.getContentPane().add(txtDeparture);
		txtDeparture.setColumns(10);
		
		txtPeople = new JTextField();
		txtPeople.setBounds(560, 145, 58, 27);
		frame.getContentPane().add(txtPeople);
		txtPeople.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setFont(new Font("Arial", Font.BOLD, 12));
		lblDeparture.setBounds(400, 118, 70, 15);
		frame.getContentPane().add(lblDeparture);
		
		JLabel lblPersons = new JLabel("Persons");
		lblPersons.setFont(new Font("Arial", Font.BOLD, 12));
		lblPersons.setBounds(560, 118, 70, 15);
		frame.getContentPane().add(lblPersons);
		
		JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy.setFont(new Font("Arial", Font.BOLD, 12));
		lblDdmmyyyy.setBounds(240, 184, 84, 15);
		frame.getContentPane().add(lblDdmmyyyy);
		
		JLabel lblDdmmyyyy_1 = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblDdmmyyyy_1.setBounds(410, 184, 70, 15);
		frame.getContentPane().add(lblDdmmyyyy_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Connection conn2 = null;
				Connection conn3 = null;
				Statement stmt = null;
				Statement stmt2 = null;
				Statement stmt3 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ResultSet rs3 = null;
				try
				{
					// Main code here
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://127.0.0.1:3306/smartHotel";
					String connectionUser = "root";
					String connectionPassword = "test123";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					conn2 = DriverManager.getConnection(connectionUrl, connectionUser,
							connectionPassword);
					conn3 = DriverManager.getConnection(connectionUrl, connectionUser,
							connectionPassword);
					stmt = conn.createStatement();
					stmt2 = conn2.createStatement();
					stmt3 = conn3.createStatement();
					int counter = 1;
					int counter2 = 1;
					int counter3 = 0;
					//rs = stmt.executeQuery("SELECT beds, singlebed, doublebed, category, name, discount, persons FROM rooms WHERE id='"+arrOfIDs[counter]+"'");
					rs2 = stmt2.executeQuery("SELECT * FROM rooms");
					rs3 = stmt3.executeQuery("SELECT * FROM rooms");
					String arrive = txtArrival.getText();
					String depart = txtDeparture.getText();
					String persons = txtPeople.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date dateArrive = sdf.parse(arrive);
					java.util.Date dateDepart = sdf.parse(depart);
					while (rs2.next()){
						counter3++;
						
					}
					
					
					while (rs3.next()){
						
							//System.out.println("True");
						
						String rs3ID = rs3.getString("id");
						String from = rs3.getString("datefrom");						
						String to = rs3.getString("dateto");
						String pers = rs3.getString("persons");
						java.util.Date dateFrom = convertJavaDateToSqlDate(sdf.parse(from));
						java.util.Date dateTo = convertJavaDateToSqlDate(sdf.parse(to));
						
						
						if ( (dateArrive.compareTo(dateFrom)<0 && dateDepart.compareTo(dateFrom)<0 && dateArrive.compareTo(dateDepart)<0) || (dateArrive.compareTo(dateTo)>0 && dateDepart.compareTo(dateTo)>0 && dateArrive.compareTo(dateDepart)<0) && pers.equals(persons)){
							
							
							
							
							rs = stmt.executeQuery("SELECT beds, singlebed, doublebed, category, name, discount, DiscFrom, DiscTo, price, persons FROM rooms");
							table.setModel(DbUtils.resultSetToTableModel(rs));
											
							
							
							
							
						}
						
						
					}
					rs3.close();
					rs.close();
					
				}
				
				catch (Exception ex)
				{
						ex.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(377, 222, 132, 46);
		frame.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 280, 768, 216);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.setBounds(100, 100, 827, 537);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
