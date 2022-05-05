

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterFormServlet
 */
@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		String title = "報名資料確認";
		
		String name = request.getParameter("name");
		String school = request.getParameter("school");
		String department = request.getParameter("department");
		String gender = request.getParameter("gender");
		String [] transportation = request.getParameterValues("Transportation");
		
		out.println(			  
			       "<!DOCTYPE HTML>\n " +
			       "<HTML lang=\"en\">\n" +
	               "<HEAD>"
	               + "<TITLE>" + title + "</TITLE>"+
	               "<style>"+
	               "li{ margin:30px; list-style-type:none;}"+
	               "</style>"+
	               "</HEAD>\n" +
		           "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		           "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
		           "<UL>\n" +
		           "  <LI><B>姓名</B>:<br> "
		           + name + "\n" +
		           "  <LI><B>畢業學校</B>:<br> "
		           + school + "\n" +
		           "  <LI><B>畢業科系</B>:<br> "
		           + department + "\n" +
		           "  <LI><B>性別</B>:<br> "
		           + gender + "\n" +
		           "  <LI><B>交通工具</B>:<br> ");
		           
		           for (String item : transportation) {
		        	   out.println(item+"<br>");
		           };
		        	out.println("</UL>\n" +
		    				"</BODY></HTML>"
		        			);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
