import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginservlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static final String driver="oracle.jdbc.driver.OracleDriver";
	public static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String username="system";
	public static final String password="mahesh";
    public loginservlet() 
    {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String em=request.getParameter("ee");
		String pa=request.getParameter("pass");
		String qry="select * from project_reg";
	     try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			if(con==null)
				   System.out.println("connection not");
			   else
				   System.out.println("success");
			Statement st=con.createStatement();
			ResultSet rd=st.executeQuery(qry);
			int c=0;
			while(rd.next())
			{
				String email=rd.getString("email");
				String password=rd.getString("password");
				if(email.equals(em) && password.equals(pa))
				{
					c=1;
					break;
				}
				else
				{
					c=0;
				}
			}
			if(c==1)
			{
				response.sendRedirect("/EPproject/homepage.html");
			}
			else {
				out.println("Incorrect Password");
			}
		} 
		 catch (ClassNotFoundException e)
		 {
				e.printStackTrace();}
         catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


