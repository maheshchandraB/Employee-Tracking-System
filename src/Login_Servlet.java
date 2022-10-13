

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_Servlet
 */
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String uname  = request.getParameter("email");
	    String password = request.getParameter("Password");
	    int flg=0;
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mahesh");
			PreparedStatement pstmt=con.prepareStatement("select * from project_reg");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(uname.equals(rs.getString(3)) && password.equals(rs.getString(4)))
				{
					out.println("-------------------Sucessfully Logged In-------------");
					RequestDispatcher rd = request.getRequestDispatcher("/dashboard.html"); 
			         
			        rd.include(request, response); 
					flg=1;
				}
			}
			if(flg==0)
			{
				out.println("----------INVALID CREDINTIALS---------------");
				out.println("\n----------------TRY AGAIN-------------------");
				RequestDispatcher rd = request.getRequestDispatcher("/login.html"); 
		         
		        rd.include(request, response); 
			}
		
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
