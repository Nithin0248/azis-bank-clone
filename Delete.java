package eee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			java.sql.Statement stmt=con.createStatement();
			stmt.executeUpdate("delete from student1");
			stmt.execute("commit");
			out.println("<html>\r\n"
					+ "<head>\r\n"
					+ "	<style>\r\n"
					+ "	header{\r\n"
					+ "		background-color:#AE275F;\r\n"
					+ "		padding:20px;\r\n"
					+ "		\r\n"
					+ "	}\r\n"
					+ "	header h1{\r\n"
					+ "	color:white;\r\n"
					+ "	}\r\n"
					+ "	nav{\r\n"
					+ "	 background-color:white;\r\n"
					+ "	 padding:10px 0px;\r\n"
					+ "	 }\r\n"
					+ "	 nav a{\r\n"
					+ "	 color:black;\r\n"
					+ "	 text-decoration:none;\r\n"
					+ "	 padding:1px 15px;\r\n"
					+ "	 }\r\n"
					+ "	 footer{\r\n"
					+ "	 	background-color:#AE275F;\r\n"
					+ "		padding:10px;\r\n"
					+ "		position:fixed;\r\n"
					+ "		bottom:5px;\r\n"
					+ "		width:100%;\r\n"
					+ "	 }\r\n"
					+ "	</style>\r\n"
					+ "	\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Axis bank</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<header>\r\n"
					+ "		<center><h1><b>AXIS BANK</b></h1></center>\r\n"
					+ "	</header>\r\n"
					+ "	<nav>\r\n"
					+ " 		<a href=\"main.html\">Home</a>"			
					+ "			<a href=\" \">Explore Products</a>\r\n"
					+ "			<a href=\" \">Grab Deals</a>\r\n"
					+ "			<a href=\" \">Make Payments</a>\r\n"
					+ "			<a href=\" \">Bank Smart</a>\r\n"
					+ "			<a href=\"\">Unlearn</a>\r\n"
					+ "			<a href=\"digital.html\">Open Digital A/c</a>\r\n"
					+ "	</nav>\r\n"
					+ "	<footer><center>\r\n"
					+ "	<h3>Copyright@2025Axis Bank</h3>\r\n"
					+ "	</center></footer>\r\n"
					+ "<center><h1>Data selected</h1></center> "
					+"<center><form action=Nithin2 method=post><input type=submit value=view></form>"
					+ "</body>\r\n"
					+ "</html>");
			
			}
		catch(Exception e) {
			out.println(e);
		}
		
	}

}
