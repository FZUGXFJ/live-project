package fzu.gxfj.pojo;

import java.sql.Date;

public class AppointmentInfo {
    private Integer id;
    private Date beginTime;
    private Date endTime;
    private Integer maskNum;
    private Integer maxMaskAppointment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getMaskNum() {
        return maskNum;
    }

    public void setMaskNum(Integer maskNum) {
        this.maskNum = maskNum;
    }

    public Integer getMaxMaskAppointment() {
        return maxMaskAppointment;
    }

    public void setMaxMaskAppointment(Integer maxMaskAppointment) {
        this.maxMaskAppointment = maxMaskAppointment;
    }


}
