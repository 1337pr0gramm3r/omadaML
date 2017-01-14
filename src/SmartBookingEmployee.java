import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.sql.Date;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.awt.Panel;


import javax.swing.table.DefaultTableModel;

public class SmartBookingEmployee {

	private JFrame frame;
	private JTextField txtArrival;
	private JTextField txtDeparture;
	private JTextField txtPersons;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartBookingEmployee window = new SmartBookingEmployee();
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
	public SmartBookingEmployee() {
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
		frame.setBounds(100, 100, 964, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Arrival");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(335, 83, 58, 15);
		frame.getContentPane().add(label);
		
		txtArrival = new JTextField();
		txtArrival.setFont(new Font("Arial", Font.BOLD, 12));
		txtArrival.setColumns(10);
		txtArrival.setBounds(335, 110, 148, 27);
		frame.getContentPane().add(txtArrival);
		
		txtDeparture = new JTextField();
		txtDeparture.setColumns(10);
		txtDeparture.setBounds(495, 110, 148, 27);
		frame.getContentPane().add(txtDeparture);
		
		txtPersons = new JTextField();
		txtPersons.setColumns(10);
		txtPersons.setBounds(655, 110, 58, 27);
		frame.getContentPane().add(txtPersons);
		
		JLabel label_1 = new JLabel("Departure");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(495, 83, 70, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Persons");
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		label_2.setBounds(655, 83, 70, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("DD/MM/YYYY");
		label_3.setFont(new Font("Arial", Font.BOLD, 12));
		label_3.setBounds(335, 149, 84, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("DD/MM/YYYY");
		label_4.setFont(new Font("Arial", Font.BOLD, 12));
		label_4.setBounds(505, 149, 70, 15);
		frame.getContentPane().add(label_4);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
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
					String persons = txtPersons.getText();
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
							
							
							
							
							rs = stmt.executeQuery("SELECT * FROM rooms");
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
		button.setBounds(335, 185, 132, 46);
		frame.getContentPane().add(button);
		
		JLabel lblEmployersPanel = new JLabel("Employee's Panel");
		lblEmployersPanel.setForeground(new Color(255, 102, 0));
		lblEmployersPanel.setFont(new Font("Arial", Font.BOLD, 18));
		lblEmployersPanel.setBounds(447, 35, 183, 15);
		frame.getContentPane().add(lblEmployersPanel);
		
		JButton btnEditRooms = new JButton("Edit Rooms");
		btnEditRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SMEmployeeEdit.editRooms();
			}
		});
		btnEditRooms.setBounds(495, 185, 138, 46);
		frame.getContentPane().add(btnEditRooms);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 261, 940, 286);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
