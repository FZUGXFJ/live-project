package fzu.gxfj.dao;

import fzu.gxfj.pojo.Appointment;

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
<<<<<<< HEAD
<<<<<<< HEAD
    public Appointment getAppointment(String number);
    //将预约成功的市民插入数据库
    public void add(Appointment appointment);
=======
    public Appointment getAppointment(String number){
	    return null;
    }
>>>>>>> 87b48b576d3fca0ba0ce3d8ea9063426482f9e20
}
=======
    public Appointment getAppointment(String number) {
        return null;
    }
}
>>>>>>> 5a839c86309b3f682935266c1078c04eb200e492
