package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    //通过场次id获取制定场次中奖名单，筛选isWin=1
    public ArrayList<Appointment> getWin(int id) {
        return null;
    }

    public List<Appointment> listAppointedThisTurn() {
        return null;
    }

    public void update (Appointment appointment) {}

    //根据编号获得appoint的数据
    public Appointment getAppointment(String number) {
        Appointment appointment = null;
        String sql = "SELECT * FROM appointmentinfo WHERE id = " + number + " ";

        try (Connection connection = DBUtil.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            appointment = new Appointment();
            appointment.setId(resultSet.getInt("id"));
            appointment.setAppointmentNum(resultSet.getInt("appointmentNum"));
            appointment.setAppointmentsID(resultSet.getInt("appointmnetId"));
            appointment.setWin(resultSet.getBoolean("isWin"));
            appointment.setUserName(resultSet.getString("userName"));
            appointment.setUserId(resultSet.getString("userId"));
            appointment.setUserPhone(resultSet.getString("userPhone"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointment;
    }
    //将预约成功的市民插入数据库
    public void add(Appointment appointment) {

    }
}
