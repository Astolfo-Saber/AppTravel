package com.example.apptravel.models;

public class Place {
    private int placeId;
    private String placeName;
    private String address;
    private String image;
    private String detail;
    private int cityId;

    public Place() {
    }

    public Place(int placeId, String placeName, String address, String image, String detail, int cityId) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.address = address;
        this.image = image;
        this.detail = detail;
        this.cityId = cityId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
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

    public int getCityId() {
        return cityId;
    }

    public void setTourismId(int tourismId) {
        this.placeId = tourismId;
    }

    public void setTourismName(String tourismName) {
        this.placeName = tourismName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String avatar) {
        this.image = image;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

