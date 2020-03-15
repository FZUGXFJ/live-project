package fzu.gxfj.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.pojo.AppointmentInfo;



/**
 * Servlet implementation class AdminSetServlet
 */
@WebServlet("/adminSetServlet")
public class AdminSetServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		String maskNum = request.getParameter("maskNum");//口罩总数
		int maxAppointment = Integer.parseInt(request.getParameter("maskNum"));//单人最高可预约数量
		int id;//预约编号
		
		if((beginDate!=null)&&(endDate!=null)&&(beginTime!=null)&&(endTime!=null)&&(maskNum!=null)) {
			int maskNums = Integer.parseInt(maskNum);
			String begin1 = beginDate +" "+beginTime;
			String end1 = endDate +" "+endTime;
			Date begin2 = stringToDate(begin1);
			Date end2 = stringToDate(end1);
			
			//设置AppointmentInfo信息
			AppointmentInfoDAO appointmentInfoDAO = new AppointmentInfoDAO();
			AppointmentInfo appointmentInfo = new AppointmentInfo();
			
			appointmentInfo.setBeginTime(begin2);
			appointmentInfo.setEndTime(end2);
			appointmentInfo.setMaskNum(maskNums);
			appointmentInfo.setMaxMaskAppointment(maxAppointment);
			
			appointmentInfoDAO.insert(appointmentInfo);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public static Date stringToDate(String time) {
		String str = time;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        java.util.Date d = null;  
        try {  
            d = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        return date;  
    }

}
