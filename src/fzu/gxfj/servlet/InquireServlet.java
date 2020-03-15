package fzu.gxfj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.Select;

import fzu.gxfj.dao.*;
import fzu.gxfj.pojo.*;

/**
 * Servlet implementation class InquireServlet
 */
@WebServlet("/inquireServlet")
public class InquireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquireServlet() {
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
		String number = request.getParameter("number");
		AppointmentsDAO appointmentsDAO = new AppointmentsDAO();
		Appointment appointment = appointmentsDAO.getAppointment(number);
		if(appointment.getIsWin()) {
			request.setAttribute("isWin", appointment.getIsWin());
			request.setAttribute("userName", appointment.getUserName());
			request.setAttribute("userID", appointment.getUserID());
			request.setAttribute("userTelephoneNum", appointment.getUserTelephoneNum());
			request.setAttribute("appointsmentNum", appointment.getAppointmentNum());
		}
		request.getRequestDispatcher("select.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
