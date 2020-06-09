
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.Timer;
public class frame22{
	
	static JFrame frame;
	private JTextField txtRft;
	private JTextField txtobj;
    public float y;
    public String z;
    public int x;
    public int b;
    public int y1;
    private JLabel  lblTime;
    private JTextField txttime;
    private JTextField txtqp;
    private JTextField txtshort;
    private JTextField labtime;
    private JTextField labdate;
    private JTextField txtqt;
    private JComboBox combo5;
    
    
	/**
	 * Launch the application.
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					frame22 window = new frame22();
					window.frame.setVisible(true);
					//Reading_excel reading_excel=new Reading_excel();
					//reading_excel.main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
	}
	

	

	Thread clock1=new Thread()
	{
		public void run()
		{
			try 
			{
				for(;;) {
	Date d=new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
	
	 txtdate.setText(sdf.format(d));
	 txttime.setText(sdf2.format(d));
		
	 
		sleep(1000);
		}
		}catch (InterruptedException e) 
		{
	    	e.printStackTrace();
		
		}
	}
};

	
	Connection connection=null ;
	private JTextField textField11111;
	private JTextField txtdate;

	public void Fillcombo()
	{
	
	try {
		String querry ="select * from réference_table";
		PreparedStatement pst=connection.prepareStatement(querry);
		ResultSet rs=pst.executeQuery();
	while (rs.next())	
	{
		
		combo5.addItem(rs.getString("ref_table"));
		
	}
		
	//connection.close();	
	}
	catch(Exception e)
	{
		//JOptionPane.showMessageDialog(null, e);
	}
	}

	
	public frame22() {

	connection=sqlConnection1.dbConnecter();
	Fillcombo();
	initialize();
	
	}
	
	
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 549, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtRft = new JTextField();
		txtRft.setToolTipText("");
		txtRft.setForeground(new Color(0, 0, 0));
		txtRft.setBackground(new Color(255, 255, 255));
		txtRft.setFont(new Font("Imprint MT Shadow", Font.BOLD | Font.ITALIC, 20));
		txtRft.setText("0");
		txtRft.setBounds(347, 105, 125, 40);
		frame.getContentPane().add(txtRft);
		txtRft.setColumns(10);
		
		
		JLabel txtpencore = new JLabel("");
		Image  img4=new ImageIcon(this.getClass().getResource("/icons8-happy-80 (1).png")).getImage();
		txtpencore.setIcon(new ImageIcon(img4));
		txtpencore.setBounds(372, 204, 90, 81);
		frame.getContentPane().add(txtpencore);
		
	
		JLabel lblNewLabel_6 = new JLabel("");
		Image  img6=new ImageIcon(this.getClass().getResource("/icons8-smiling-96 (1).png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img6));
		lblNewLabel_6.setBounds(405, -21, 151, 96);
		frame.getContentPane().add(lblNewLabel_6);
		Image  img7=new ImageIcon(this.getClass().getResource("/leoni-_1_.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img7));
		
	
		
		JLabel triste = new JLabel("");
		Image  img5=new ImageIcon(this.getClass().getResource("/icons8-sad-80.png")).getImage();
		triste.setIcon(new ImageIcon(img5));
		triste.setBounds(372, 204, 90, 91);
		frame.getContentPane().add(triste);
		
		
		
		JLabel heureux = new JLabel("");
		Image  img8=new ImageIcon(this.getClass().getResource("/icons8-smiling-96 (1).png")).getImage();
		heureux.setIcon(new ImageIcon(img8));
		heureux.setBounds(362, 204, 126, 81);
		frame.getContentPane().add(heureux);
		
		txtobj = new JTextField();
		txtobj.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtobj.setBounds(156, 91, 126, 40);
		frame.getContentPane().add(txtobj);
		txtobj.setColumns(10);
	
	
        
		JLabel lblObjectif = new JLabel("objectif =");
		lblObjectif.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblObjectif.setBounds(10, 94, 80, 38);
		frame.getContentPane().add(lblObjectif);
		
		JLabel lblQuantiProduite_1 = new JLabel("quanti\u00E9  produite  = ");
		lblQuantiProduite_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblQuantiProduite_1.setBounds(10, 194, 158, 38);
		frame.getContentPane().add(lblQuantiProduite_1);
		
		txtqp = new JTextField();
		txtqp.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtqp.setColumns(10);
		txtqp.setText("0");
		txtqp.setForeground(new Color(0, 0, 0));
		txtqp.setBounds(156, 191, 126, 40);
		frame.getContentPane().add(txtqp);
		
		txtshort = new JTextField();
		txtshort.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtshort.setColumns(10);
		txtshort.setText("0");
		txtshort.setBounds(157, 240, 125, 40);
		frame.getContentPane().add(txtshort);
		
		txtqt = new JTextField();
		txtqt.setBackground(new Color(255, 255, 255));
	    txtqt.setForeground(new Color(0, 0, 0));
		txtqt.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtqt.setBounds(156, 143, 126, 37);
		frame.getContentPane().add(txtqt);
		txtqt.setColumns(10);
		
		JLabel lblShort = new JLabel("short = ");
		lblShort.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblShort.setBounds(10, 243, 80, 38);
		frame.getContentPane().add(lblShort);
	
		
		JButton btnCalculer = new JButton("calculer");
		btnCalculer.setBackground(new Color(70, 130, 180));
		
		txtpencore.setVisible(false);
		triste.setVisible(false);
		heureux.setVisible(false);
		
		combo5 = new JComboBox(); 
	    combo5.setBounds(197, 38, 151, 27);
		frame.getContentPane().add(combo5);
		Fillcombo();
		    
		/**************************************************************************************************/
		
		btnCalculer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{
			      z = txtobj.getText();
				      if(z!="") {
					  y = (Float.parseFloat(z))/8;
					  y1 = Math.round(y);
					 txtqt.setText(y1+"   "+"câblage/heure");
				}
				 
				
				
			}
			

			private int parseInt(float y) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		
		
				);
		
		
		
		
		    ////////////////////////////////////////////////////////////////////////////////////////////
		btnCalculer.setBounds(156, 291, 126, 40);
		frame.getContentPane().add(btnCalculer);
		
		JLabel lblQuantiteAProduite = new JLabel("quantite a produire=");
		lblQuantiteAProduite.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblQuantiteAProduite.setBounds(10, 153, 158, 20);
		frame.getContentPane().add(lblQuantiteAProduite);
		
		JLabel lblNewLabel_1 = new JLabel("RFT=");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 23));
		lblNewLabel_1.setBounds(283, 95, 92, 69);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(477, 83, 46, 81);
		frame.getContentPane().add(lblNewLabel_2);
		
	    lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblTime.setBounds(10, 62, 46, 14);
		frame.getContentPane().add(lblTime);
		
		txttime = new JTextField();
		txttime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txttime.setBackground(Color.WHITE);
		txttime.setBounds(52, 51, 98, 32);
		frame.getContentPane().add(txttime);
		txttime.setColumns(10);
		
		JLabel lblRfTable = new JLabel("R\u00E9f Table");
		lblRfTable.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblRfTable.setBounds(244, 10, 104, 28);
		frame.getContentPane().add(lblRfTable);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 16, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtdate = new JTextField();
		txtdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtdate.setBounds(52, 11, 98, 29);
		frame.getContentPane().add(txtdate);
		txtdate.setColumns(10);
		
		
		try
		{
		String querry ="select * from Product";
		PreparedStatement pst1=connection.prepareStatement(querry);
		ResultSet rs=pst1.executeQuery();
		String inter = new String();       
		int num=0; 
		String inter1=new String();  
		int num1=0;               
		String inter2=new String();
		float num2=new Float("0");
		float qt=1;
		float qr=1;
		float w;
		
		while(rs.next())
		{ 
			
			if ((rs.getInt(2)!=0)&&(rs.getInt(3)==0))
			{
				
				inter= txtqp.getText();
				num=Integer.parseInt(inter);
				num++;
			    inter=num+"";
			    txtqp.setText(inter);
			}
			if (rs.getInt(3)==1)
			{   
				inter1= txtshort.getText();
				num1=Integer.parseInt(inter1);
				num1++;
				inter1=num1+"";
				txtshort.setText(inter1);
			}
			
			
			if ((rs.getInt(2)==1)&&(rs.getInt(3)==0))
			{
				inter2= txtRft.getText();
				num2=Float.parseFloat(inter2);
				num2++;
				qt=Float.parseFloat(txtqp.getText());
				
				
			}
			
		}
		num2=((num2/qt)*100);
		inter2=Float.toString(num2);
	
				
		txtRft.setText(inter2);
				if(num2>50)
				{
				heureux.setVisible(true);
				 
				}else
				{
				heureux.setVisible(false);	
				}
			
				if((num2>=30)&&(num2<=50))
				{
				txtpencore.setVisible(true);
				 
				}else
				{
				txtpencore.setVisible(false);	
				}
		
				if(num2<30)
				{
				triste.setVisible(true);
				 
				}else
				{
				triste.setVisible(false);	
				}
		
		
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(null, e);
		}

	
Thread qr =new Thread()
{
	public void run()
	{
		try 
		{
			for(;;) {
				
				String query ="insert into compte_rendu1 (nom_table,Objectif,quantite_a_produire,quatite_produite,Short,RFT,Date,Time) values (?,?,?,?,?,?,?,?)";
				PreparedStatement pst=connection.prepareStatement(query);
				String combo50 =combo5.getSelectedItem().toString();
		      	pst.setString(1, combo50);
		    	pst.setString(2, txtobj.getText() );
		    	pst.setString(3, txtqt.getText());	 
		    	pst.setString(4, txtqp.getText());
		    	pst.setString(5, txtshort.getText());
				pst.setString(6, txtRft.getText() );
				pst.setString(7, txtdate.getText());
				pst.setString(8, txttime.getText());
				pst.execute();
				
				//JOptionPane.showMessageDialog(null,"Data saved");
			
				
	sleep(8000);
	}
		
	}catch (InterruptedException e) 
	{
    	e.printStackTrace();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
};

	clock1.start();
	qr.start();
	
	
}
	
	}
