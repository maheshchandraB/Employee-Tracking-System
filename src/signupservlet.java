import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public signupservlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String f=request.getParameter("first");
		String l=request.getParameter("last");
		String em=request.getParameter("email");
		String pa=request.getParameter("pass");
		db_reg_insert d=new db_reg_insert();
		boolean ou=false;
		try {
			 ou=d.db_insert(f, l, em, pa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!ou)
		{
			response.sendRedirect("/EPproject/homepage.html"); 
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
