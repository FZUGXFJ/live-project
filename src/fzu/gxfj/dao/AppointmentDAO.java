package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;

import java.util.List;

public class AppointmentDAO {
	//通过场次id获取制定场次中奖名单，筛选isWin=1
	public ArrayList<Appointment> getWin(int id); 

    public List<Appointment> listAppointedThisTurn() {
        return null;
    }

    public void update (Appointment appointment) {}

    //根据编号获得appoint的数据
    public Appointment getAppointment(String number);
}
