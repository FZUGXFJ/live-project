package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.pojo.AppointmentInfo;
import fzu.gxfj.util.DBUtil;
import fzu.gxfj.util.DateUtil;

import java.sql.*;

public class AppointmentInfoDAO {

    public AppointmentInfo getLastAppointmentInfo() {
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
        } catch (SQLException e)
        {
            e.getStackTrace();
        }

        return appointment;
    }

    public boolean insert(AppointmentInfo appointmentInfo)
    {

        String sql = "INSERT INTO appointmentInfo VALUES (id, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(2, DateUtil.d2s(appointmentInfo.getBeginTime(), "yyyy-MM-dd hh:mm:ss"));
            preparedStatement.setString(3, DateUtil.d2s(appointmentInfo.getEndTime(), "yyyy-MM-dd hh:mm:ss"));
            preparedStatement.setInt(4, appointmentInfo.getMaskNum());
            preparedStatement.setInt(5, appointmentInfo.getMaxMaskAppointment());
            preparedStatement.execute();
        } catch (SQLException e)
        {
            e.getStackTrace();
            return false;
        }
        return true;
    }

    //修改最大口罩数
    public boolean updateMaxNum(int maxNum){
    return true;
    }

    public boolean update(AppointmentInfo appointmentInfo){
        return true;
    }

}
