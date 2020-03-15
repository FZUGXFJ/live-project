
package fzu.gxfj.servlet;

import fzu.gxfj.dao.AppointmentDAO;
import fzu.gxfj.dao.AppointmentInfoDAO;
import fzu.gxfj.pojo.AppointmentInfo;
import fzu.gxfj.service.Selection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "EndAppointServlet",urlPatterns = "EndAppointServlet")
public class EndAppointServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppointmentInfoDAO infoDAO = new AppointmentInfoDAO();
        AppointmentInfo info =  AppointmentInfoDAO.getLastAppointmentInfo();
        info.setEndTime(new Date());
        long now = new Date().getTime();
        long beginTime = info.getBeginTime().getTime();
        long endTime = info.getEndTime().getTime();
        if(now >= beginTime && now <= endTime) {
            info.setEndTime(new Date(now));
            AppointmentInfoDAO.updateLast(info);
        }
        new Selection().select(info);
        request.getRequestDispatcher("appointment.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
