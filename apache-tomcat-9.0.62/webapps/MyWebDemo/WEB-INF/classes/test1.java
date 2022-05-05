

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test1
 */
@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		String title = "Homework1";
		String form1 = request.getParameter("form1");
		String form2 = request.getParameter("form2");
		String form3 = request.getParameter("form3");
		out.println(			  
			       "<!DOCTYPE HTML>\n " +
			       "<HTML lang=\"en\">\n" +
	               "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		           "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		           "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
		           "<UL>\n" +
		           "  <LI><B>param1</B>: "
		           + form1 + "\n" +
		           "  <LI><B>param2</B>: "
		           + form2 + "\n" +
		           "  <LI><B>param3</B>: "
		           + form3 + "\n" +
		           "</UL>\n" +
		           "</BODY></HTML>");	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
