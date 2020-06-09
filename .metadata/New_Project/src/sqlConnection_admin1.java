import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class sqlConnection_admin1 
{
	Connection conn=null ;
	public static Connection dbConnecter()
	{
		try 
		{ Class.forName("org.sqlite.JDBC");
		Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\OctaNet\\Desktop\\leonidb_admin.db");
		//JOptionPane.showInternalMessageDialog(null ,"connection successfull");
		return conn ;
			
		}catch(Exception e)
		{
			JOptionPane.showInternalMessageDialog(null, e);
			return null ;
			
		}
	}

}
