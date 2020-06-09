import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JFrame;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JComboBox;

public class logadm1 {

	protected static final Object Utilisateur = null;
	static JFrame frame;
	private JTextField ust;
	private JPasswordField pswt;
	private JComboBox comboBox33;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logadm1 window = new logadm1();
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
	public logadm1() {
		initialize();
		 connection=sqlConnection1.dbConnecter();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblUsername.setBounds(40, 69, 100, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblPassword.setBounds(40, 125, 108, 23);
		frame.getContentPane().add(lblPassword);
		
		ust = new JTextField();
		ust.setBackground(new Color(248, 248, 255));
		ust.setBounds(150, 61, 139, 35);
		frame.getContentPane().add(ust);
		ust.setColumns(10);
		
		pswt = new JPasswordField();
		pswt.setBackground(new Color(248, 248, 255));
		pswt.setBounds(150, 117, 139, 35);
		frame.getContentPane().add(pswt);
		
		JButton btnOk = new JButton("cr\u00E9er compte");
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					
					String querry ="select * from login1 where nom=? and password=?";
					PreparedStatement pst=connection.prepareStatement(querry);
					
					pst.setString(1, ust.getText());
					pst.setString(2, pswt.getText());
                   
					ResultSet rs=pst.executeQuery();
					
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					if(count==1)
					{
					
						cacc1 f =new cacc1();
						 f.frame.setVisible(true);
						 logadm1.frame.setVisible(false);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		Image  img92=new ImageIcon(this.getClass().getResource("/leoni-_1_.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img92));
		lblNewLabel.setBounds(301, -21, 133, 73);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test f =new test();
				 f.frame.setVisible(true);
				 cacc1.frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton.setBounds(56, 203, 92, 35);
		frame.getContentPane().add(btnNewButton);
		btnOk.setBounds(252, 200, 139, 35);
		frame.getContentPane().add(btnOk);
		
	
		JButton btnNewButton1 = new JButton("Back");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_tab f =new add_tab();
				 f.frame.setVisible(true);
				 add_tab.frame.setVisible(false);
			}
		
			
		});
		
		
	}
}
