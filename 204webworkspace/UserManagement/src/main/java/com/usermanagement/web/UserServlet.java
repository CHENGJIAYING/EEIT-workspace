package com.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.bean.User;
import com.usermanagement.dao.UserDAOImpl;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAOImpl userDAOImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		userDAOImpl = new UserDAOImpl();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			try {
				insertUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "/edit":
			try {
				showEditForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				listUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}





	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response)throws SQLException ,IOException{
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String userbirth = request.getParameter("userbirth");
		String usergender = request.getParameter("usergender");
		String useraddress = request.getParameter("useraddress");
		User  newuser = new User(username,useremail,userphone,userbirth,usergender,useraddress);
		userDAOImpl.doCreate(newuser);
		response.sendRedirect("list");
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws SQLException ,IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));
		try {
			userDAOImpl.deleteByUserid(userid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException ,IOException,ServletException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));
		User existingUser ;
		try {
			existingUser = userDAOImpl.findByUserid(userid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException ,IOException{
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String userbirth = request.getParameter("userbirth");
		String usergender = request.getParameter("usergender");
		String useraddress = request.getParameter("useraddress");
		User updateuser = new User(userid,username,useremail,userphone,userbirth,usergender,useraddress);
		userDAOImpl.doUpdate(updateuser);
		response.sendRedirect("list");
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws SQLException ,IOException,ServletException {
		// TODO Auto-generated method stub
		try {
			List<User> listUser = userDAOImpl.findAll();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



}