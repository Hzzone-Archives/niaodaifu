package cn.hzzone.dachuang.model;


public class Address {

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Address() {

    }

    public Address(String address_id, String province, String city, String area, String address_detail, String user_name, String phone_number, String openid) {
        this.address_id = address_id;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address_detail = address_detail;
        this.user_name = user_name;
        this.phone_number = phone_number;
        this.openid = openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAddress_id() {

        return address_id;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getOpenid() {
        return openid;
    }

    private String address_id;
    private String province;
    private String city;
    private String area;
    private String address_detail;
    private String user_name;
    private String phone_number;
    private String openid;
}
