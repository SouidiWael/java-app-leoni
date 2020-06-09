
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Reading_excel {
	public static void main (String[] args){
		
		
		try {
		Connection connection =sqlConnection1.dbConnecter();
		String query ="insert into Product values(?,?,?,?,?,?,?,?)";
		String deleteQuery = "delete from Product"; 
		//CRUD
		Statement deleteStatement = connection.createStatement();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		
		while(true){
			
			 ArrayList<Product> listProduct = getListProductFromTextFile("C:\\Users\\OctaNet\\Desktop\\data5.csv");
			 deleteStatement.executeUpdate(deleteQuery);
			 System.out.println("Insert Again");
			 for (int i = 1 ; i < listProduct.size() ; i++ )
			 {
					 
				preparedStatement.setString (1,listProduct.get(i).getProgramme());
				preparedStatement.setString (2,listProduct.get(i).getRestartCounter());
				preparedStatement.setString (3,listProduct.get(i).getShort());
				preparedStatement.setString (4,listProduct.get(i).getDate());
				preparedStatement.setString (5,listProduct.get(i).getTime());
				preparedStatement.setString (6,listProduct.get(i).getShift());
				preparedStatement.setString (7,listProduct.get(i).getTable());
				preparedStatement.setString (8,listProduct.get(i).getGroupe());
				
				preparedStatement.executeUpdate();
				System.out.println("insert success :" + (i+1));
		
				
			}
			 
			 TimeUnit.SECONDS.sleep(10);
		
			 }
		

					}catch (Exception e) 
					{
				    	e.printStackTrace();
					
					}
		
	}
	
	public static ArrayList<Product> getListProductFromTextFile(String filePath)
	{
		FileInputStream fis=null;
		InputStreamReader isr=null; 
		BufferedReader bReader=null;
		ArrayList<Product> listResult = new ArrayList<Product>();
		
		try
		{
			fis=new FileInputStream(filePath);
			isr=new InputStreamReader(fis);
			bReader=new BufferedReader(isr);
			//
			String line=null; 
			String[] strProduct=null;
			//
			while(true)
			{
				line=bReader.readLine();
				//
				if (line==null){
					break;
				}
					else{
						strProduct= line.split(";");
						
						listResult.add(new Product(strProduct[0],strProduct[1],strProduct[2],strProduct[3],strProduct[4],strProduct[5],strProduct[6],strProduct[7]));

					
						}
						
				}
			
			
		} catch (Exception e){
		System.out.println("read file error" );
		e.printStackTrace();
		}finally {
			try
			{
			bReader.close();
			isr.close();
			fis.close();
			
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
		return listResult;
	
	}
	
}
	
