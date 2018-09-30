package com.example.ou.hight04;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ou on 2018/9/28.
 */

public class Book implements Parcelable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Creator<Book> getCREATOR() {
        return CREATOR;
    }

    protected Book(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}
