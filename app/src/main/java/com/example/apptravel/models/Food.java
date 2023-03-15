package com.example.apptravel.models;

public class Food {
    private int foodId;
    private String foodName;
    private String address;
    private String image;
    private String detail;
    private String cityId;

    public Food() {
    }

    public Food(int foodId, String foodName, String address, String image, String detail, String cityId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.address = address;
        this.image = image;
        this.detail = detail;
        this.cityId = cityId;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getDetail() {
        return detail;
    }

    public String getCityId() {
        return cityId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
