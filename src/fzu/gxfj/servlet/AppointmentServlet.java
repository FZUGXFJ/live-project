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


import com.sun.org.apache.bcel.internal.generic.Select;


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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String result = null;
		if(flag != null && flag.equals("预约")) {
			result = appoint();
		}
		else if(flag != null && flag.equals("设定口罩总计")){
			result = setMaxNum();
		}
		else if(flag != null && flag.equals("停止预约")) {
			result = stopAppoint();
		}
		
		/**
		 * 如果是转到预约界面，设置参数
		 */
		if(result.equals("Appointment.jsp")) {
			AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
			AppointmentInfo appointmentInfo = appointmentInfoDAO.getLastAppointmentInfo();
			int maxAppointment = appointmentInfo.getMaxAppointment();
			Date beginTime = appointmentInfo.getBeginTime();
			Date endTime = appointmentInfo.getEndTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String beginTimeString = df.format(beginTime);
			String endTimeString = df.format(endTime);
			request.setAttribute("maxAppointment", maxAppointment);
			request.setAttribute("beginTime", beginTimeString);
			request.setAttribute("endTime", endTimeString);
			request.getRequestDispatcher(result).forward(request, response);
		}
		request.getRequestDispatcher(result).forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*处理预约表单*/
	private String appoint() {
		String result;
		String userName =  request.getParameter("name");
		String userID = request.getParameter("ID");
		String userTelephoneNum = request.getParameter("telephoneNum");
		String appointmentNum = request.getParameter("num");
		//检测表单是否为空
		if(userName == null || userID == null || userTelephoneNum == null || appointmentNum == null) {
			request.setAttribute("error", "表单为空！");
			result = "Appointment.jsp";
		}
		else {
			//预约成功，插入数据库
			Appointment appointment = new Appointment(userName , userID , userTelephoneNum , appointmentNum);
			AppointmentDAO appointmentDAO = new AppointmentDAO();
			appointmentDAO.add(appointment);
			//将预约成功设为参数，转到首页
			request.setAttribute("remind", "预约成功");
			result = "index.jsp";
		}
		return result;
	}
	
	private String setMaxNum() {
		String result;
		String maxNum = request.getParameter("maxNum");
		//检验表单是否为空
		if(maxNum == null ) {
			request.setAttribute("error", "表单为空！");
			result = "Appointment.jsp";
		}
		else {
			int mm = Integer.parseInt(maxNum);
			AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
			appointmentInfoDAO.updateMaxNum(mm);
			result = "Appointment.jsp";
		}
		return result;
	}
	
	private String stopAppoint() {
		String result;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String endDate = df.format(new Date());// new Date()为获取当前系统时间
        AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
        AppointmentInfo appointmentInfo = AppointmentInfoDAO.getLastAppointmentInfo();
        appointmentInfo.setEndingTime(endDate);
        appointmentInfoDAO.update(appointmentInfo);
        Selection selection = new Selection();
        selection.select(appointmentInfo);
        request.setAttribute("remind", "预约结束");
        result = "index.jsp";

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
