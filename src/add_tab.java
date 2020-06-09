import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class add_tab {

	static JFrame frame;
	private JTextField txtadd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_tab window = new add_tab();
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
	Connection connection=null ;
	public add_tab() {
	initialize();
	 connection=sqlConnection1.dbConnecter();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 355, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	txtadd = new JTextField();
	txtadd.setBounds(70, 118, 205, 38);
	frame.getContentPane().add(txtadd);
	txtadd.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("ajouter une table");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	lblNewLabel.setBounds(112, 69, 175, 38);
	frame.getContentPane().add(lblNewLabel);
	JLabel label_4 = new JLabel("");
	label_4.setBounds(204, -15, 185, 68);
	Image  img11=new ImageIcon(this.getClass().getResource("/leoni-_1_.jpg")).getImage();
	label_4.setIcon(new ImageIcon(img11));  
	frame.getContentPane().add(label_4);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setBounds(229, 11, 46, 14);
	frame.getContentPane().add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("SAVE");
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) 
		{
			
		
			try {
				
				String query ="insert into réference_table (ref_table) values (?)";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, txtadd.getText() );
				 pst.execute();
				
				JOptionPane.showMessageDialog(null,"Data saved");
				
				connection.close();;
				
			}catch(Exception e1)
			{
				e1.printStackTrace();
			
			}
			
		}
			
	}
			
			
		);
		
	btnNewButton.setBounds(141, 167, 67, 38);
	frame.getContentPane().add(btnNewButton);
	
	
	
	
	}
}