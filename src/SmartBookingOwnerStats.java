import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class SmartBookingOwnerStats {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void stats() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartBookingOwnerStats window = new SmartBookingOwnerStats();
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
	public SmartBookingOwnerStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblOwnersPanelstatistics = new JLabel("Owner's Panel (Statistics)");
		lblOwnersPanelstatistics.setForeground(new Color(255, 102, 0));
		lblOwnersPanelstatistics.setFont(new Font("Arial", Font.BOLD, 18));
		lblOwnersPanelstatistics.setBounds(115, 12, 248, 22);
		frame.getContentPane().add(lblOwnersPanelstatistics);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
