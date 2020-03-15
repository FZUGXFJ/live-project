package fzu.gxfj.pojo;

public class Subscriber {
    private String ID;
    private String name;
    private String phoneNumber;
    private String orderCount;

    public Subscriber(String ID, String name, String phoneNumber, String orderCount) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orderCount = orderCount;
    }

    public Subscriber() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(String orderCount) {
        this.orderCount = orderCount;
    }
}
