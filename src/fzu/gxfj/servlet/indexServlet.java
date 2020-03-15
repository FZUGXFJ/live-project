package fzu.gxfj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java.swing.plaf.windows.resources.windows;

/*import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.Appointment;*/

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
		String flag = request.getParameter("flag");
		String result = null;
		if(flag != null) {
			if(flag.equals("ԤԼ")) {
				/*AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
				AppointmentInfo appointmentInfo = appointmentInfoDAO.getInfo();
				request.setAttribute("maxAppointment", appointmentInfo.getMaxAppointment);*/
				result = "Appointment.jsp";
			}
			else if(flag.equals("��ѯ")) {
				result = "Select.jsp";
			}
			else if(flag.equals("��ѯ")) {
				result = "SetUp.jsp";
			}
		}
		else {
			System.out.print("falgΪ��");
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
