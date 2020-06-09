package leoni;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class tESTaPPLICATION {
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
					test1 window = new test1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void clock()
	{	
     Calendar cal = new GregorianCalendar();
     int day=cal.get(Calendar.DAY_OF_MONTH);
     int month=cal.get(Calendar.MONTH);
     int year=cal.get(Calendar.YEAR);
     //txtdate.setText(+year+":"+month+":"+day);

     int second=cal.get(Calendar.SECOND);
     int minute=cal.get(Calendar.MINUTE);
     int hour=cal.get(Calendar.HOUR);

     lbltime.setText("time "+hour+":"+minute+":"+second);
     lbldate.setText(" date " +year+":"+month+":"+day);
 
 
 
}


	/**
	 * Create the application.
	 */
	Connection connection=null ;
	private JTextField txtdate;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public tESTaPPLICATION() {
		initialize();
		 connection=sqlConnection.dbConnecter();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(0, 255, 0));
		frame.setBounds(100, 100, 524, 376);
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
		btnNewButton.setBackground(new Color(112, 128, 144));
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String querry ="select * from login where nom=? and password=?";
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
					
						frame2 f =new frame2();
						 f.frame.setVisible(true);
						 test1.frame.setVisible(false);
					}else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "duplicated username or password ");
					}else
					{
						JOptionPane.showMessageDialog(null, "username or password is wrong");
					}
					
					 rs.close();
					 pst.close();
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		JButton btnCreateAccount = new JButton("cr\u00E9er un compte ");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logadm f =new logadm();
				 f.frame.setVisible(true);
				 cacc.frame.setVisible(false);
			}
		});
		btnCreateAccount.setForeground(Color.BLACK);
		btnCreateAccount.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnCreateAccount.setBackground(new Color(112, 128, 144));
		btnCreateAccount.setBounds(316, 279, 171, 29);
		frame.getContentPane().add(btnCreateAccount);
		
		btnNewButton.setBounds(177, 279, 115, 29);
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
		

		
		lbldate = new JLabel("date");
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbldate.setBounds(356, 155, 130, 42);
		frame.getContentPane().add(lbldate);
		
		lbltime = new JLabel("time");
		lbltime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltime.setBounds(356, 204, 140, 42);
		frame.getContentPane().add(lbltime);
		txtdate.setColumns(10);
		
	}
}

