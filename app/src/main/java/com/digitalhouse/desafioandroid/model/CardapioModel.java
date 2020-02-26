package com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CardapioModel implements Parcelable {

    private String titleFood;
    private int imageFood;

    public CardapioModel(String titleFood, int imageFood) {
        this.titleFood = titleFood;
        this.imageFood = imageFood;
    }

    protected CardapioModel(Parcel in) {
        titleFood = in.readString();
        imageFood = in.readInt();
    }

    public static final Creator<CardapioModel> CREATOR = new Creator<CardapioModel>() {
        @Override
        public CardapioModel createFromParcel(Parcel in) {
            return new CardapioModel(in);
        }

        @Override
        public CardapioModel[] newArray(int size) {
            return new CardapioModel[size];
        }
    };

    public String getTitleFood() {
        return titleFood;
    }

    public void setTitleFood(String titleFood) {
        this.titleFood = titleFood;
    }

    public int getImageFood() {
        return imageFood;
    }

    public void setImageFood(int imageFood) {
        this.imageFood = imageFood;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleFood);
        dest.writeInt(imageFood);
    }
}
