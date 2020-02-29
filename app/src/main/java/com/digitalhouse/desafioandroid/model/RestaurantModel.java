package com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RestaurantModel implements Parcelable {

    private String titleRestaurant, descriptionAddress, descriptionClose;
    private int image;

    public RestaurantModel(String titleRestaurant, String descriptionAddress, String descriptionClose, int image) {
        this.titleRestaurant = titleRestaurant;
        this.descriptionAddress = descriptionAddress;
        this.descriptionClose = descriptionClose;
        this.image = image;
    }

    public static final Creator<RestaurantModel> CREATOR = new Creator<RestaurantModel>() {
        @Override
        public RestaurantModel createFromParcel(Parcel in) {
            return new RestaurantModel(in);
        }

        @Override
        public RestaurantModel[] newArray(int size) {
            return new RestaurantModel[size];
        }
    };

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

    protected RestaurantModel (Parcel in){

        titleRestaurant = in.readString();
        descriptionAddress = in.readString();
        descriptionClose = in.readString();
        image = in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleRestaurant);
        dest.writeString(descriptionAddress);
        dest.writeString(descriptionClose);
        dest.writeInt(image);
    }
}
