import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import smartSQL.*;
public class SmartBookingRegister{

	private JFrame frame;
	private JTextField name;
	private JTextField surname;
	private JTextField id;
	private JTextField phone;
	private JTextField email;
	private JPasswordField passwd;
	private JPasswordField passwdconf;

	/**
	 * Launch the application.
	 */
	
	
	public static void Register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					SmartBookingRegister window = new SmartBookingRegister();
					window.frame.setVisible(true);
					// Main code here
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	/**
	 * Create the application.
	 */
	public SmartBookingRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 719, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Smart Hotel !");
		label.setForeground(new Color(255, 51, 0));
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setBounds(208, 27, 313, 35);
		frame.getContentPane().add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setBounds(146, 94, 44, 15);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 12));
		name.setBounds(208, 87, 313, 29);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Arial", Font.BOLD, 12));
		lblSurname.setBounds(132, 133, 58, 15);
		frame.getContentPane().add(lblSurname);
		
		surname = new JTextField();
		surname.setFont(new Font("Arial", Font.PLAIN, 12));
		surname.setBounds(208, 126, 313, 29);
		frame.getContentPane().add(surname);
		surname.setColumns(10);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdNumber.setBounds(131, 171, 59, 15);
		frame.getContentPane().add(lblIdNumber);
		
		id = new JTextField();
		id.setFont(new Font("Arial", Font.PLAIN, 12));
		id.setBounds(208, 164, 313, 29);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblPhoneNumber.setBounds(108, 212, 89, 15);
		frame.getContentPane().add(lblPhoneNumber);
		
		phone = new JTextField();
		phone.setFont(new Font("Arial", Font.PLAIN, 12));
		phone.setBounds(208, 205, 313, 29);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(154, 250, 36, 15);
		frame.getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 12));
		email.setBounds(208, 243, 313, 29);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setBounds(132, 291, 58, 15);
		frame.getContentPane().add(lblPassword);
		
		passwd = new JPasswordField();
		passwd.setFont(new Font("Arial", Font.PLAIN, 12));
		passwd.setBounds(208, 284, 313, 29);
		frame.getContentPane().add(passwd);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblConfirmPassword.setBounds(91, 332, 106, 15);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwdconf = new JPasswordField();
		passwdconf.setFont(new Font("Arial", Font.PLAIN, 12));
		passwdconf.setBounds(208, 325, 313, 29);
		frame.getContentPane().add(passwdconf);
		
		JRadioButton mr = new JRadioButton("Mr");
		mr.setFont(new Font("Arial", Font.BOLD, 12));
		mr.setBackground(new Color(255, 255, 255));
		mr.setBounds(208, 362, 51, 23);
		frame.getContentPane().add(mr);
		
		JRadioButton mrs = new JRadioButton("Mrs");
		mrs.setFont(new Font("Arial", Font.BOLD, 12));
		mrs.setBackground(new Color(255, 255, 255));
		mrs.setBounds(263, 362, 58, 23);
		frame.getContentPane().add(mrs);
		
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 12));
		lblTitle.setBounds(161, 366, 36, 15);
		frame.getContentPane().add(lblTitle);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
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
				String query = "INSERT INTO clients (name, surname, idnumber, phone, email, password, title) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			    preparedStmt.setString (1, name.getText());
			    preparedStmt.setString (2, surname.getText());
			    preparedStmt.setString (3, id.getText());
			    preparedStmt.setString (4, phone.getText());
			    preparedStmt.setString (5, email.getText());
			    preparedStmt.setString (6, passwd.getText());
			    preparedStmt.setString (7, title());
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
			public String title()
			{
			    if(mr.isSelected())
			    {
			        return "Mr";
			    }
			    else if(mrs.isSelected())
			    {
			        return "Mrs";
			    }
			    else
			    {
			        return null;
			    }
			}
			
		});
		btnRegister.setBounds(208, 401, 313, 35);
		frame.getContentPane().add(btnRegister);
		
		
		
		
	}
}
