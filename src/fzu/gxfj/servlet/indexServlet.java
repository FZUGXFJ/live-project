package fzu.gxfj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.Appointment;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String result = null;
		if(action != null) {
			if(action.equals("预约")) {
				AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
				AppointmentInfo appointmentInfo = appointmentInfoDAO.getLastAppointmentInfo();
				request.setAttribute("maxAppointment", appointmentInfo.getMaxAppointment);
				result = "Appointment.jsp";
			}
			else if(action.equals("查询")) {
				result = "Select.jsp";
			}
			else if(action.equals("管理员登录")) {
				result = "SetUp.jsp";
			}
		}
		else {
			System.out.print("falg为空");
		}
		request.getRequestDispatcher(result).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
