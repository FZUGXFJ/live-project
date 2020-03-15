package fzu.gxfj.dao;

public class AppointmentDAO {
	//通过场次id获取制定场次中奖名单，筛选isWin=1
	public ArrayList<Appointment> getWin(int id); 
}
