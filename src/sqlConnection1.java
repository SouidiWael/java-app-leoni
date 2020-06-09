import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
public class sqlConnection1 
{
	Connection connection=null ;
	public static Connection dbConnecter()
	{
		try 
		{ 
			Class.forName("org.sqlite.JDBC");
		Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\OctaNet\\Desktop\\leoniDB.db");
		//JOptionPane.showInternalMessageDialog(null ,"connection successfull");
		return connection ;
			
		}catch(Exception e)
		{
			//JOptionPane.showInternalMessageDialog(null, e);
			return null ;
			
		}
	}

}