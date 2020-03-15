package fzu.gxfj.servlet;

import fzu.gxfj.dao.AppointmentDAO;
import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.AppointmentInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet(name = "StartAppointServlet",urlPatterns = "/StartAppointServlet")
public class StartAppointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        AppointmentInfoDAO infoDAO = new AppointmentInfoDAO();
        AppointmentInfo info = infoDAO.getLastAppointmentInfo();
        info.setEndTime(new Date());
        infoDAO.updateLast(info);
        AppointmentInfo newInfo = new AppointmentInfo();
        newInfo.setBeginTime(new Date());
        newInfo.setMaskNum(Integer.parseInt(request.getParameter("maskNum")));
        newInfo.setEndTime(new Date(new Date().getTime() + 864000));
        newInfo.setMaxMaskAppointment(3);
        infoDAO.insert(newInfo);
        request.getRequestDispatcher("appointment.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }
}
