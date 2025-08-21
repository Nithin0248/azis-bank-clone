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
 * Servlet implementation class Nithin1
 */
@WebServlet("/Nithin1")
public class Nithin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nithin1() {
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
		PrintWriter p=response.getWriter();
		
		String n=request.getParameter("fname");
		String n1=request.getParameter("lname");
		String n2=request.getParameter("uname");
		String n3=request.getParameter("pword");
		String n4=request.getParameter("mnumb");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			java.sql.Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into student1(FirstName,LastName,UserName,PassWord,MobileNumber) values(' "+n+" ',' "+n1+" ',' "+n2+" ',' "+n3+" ',' "+n4+" ')" );
			//p.println("data inserted succesfully");
			p.println("<html>\r\n"
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
					+"          <a href=\"main.html\">Home</a>"
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
					+"<center><form action=Nithin2 method=post><input type=submit value=view></form>"
					+"<center><form action=Delete method=post><input type=submit value=delete></form>"
					+"<center><form action=login1.html ><input type=submit value=login></form></center>"
					+ "</body>\r\n"
					+ "</html>");
		}
		catch(Exception e) {
			p.println(e);
		}
		/*p.println(n);
		p.println(n1);
		p.println(n2);
		p.println(n3);
		p.println(n4);
	*/
	}

}
