package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/userdb";
	public static final String PASSWORD = "root";
	public static final String USERNAME = "root";
	Connection connection;

	public LoginServlet() {
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		try {
			PreparedStatement ps = connection.prepareStatement("select * from uinfo where uname=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			PrintWriter pw = response.getWriter();
			
			pw.println("<html><body bgcolor=black text=white><center>");
			if (rs.next()) {
				pw.println("Welocme "+uname);
			}else {
				pw.println("User not valid");
			}
			pw.println("</center></body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
