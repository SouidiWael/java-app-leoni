import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class cacc1 {

	static JFrame frame;
	private JTextField txtm;
	private JTextField txtn;
	private JTextField txtpass;
	private JLabel label_6;
	private JComboBox comboBox22;
	private JLabel lbltime;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cacc1 window = new cacc1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 *
	 */
	
	
	Connection connection=null ;
		public cacc1() {
		initialize();
		
		 connection=sqlConnection1.dbConnecter();
		}


		Thread clock3=new Thread()
		{
			public void run()
			{
				try 
				{
					for(;;) {
		Date d=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
		
		lbltime.setText(sdf.format(d));
		label_6.setText(sdf2.format(d));
			
		 
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 326, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtm = new JTextField();
		txtm.setBounds(96, 106, 115, 42);
		frame.getContentPane().add(txtm);
		txtm.setColumns(10);
		
		txtn = new JTextField();
		txtn.setBounds(96, 152, 115, 42);
		frame.getContentPane().add(txtn);
		txtn.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setBounds(96, 201, 115, 42);
		frame.getContentPane().add(txtpass);
		txtpass.setColumns(10);
		
		JLabel lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblUser.setBounds(10, 263, 76, 20);
		frame.getContentPane().add(lblUser);
		
		final JComboBox comboBox22 = new JComboBox();
		comboBox22.addItem("Admin"); 
		comboBox22.addItem("Utilisateur");
		comboBox22.setBackground(new Color(255, 255, 255));
		comboBox22.setBounds(96, 254, 115, 42);
		frame.getContentPane().add(comboBox22);
		
		
		JButton btnSave = new JButton("save");
		btnSave.setBackground(new Color(128, 128, 128));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					
					String query ="insert into login1 (matricule,nom,password,User) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtm.getText() );
					pst.setString(2, txtn.getText() );
					
					pst.setString(3, txtpass.getText() );
					String combo =comboBox22.getSelectedItem().toString();
			      	pst.setString(4, combo);
					
					 pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					connection.close();
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				
				}
				
			}
				
		}
				
				
			);
		
		 
	
		btnSave.setBounds(186, 307, 76, 34);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("back");
		btnCancel.setBackground(new Color(128, 128, 128));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				test f =new test();
				 f.frame.setVisible(true);
				 cacc1.frame.setVisible(false);
			}
		});
		btnCancel.setBounds(38, 307, 76, 34);
		frame.getContentPane().add(btnCancel);
		
		JLabel label = new JLabel("matricule:");
		label.setFont(new Font("Sitka Small", Font.BOLD, 13));
		label.setBounds(10, 108, 76, 42);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		label_1.setBounds(10, 154, 76, 42);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Pasword:");
		label_2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		label_2.setBounds(10, 207, 76, 42);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("create account");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(80, 53, 148, 42);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(178, -12, 151, 56);
		Image  img11=new ImageIcon(this.getClass().getResource("/leoni-_1_.jpg")).getImage();
		label_4.setIcon(new ImageIcon(img11));  
		frame.getContentPane().add(label_4);
		
	    lbltime = new JLabel("New label");
		lbltime.setBounds(10, 8, 91, 34);
		frame.getContentPane().add(lbltime);
		
		label_6 = new JLabel("New label");
		label_6.setBounds(10, 32, 91, 34);
		frame.getContentPane().add(label_6);
		
		
		
		clock3.start();
			
	
	}
}