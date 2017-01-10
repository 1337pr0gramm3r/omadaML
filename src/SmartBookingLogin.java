import java.awt.EventQueue;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class SmartBookingLogin {

	private JFrame frame;
	private JPasswordField passwordF;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartBookingLogin window = new SmartBookingLogin();
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
	public SmartBookingLogin() {
		initialize();
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(113, 101, 220, 34);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(113, 168, 220, 34);
		frame.getContentPane().add(passwordF);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Arial", Font.BOLD, 12));
		email.setBounds(113, 74, 113, 15);
		frame.getContentPane().add(email);
		
		JLabel passwd = new JLabel("Password");
		passwd.setFont(new Font("Arial", Font.BOLD, 12));
		passwd.setBounds(113, 147, 80, 15);
		frame.getContentPane().add(passwd);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				String result = "";
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
				rs = stmt.executeQuery("SELECT * FROM clients");
				//String result = "";
				while (rs.next())
					{
					
				    String mail = rs.getString("email");
					
					String password = rs.getString("password");
					
					if (mail.equals(txtEmail.getText())){
						if (password.equals(String.valueOf(passwordF.getPassword()))){
							result = "Success!";
							
							break;
						}
					}
					else{
						result = "Looser";
					}
					}
				    if (result == "Success!"){
				    	SmartBookingClient cl = new SmartBookingClient();
				    	cl.Client();
				    	frame.setVisible(false);
				    }
				    
				    
				   //this.dispose();
			       //new SmartBookingClient().dispose(true);
				  
				   //Class.forName("SmartBookingClient");
				   //ClassLoader.getSystemClassLoader().load("SmartBookingClient.java");
			}
				
			catch (Exception ex)
			{
					ex.printStackTrace();
			}
			}
		});
		
		
		btnNewButton.setBounds(113, 214, 220, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblWelcomeToSmart = new JLabel("Welcome To Smart Hotel !");
		lblWelcomeToSmart.setFont(new Font("Arial", Font.BOLD, 24));
		lblWelcomeToSmart.setForeground(new Color(255, 51, 0));
		lblWelcomeToSmart.setBounds(79, 12, 313, 35);
		frame.getContentPane().add(lblWelcomeToSmart);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SmartBookingRegister re = new SmartBookingRegister();
		    	re.Register();
			}
		});
		lblRegister.setForeground(new Color(102, 51, 0));
		lblRegister.setFont(new Font("Arial", Font.BOLD, 12));
		lblRegister.setBounds(113, 295, 70, 15);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblResult = new JLabel("");
		lblResult.setBounds(113, 251, 70, 15);
		frame.getContentPane().add(lblResult);
	
	}
}
