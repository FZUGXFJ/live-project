package fzu.gxfj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fzu.gxfj.dao.AdminDAO;
import fzu.gxfj.pojo.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account != null && password != null) {
			AdminDAO adminDAO= new AdminDAO();
			Admin admin = AdminDAO.getAdminUser(account);
			if(admin != null && admin.getPassword().equals(password))
				request.getRequestDispatcher("Setup.jsp").forward(request, response);
			request.setAttribute("hint", "没有此用户");//返回提示信息
			//System.out.println("没有此用户"+ account);
			request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
		}
		else {
			request.setAttribute("hint", "用户名和密码不能为空");//返回提示信息
			System.out.println("用户名和密码不能不能为空");
			request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
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
