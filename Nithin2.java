package eee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Nithin2
 */
@WebServlet("/Nithin2")
public class Nithin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nithin2() {
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
			Statement stmt=con.createStatement();
			ResultSet r=stmt.executeQuery("select FirstName,LastName,UserName,PassWord,MobileNumber from student1");
			String rs="",rs1="";

			out.println("<html>\r\n"
					+ "<head>\r\n"
					+ "	<style>\r\n"
					+ "	header{\r\n"
					+ "		background-color:#AE275F;\r\n"
					+ "		padding:5px;\r\n"
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
					+ "		padding:5px;\r\n"
					+ "		position:fixed;\r\n"
					+ "		bottom:5px;\r\n"
					+ "		width:100%;\r\n"
					+ "		\r\n"
					+ "	 }\r\n"
					+ "	</style>\r\n"
					+ "	\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Registration page</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<header>\r\n"
					+ "		<center><h1><b>AXIS BANK</b></h1></center>\r\n"
					+ "	</header>\r\n"
					+ "	<nav>\r\n"
					+"           <a href=\"main.html\">Home</a>"
					+ "			<a href=\" \">Explore Products</a>\r\n"
					+ "			<a href=\" \">Grab Deals</a>\r\n"
					+ "			<a href=\" \">Make Payments</a>\r\n"
					+ "			<a href=\" \">Bank Smart</a>\r\n"
					+ "			<a href=\"\">Unlearn</a>\r\n"
					+ "			<a href=\"digital.html\">Open Digital A/c</a>\r\n"
					+ "	</nav>\r\n"
					+ "	<footer>\r\n"
					+ "		<center>\r\n"
					+ "			<h3>Copyright@2025Axis Bank</h3>\r\n"
					+ "		</center>\r\n"
					+ "	</footer>\r\n"
					+"<center><h1><b><u>Registered Succexfully</u></b></h1></center>"
					+"<center><table border='1'>"
					+"<tr><td>FirstName</td><td>LastName</td><td>UserName</td><td>PassWord</td><td>MobileNumber</td><tr>");
			while(r.next()) {
				rs=r.getString("firstname");
				rs1=r.getString("lastname");
				String rs2=r.getString("username");
				String rs3=r.getString("password");
				String rs4=r.getString("mobilenumber");
				out.println("<tr><td>"+rs+"</td>");
				out.println("<td>"+rs1+"</td>");
				out.println("<td>"+rs2+"</td>");
				out.println("<td>"+rs3+"</td>");
				out.println("<td>"+rs4+"</td></tr>");
				}
					out.println("</table>");
					out.println("<form action=registration.html method=post><input type=submit value=update></form>");
					out.println("<form action=Delete method=post><input type=submit value=delete></form>"
					+"<form action=login1.html ><input type=submit value=login></form>");
					out.println("</center></body>\r\n"
					+ "</html>");
		
			
		}catch(Exception e) {
			out.println(e);
		}
		
	}

}
