import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class sqlExcel1
{
	public Connection conn=null ;
	public static Connection dbAConnecter()
	{
		try 
		{ Class.forName("org.sqlite.JDBC");
		Connection conn1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\OctaNet\\Desktop\\leonidb_Excel.db");
		//JOptionPane.showInternalMessageDialog(null ,"connection successfull");
		return conn1;
			
		}catch(Exception e)
		{
			JOptionPane.showInternalMessageDialog(null, e);
			return null ;
			
		}
		
	}

}
