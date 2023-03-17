package com.example.apptravel.models;

public class HomeStay {
    private int homeStayId;
    private String homeStayName;
    private String address;
    private String image;
    private String price;
    private String detail;
    private String contact;
    private int cityId;

    public HomeStay(){

    }

    public HomeStay(int homeStayId, String homeStayName, String address, String image, String price, String detail, String contact, int cityId) {
        this.homeStayId = homeStayId;
        this.homeStayName = homeStayName;
        this.address = address;
        this.image = image;
        this.price = price;
        this.detail = detail;
        this.contact = contact;
        this.cityId = cityId;
    }

    public int getHomeStayId() {
        return homeStayId;
    }

    public String getHomeStayName() {
        return homeStayName;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public String getContact() {
        return contact;
    }

    public int getCityId() {
        return cityId;
    }

    public void setHomeStayId(int homeStayId) {
        this.homeStayId = homeStayId;
    }

    public void setHomeStayName(String homeStayName) {
        this.homeStayName = homeStayName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
