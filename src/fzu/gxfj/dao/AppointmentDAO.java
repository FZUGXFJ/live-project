package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;

import java.util.List;

public class AppointmentDAO {

    public List<Appointment> listAppointedThisTurn() {
        return null;
    }

    public void update (Appointment appointment) {}

    //根据编号获得appoint的数据
    public Appointment getAppointment(String number);
}
