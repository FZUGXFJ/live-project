package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.pojo.AppointmentInfo;
import fzu.gxfj.util.DBUtil;
import fzu.gxfj.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.SimpleFormatter;

public class AppointmentInfoDAO {

    public Appointment getLastAppointmentInfo() {
        Appointment appointment = null;
        String sql = "SELECT * FROM appointmentinfo LIMIT 1";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.execute();

            appointment = new Appointment();

        } catch (SQLException e)
        {
            e.getStackTrace();
        }

        return appointment;
    }

    public boolean insert(AppointmentInfo appointmentInfo)
    {

        String sql = "INSERT INTO appointmentInfo VALUES (id, ?, ?, ?, ?)";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(2, DateUtil.d2s(appointmentInfo.getBeginTime(), "yyyy-MM-dd hh:mm:ss"));
            ps.setString(3, DateUtil.d2s(appointmentInfo.getEndTime(), "yyyy-MM-dd hh:mm:ss"));
            ps.setInt(4, appointmentInfo.getMaskNum());
            ps.setInt(5, appointmentInfo.getMaxMaskAppointment());
            ps.execute();
        } catch (SQLException e)
        {
            e.getStackTrace();
            return false;
        }
        return true;
    }

}
