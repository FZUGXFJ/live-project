package fzu.gxfj.pojo;

import java.sql.Date;

public class AppointmentInfo {
    private int id;
    private Date beginTime;
    private Date endTime;
    private int maskNum;
    private int maxMaskAppointment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getMaskNum() {
        return maskNum;
    }

    public void setMaskNum(int maskNum) {
        this.maskNum = maskNum;
    }

    public int getMaxMaskAppointment() {
        return maxMaskAppointment;
    }

    public void setMaxMaskAppointment(int maxMaskAppointment) {
        this.maxMaskAppointment = maxMaskAppointment;
    }


}
