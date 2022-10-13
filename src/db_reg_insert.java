 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class db_reg_insert
{
	public static final String driver="oracle.jdbc.driver.OracleDriver";
	public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username="system";
	public static final String password="mahesh";
	public boolean db_insert(String f,String l,String em,String pa)throws ClassNotFoundException,SQLException
	{
		 Class.forName(driver);
		   Connection con=DriverManager.getConnection(url,username,password);
		   if(con==null)
			   System.out.println("connection not");
		   else
			   System.out.println("success");
		   PreparedStatement pstmt=con.prepareStatement("insert into project_reg values(?,?,?,?)");
		   pstmt.setString(1, f);
		   pstmt.setString(2, l);
		   pstmt.setString(3, em);
		   pstmt.setString(4, pa);
		   boolean x=pstmt.execute();
			if(x)
				System.out.println("- - - - One Record inserted successful - - - -");
			con.close();
			return x;
				
	}
}
