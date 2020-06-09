import java.awt.EventQueue;


import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.SystemColor;
public class test {

	static JFrame frame;
	private JTextField txtun;
	private JPasswordField txtpsw;
	private JLabel lbltime;
	private JLabel lbldate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
		
		 connection=sqlConnection1.dbConnecter();
		 
	}
	Thread clock2=new Thread()
	{
		public void run()
		{
			try 
			{
				for(;;) {
	Date d=new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
	
	 lbldate.setText(sdf.format(d));
	 lbltime.setText(sdf2.format(d));
		
	 
		sleep(1000);
		}
		}catch (InterruptedException e) 
		{
	    	e.printStackTrace();
		
		}
	}
};



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Siemens Logo", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(0, 255, 0));
		frame.setBounds(100, 100, 524, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel.setBounds(72, 159, 80, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_1.setBounds(72, 217, 80, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtun = new JTextField();
		txtun.setBounds(162, 157, 184, 38);
		frame.getContentPane().add(txtun);
		txtun.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					String querry ="select * from login1 where nom=? and password=?";
					PreparedStatement pst=connection.prepareStatement(querry);
					pst.setString(1, txtun.getText());
					pst.setString(2, txtpsw.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					if(count==1)
					{
					
						frame22 f =new frame22();
						 f.frame.setVisible(true);
						 test.frame.setVisible(false);
					}else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "duplicated username or password ");
					}else
					{
						JOptionPane.showMessageDialog(null, "username or password is wrong");
					}
					
					 rs.close();
					connection.close();
				}catch(Exception e)
				
				{
					//JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		JButton btnCreateAccount = new JButton("cr\u00E9er un compte ");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logadm1 f =new logadm1();
				 f.frame.setVisible(true);
				 cacc1.frame.setVisible(false);
			}
		});
		btnCreateAccount.setForeground(Color.BLACK);
		btnCreateAccount.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnCreateAccount.setBackground(SystemColor.textHighlightText);
		btnCreateAccount.setBounds(162, 295, 184, 29);
		frame.getContentPane().add(btnCreateAccount);
		
		btnNewButton.setBounds(198, 255, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		txtpsw = new JPasswordField();
		txtpsw.setBounds(162, 206, 184, 38);
		frame.getContentPane().add(txtpsw);
		
				
		JLabel lbl2 = new JLabel("");
		Image  img=new ImageIcon(this.getClass().getResource("/vw.png")).getImage();
		lbl2.setIcon(new ImageIcon(img));
		lbl2.setBounds(147, -17, 199, 163);
		frame.getContentPane().add(lbl2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image  img1=new ImageIcon(this.getClass().getResource("/icons8-tunisia-48.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(10, -11, 70, 107);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image  img2=new ImageIcon(this.getClass().getResource("/icons8-germany-48.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		lblNewLabel_3.setBounds(50, -11, 70, 107);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabe = new JLabel("");
		Image  img9=new ImageIcon(this.getClass().getResource("/leoni-_1_.jpg")).getImage();
		lblNewLabe.setIcon(new ImageIcon(img9));
		lblNewLabe.setBounds(368, 0, 130, 76);
		frame.getContentPane().add(lblNewLabe);
		
		lbltime = new JLabel("Time");
		lbltime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbltime.setBounds(376, 101, 122, 45);
		frame.getContentPane().add(lbltime);
		
		lbldate = new JLabel("New label");
		lbldate.setBackground(new Color(240, 240, 240));
		lbldate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbldate.setBounds(378, 74, 131, 38);
		frame.getContentPane().add(lbldate);
		
		JButton btnNewButton_1 = new JButton("ajouter une table ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logadm2 f =new logadm2();
				 f.frame.setVisible(true);
				test.frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBackground(SystemColor.textHighlightText);
		btnNewButton_1.setBounds(162, 335, 184, 29);
		frame.getContentPane().add(btnNewButton_1);
		clock2.start();
	}

}

