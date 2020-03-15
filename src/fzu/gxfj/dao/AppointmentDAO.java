package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;
import fzu.gxfj.util.DBUtil;
import fzu.gxfj.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    //通过场次id获取制定场次中奖名单，筛选isWin=1
    public ArrayList<Appointment> getWin(int id) {
        ArrayList<Appointment> winners = null;
        String sql = "SELECT * FROM appointment WHERE isWin = TRUE AND id = " + id + " ";

        try (Connection connection = DBUtil.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            winners = new ArrayList<>();
            Appointment appointment = new Appointment();

            while(resultSet.next()){
                appointment.setId(resultSet.getInt("id"));
                appointment.setWin(resultSet.getBoolean("isWin"));
                appointment.setAppointmentsID(resultSet.getInt("appointmentID"));
                appointment.setAppointmentNum(resultSet.getInt("appointmentNum"));
                appointment.setUserName(resultSet.getString("userName"));
                appointment.setUserId(resultSet.getString("userId"));
                appointment.setUserPhone(resultSet.getString("userPhone"));
                winners.add(appointment);
                appointment = new Appointment();
            }
        } catch (SQLException e) {

        }
        return winners;
    }

    public List<Appointment> listAppointedThisTurn() {
        return null;
    }

    public boolean update (Appointment appointment) {
        String sql = "UPDATE appointment SET ";
        if (appointment.getId() != null){
            sql += " id = " + appointment.getId() + " ";
        }
        else
            return false;
        if (appointment.isWin() != null){
            sql += " , isWin = " +  appointment.isWin() + " ";
        }
        if (appointment.getAppointmentsID() != null){
            sql += " , appointmentId = " +  appointment.getAppointmentsID() + " ";
        }
        if (appointment.getAppointmentNum() != null){
            sql += " , appointNum = " + appointment.getAppointmentNum() + " ";
        }
        if (appointment.getUserName() != null){
            sql += ", userName = " + appointment.getUserName() + " ";
        }
        if (appointment.getUserId() != null){
            sql += " , userId = " + appointment.getUserId() + " ";
        }
        if (appointment.getUserPhone() != null){
            sql += " , userPhone = " + appointment.getUserPhone() + " ";
        }
        sql += " WHERE id = " + appointment.getId() + " ; ";

        try (Connection connection = DBUtil.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }


        return true;
    }

    //根据编号获得appoint的数据
    public Appointment getAppointment(String number) {
        Appointment appointment = null;
        String sql = "SELECT * FROM appointment WHERE id = " + number + " ";

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
    public boolean insert(Appointment appointment) {
        String sql = "INSERT INTO appointment VALUES (0, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, appointment.isWin());
            preparedStatement.setInt(2, appointment.getAppointmentsID());
            preparedStatement.setInt(3, appointment.getAppointmentNum());
            preparedStatement.setString(4, appointment.getUserName());
            preparedStatement.setString(5, appointment.getUserId());
            preparedStatement.setString(6, appointment.getUserPhone());

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt("id");
                appointment.setId(id);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
