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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class logadm2 {

	static JFrame frame;
	private JTextField ust1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logadm2 window = new logadm2();
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
	private JPasswordField pswt1;
	public logadm2() {
		initialize();
		 connection=sqlConnection1.dbConnecter();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 426, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ust1 = new JTextField();
		ust1.setBounds(127, 94, 162, 45);
		frame.getContentPane().add(ust1);
		ust1.setColumns(10);
		pswt1 = new JPasswordField();
		pswt1.setBounds(125, 150, 164, 45);
		frame.getContentPane().add(pswt1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image  img92=new ImageIcon(this.getClass().getResource("/leoni-_1_.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img92));
		lblNewLabel.setBounds(277, -14, 133, 73);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Username");
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel1.setBounds(26, 94, 91, 45);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel_1 = new JLabel("Passeword");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 153, 91, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Ajouter une table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					String querry ="select * from login1 where nom=? and password= ?";
					PreparedStatement pst=connection.prepareStatement(querry);
					
					pst.setString(1, ust1.getText());
					pst.setString(2, pswt1.getText());
					ResultSet rs=pst.executeQuery();
					
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					if(count==1)
					{
					
						add_tab f =new add_tab();
						 f.frame.setVisible(true);
						 logadm2.frame.setVisible(false);
					}else if(count>1)
					{
						JOptionPane.showMessageDialog(null,"duplicated username or password ");
					}
					
					else 
					{
						JOptionPane.showMessageDialog(null, "  username or password is wrong or access prohibited for users  repeat again please !!! ");
					}
					 rs.close();
					 connection.close();
					
					}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
				
				
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(195, 236, 162, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(62, 236, 89, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		


	}
}

