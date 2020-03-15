package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.pojo.AppointmentInfo;
import fzu.gxfj.util.DBUtil;
import fzu.gxfj.util.DateUtil;

import java.sql.*;

public class AppointmentInfoDAO {

    /**
     * 获得最新的场次信息
     * @return 返回最新的场次信息
     */
    public static AppointmentInfo getLastAppointmentInfo() {
        AppointmentInfo appointment = null;
        String sql = "SELECT * FROM appointmentinfo ORDER BY endTime DESC LIMIT 1";

        try (Connection connection = DBUtil.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);
            rs.next();

            appointment = new AppointmentInfo();

            appointment.setId(rs.getInt("id"));
            appointment.setBeginTime(rs.getDate("beginTime"));
            appointment.setEndTime(rs.getDate("endTime"));
            appointment.setMaskNum(rs.getInt("maskNum"));
            appointment.setMaxMaskAppointment(rs.getInt("maxMaskAppointment"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    /**
     * 向数据库里插入一个预约场次信息
     * @param appointmentInfo 要插入的场次信息，成功后的Id为在数据库中的Id
     * @return
     */
    public static boolean insert(AppointmentInfo appointmentInfo) {

        String sql = "INSERT INTO appointmentinfo VALUES (0, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, DateUtil.d2s(appointmentInfo.getBeginTime(), "yyyy-MM-dd hh:mm:ss"));
            preparedStatement.setString(2, DateUtil.d2s(appointmentInfo.getEndTime(), "yyyy-MM-dd hh:mm:ss"));
            preparedStatement.setInt(3, appointmentInfo.getMaskNum());
            preparedStatement.setInt(4, appointmentInfo.getMaxMaskAppointment());
            preparedStatement.execute();
            
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //修改最大口罩数
    public static boolean updateMaxNum(int maxNum){
        AppointmentInfo appointment = new AppointmentInfo();

        appointment.setMaxMaskAppointment(maxNum);
        return updateLast(appointment);
    }

    /**
     * 修改最新预约场次的信息
     * @param appointmentInfo
     * @return
     */
    public static boolean updateLast(AppointmentInfo appointmentInfo){

        AppointmentInfo last = getLastAppointmentInfo();

        String sql = "UPDATE appointmentinfo SET ";
        boolean first = true;
        if (appointmentInfo.getId() != null) {
            sql += " id = " + appointmentInfo.getId() + " ";
            first = false;
        }
        if (appointmentInfo.getBeginTime() != null) {
            if (first)
                first = false;
            else
                sql += " , ";
            sql += " beginTime = '" + DateUtil.d2s(appointmentInfo.getBeginTime(),"yyyy-MM-dd HH:mm:ss") + "' ";
        }
        if (appointmentInfo.getEndTime() != null) {
            if (first)
                first = false;
            else
                sql += " , ";
            sql += " endTime = '" + DateUtil.d2s(appointmentInfo.getEndTime(),"yyyy-MM-dd HH:mm:ss") + "' ";
        }
        if (appointmentInfo.getMaskNum() != null) {
            if (first)
                first = false;
            else
                sql += " , ";
            sql += " maskNum = " + appointmentInfo.getMaskNum() + " ";
        }
        if (appointmentInfo.getMaxMaskAppointment() != null) {
            if (first)
                first = false;
            else
                sql += " , ";
            sql += "maxMaskAppointment = " + appointmentInfo.getMaxMaskAppointment() + " ";
        }
        if (first)
            return false;

        sql += " WHERE id = " + last.getId() + " ";

        try (Connection connection = DBUtil.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
	
	public static int getCount() {///获取AppointmentInfo表记录总数
		return 0;
	}
}
