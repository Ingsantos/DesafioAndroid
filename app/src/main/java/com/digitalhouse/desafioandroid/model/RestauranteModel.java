package com.digitalhouse.desafioandroid.model;

public class RestauranteModel {
    private String titleRestaurant, descriptionAddress, descriptionClose;
    private int image;

    public String getTitleRestaurant() {
        return titleRestaurant;
    }

    public void setTitleRestaurant(String titleRestaurant) {
        this.titleRestaurant = titleRestaurant;
    }

    public String getDescriptionAddress() {
        return descriptionAddress;
    }

    public void setDescriptionAddress(String descriptionAddress) {
        this.descriptionAddress = descriptionAddress;
    }

    public String getDescriptionClose() {
        return descriptionClose;
    }

    public void setDescriptionClose(String descriptionClose) {
        this.descriptionClose = descriptionClose;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
