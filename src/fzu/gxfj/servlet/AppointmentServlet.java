package fzu.gxfj.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;
import com.sun.org.apache.bcel.internal.generic.Select;

import fzu.gxfj.dao.AppointmentDAO;
import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.pojo.AppointmentInfo;
import fzu.gxfj.service.Selection;

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
		if(flag != null && flag.equals("ԤԼ")) {
			result = appoint();
		}
		else if(flag != null && flag.equals("�趨�����ܼ�")){
			result = setMaxNum();
		}
		else if(flag != null && flag.equals("ֹͣԤԼ")) {
			result = stopAppoint();
		}
		
		/**
		 * �����ת��ԤԼ���棬���ò���
		 */
		if(result.equals("Appointment.jsp")) {
			AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
			AppointmentInfo appointmentInfo = appointmentInfoDAO.getLastAppointmentInfo();
			int maxAppointment = appointmentInfo.getMaxAppointment();
			Date beginTime = appointmentInfo.getBeginTime();
			Date endTime = appointmentInfo.getEndTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			String beginTimeString = df.format(beginTime);
			String endTimeString = df.format(endTime);
			request.setAttribute("maxAppointment", maxAppointment);
			request.setAttribute("beginTime", beginTimeString);
			request.setAttribute("endTime", endTimeString);
			request.getRequestDispatcher(result).forward(request, response);
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
	
	/*����ԤԼ��*/
	private String appoint() {
		String result;
		String userName =  request.getParameter("name");
		String userID = request.getParameter("ID");
		String userTelephoneNum = request.getParameter("telephoneNum");
		String appointmentNum = request.getParameter("num");
		//�����Ƿ�Ϊ��
		if(userName == null || userID == null || userTelephoneNum == null || appointmentNum == null) {
			request.setAttribute("error", "��Ϊ�գ�");
			result = "Appointment.jsp";
		}
		else {
			//ԤԼ�ɹ����������ݿ�
			Appointment appointment = new Appointment(userName , userID , userTelephoneNum , appointmentNum);
			AppointmentDAO appointmentDAO = new AppointmentDAO();
			appointmentDAO.add(appointment);
			//��ԤԼ�ɹ���Ϊ������ת����ҳ
			request.setAttribute("remind", "ԤԼ�ɹ�");
			result = "index.jsp";
		}
		return result;
	}
	
	private String setMaxNum() {
		String result;
		String maxNum = request.getParameter("maxNum");
		//������Ƿ�Ϊ��
		if(maxNum == null ) {
			request.setAttribute("error", "��Ϊ�գ�");
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String endDate = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
        AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
        AppointmentInfo appointmentInfo = AppointmentInfoDAO.getLastAppointmentInfo();
        appointmentInfo.setEndingTime(endDate);
        appointmentInfoDAO.update(appointmentInfo);
        Selection selection = new Selection();
        selection.select(appointmentInfo);
        request.setAttribute("remind", "ԤԼ����");
        result = "index.jsp";

	}

}
