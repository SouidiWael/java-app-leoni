import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
public class sqlConnection1 
{
	Connection conn=null ;
	public static Connection dbConnecter()
	{
		try 
		{ 
			Class.forName("org.sqlite.JDBC");
		Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\OctaNet\\Desktop\\leoniDB.db");
		//JOptionPane.showInternalMessageDialog(null ,"connection successfull");
		return conn ;
			
		}catch(Exception e)
		{
			JOptionPane.showInternalMessageDialog(null, e);
			return null ;
			
		}
	}

}
