import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SmartBookingOwner {

	private JFrame frame;
	private JTextField txtTitle;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDiscount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartBookingOwner window = new SmartBookingOwner();
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
	public SmartBookingOwner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 588, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTitle.setBounds(48, 107, 127, 37);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		txtFrom = new JTextField();
		txtFrom.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFrom.setBounds(188, 107, 127, 37);
		frame.getContentPane().add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTo.setBounds(327, 107, 127, 37);
		frame.getContentPane().add(txtTo);
		txtTo.setColumns(10);
		
		txtDiscount = new JTextField();
		txtDiscount.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiscount.setBounds(472, 107, 59, 37);
		frame.getContentPane().add(txtDiscount);
		txtDiscount.setColumns(10);
		
		JCheckBox cStandard = new JCheckBox("Standard");
		cStandard.setFont(new Font("Arial", Font.BOLD, 12));
		cStandard.setBackground(new Color(255, 255, 255));
		cStandard.setBounds(48, 215, 129, 23);
		frame.getContentPane().add(cStandard);
		
		JCheckBox cComfort = new JCheckBox("Comfort");
		cComfort.setFont(new Font("Arial", Font.BOLD, 12));
		cComfort.setBackground(new Color(255, 255, 255));
		cComfort.setBounds(188, 215, 129, 23);
		frame.getContentPane().add(cComfort);
		
		JCheckBox cSuite = new JCheckBox("Suite");
		cSuite.setFont(new Font("Arial", Font.BOLD, 12));
		cSuite.setBackground(new Color(255, 255, 255));
		cSuite.setBounds(327, 215, 129, 23);
		frame.getContentPane().add(cSuite);
		
		JButton btnMake = new JButton("Make Offer");
		btnMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				//Connection conn2 = null;
				//Connection conn3 = null;
				Statement stmt = null;
				//ResultSet rs = null;
				
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
				
				//conn2 = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				//conn3 = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				stmt = conn.createStatement();
				String query = "INSERT INTO offers (title, DiscFrom, DiscTo, discount, category1, category2, category3) VALUES (?,?,?,?,?,?,?)";
				String query2 = "UPDATE rooms SET discount='"+txtDiscount.getText()+"', DiscFrom='"+txtFrom.getText()+"', DiscTo='"+txtTo.getText()+"' WHERE category='"+category1()+"' OR category='"+category2()+"' OR category='"+category3()+"'";
				//String query3 = "SELECT * FROM offers WHERE title='"+txtTitle.getText()+"', DiscFrom='"+txtFrom.getText()+"', DiscTo='"+txtTo.getText()+"', discount='"+txtDiscount.getText()+"', category1='"+category1()+"', category2='"+category2()+"', category3='"+category3()+"';";
				
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			    preparedStmt.setString (1, txtTitle.getText());
			    preparedStmt.setString (2, txtFrom.getText());
			    preparedStmt.setString (3, txtTo.getText());
			    preparedStmt.setString (4, txtDiscount.getText());
			    preparedStmt.setString (5, category1());
			    preparedStmt.setString (6, category2());
			    preparedStmt.setString (7, category3());
			    preparedStmt.execute();
			    
			    
			    preparedStmt.close();
			    //----------------------------------
			    stmt.executeUpdate(query2);
			    /*PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
			    preparedStmt2.setString (1, txtDiscount.getText());
			    preparedStmt2.setString (2, txtFrom.getText());
			    preparedStmt2.setString (3, txtTo.getText());
			    
			    preparedStmt2.execute();
			    
			    
			    preparedStmt2.close();*/
			    //rs.close();
			    }
			    catch (Exception ex)
			    {
			      System.err.println("Got an exception!");
			      System.err.println(ex.getMessage());
			      ex.printStackTrace();
			    }
			}
			public String category1()
			{
			    if(cStandard.isSelected())
			    {
			        return "standard";
			    }
			    else
			    {
			        return "none";
			    }
			}
			
			public String category2()
			{
			    if(cComfort.isSelected())
			    {
			        return "comfort";
			    }
			    else
			    {
			        return "none";
			    }
			}
			
			public String category3()
			{
			    if(cSuite.isSelected())
			    {
			        return "suite";
			    }
			    else
			    {
			        return "none";
			    }
			}
		});
		btnMake.setBounds(48, 275, 152, 25);
		frame.getContentPane().add(btnMake);
		
		JButton btnStats = new JButton("Statistics");
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SmartBookingOwnerStats.stats();
			}
		});
		btnStats.setBounds(215, 275, 152, 25);
		frame.getContentPane().add(btnStats);
		
		JLabel lblNewLabel = new JLabel("Offer Title");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(48, 80, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(190, 80, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(333, 80, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Discount %");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(472, 80, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Owner's Panel");
		lblNewLabel_4.setForeground(new Color(255, 102, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(239, 26, 175, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy.setFont(new Font("Arial", Font.BOLD, 12));
		lblDdmmyyyy.setBounds(188, 161, 93, 15);
		frame.getContentPane().add(lblDdmmyyyy);
		
		JLabel lblDdmmyyyy_1 = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblDdmmyyyy_1.setBounds(327, 161, 104, 15);
		frame.getContentPane().add(lblDdmmyyyy_1);
		
		JButton btnDelete = new JButton("Delete Offers");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				SmartBookOwnerDelOffers.deleteOffers();
			}
		});
		btnDelete.setBounds(379, 275, 152, 25);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblPercent = new JLabel("NN %");
		lblPercent.setFont(new Font("Arial", Font.BOLD, 12));
		lblPercent.setBounds(482, 156, 70, 15);
		frame.getContentPane().add(lblPercent);
	}
}
