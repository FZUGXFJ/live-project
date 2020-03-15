package fzu.gxfj.service;

import fzu.gxfj.pojo.Appointment;

public class Generator {

    public String generatePurchaseVoucher(Appointment appointment) {
        StringBuilder voucher = new StringBuilder();
        voucher.append(appointment.getUserName()).append(";");
        voucher.append(appointment.getUserId()).append(";");
        voucher.append(appointment.getUserPhone()).append(";");
        voucher.append(appointment.getAppointmentNum()).append(";");
        voucher.append(appointment.getAppointmentsID());
        return voucher.toString();
    }
}
