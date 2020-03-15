package fzu.gxfj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fzu.gxfj.dao.AppointmentDAO;
import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.pojo.AppointmentInfo;
import fzu.gxfj.service.Selection;
import fzu.gxfj.util.DateUtil;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentInfoDAO infoDAO = new AppointmentInfoDAO();
		AppointmentInfo info = infoDAO.getLastAppointmentInfo();

		request.setCharacterEncoding("utf-8");
		Appointment appointment = new Appointment();
		appointment.setUserId(request.getParameter("id"));
		appointment.setUserName(request.getParameter("name"));
		appointment.setUserPhone(request.getParameter("phone"));
		appointment.setAppointmentNum(Integer.parseInt(request.getParameter("num")));
		appointment.setAppointmentsID(info.getId());
		AppointmentDAO appointmentDAO = new AppointmentDAO();
		appointmentDAO.add(appointment);
		long appointTime = DateUtil.s2d(request.getParameter("dateTime")).getTime();
		long beginTime = info.getBeginTime().getTime();
		long endTime = info.getEndTime().getTime();
		request.setAttribute("appointment", appointment);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");

		if(appointTime >= beginTime && appointTime <=endTime) {
			out.println("<title>预约成功</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1 align=center>预约成功！</h1>");
			out.println("<p><a href='appointment.jsp'>返回</a>");
		} else {
			out.println("<title>预约失败</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1 align=center>预约失败，当前不是预约时间！</h1>");
			out.println("<p><a href='appointment.jsp'>返回</a>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
}
