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
import java.sql.ResultSet;

/**
 * Servlet implementation class Nithin3
 */
@WebServlet("/Nithin3")
public class Nithin3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nithin3() {
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
		String s=request.getParameter("uname");
		String s1=request.getParameter("pword");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			//out.println("one");
			java.sql.Statement stmt=con.createStatement();
			//out.println("1one");
			//String sql = "SELECT * FROM student3 WHERE UserName='" + s + "' AND PassWord='" + s1 + "'";
             //ResultSet rs = stmt.executeQuery("SELECT UserName,PassWord FROM student3 ");
			ResultSet rs=stmt.executeQuery("select USERNAME,PASSWORD from student1");
             //out.println("2one");
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
					+"    		 <a href=\"main.html\">Home</a>"		
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
					+ "	</footer>\r\n");
			boolean found=false;
			 while(rs.next()) {
	            	String sm=rs.getString("USERNAME");
	            	String sm1=rs.getString("PASSWORD");
	            	if (sm.trim().equals(s.trim()) && sm1.trim().equals(s1.trim())) {
	            	found=true;
	                out.println("<center><h2>Welcome " + sm + "!</h2></center>");
	                break;
	            } 
	            } if(!found) {
	            	out.println("<center><h2 style='color:red'>Invalid UserName/PassWord</h2>");
	            	out.println("<form action=login1.html ><input type=submit value=login></form></center>");
	            }
					out.println("</body>\r\n"
					+ "</html>");
		
			
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
