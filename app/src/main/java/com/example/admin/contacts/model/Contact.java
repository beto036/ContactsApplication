
package com.example.admin.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;
    @SerializedName("smallImageURL")
    @Expose
    private String smallImageURL;
    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("phone")
    @Expose
    private Phone phone;
    @SerializedName("address")
    @Expose
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", favorite=" + favorite +
                ", smallImageURL='" + smallImageURL + '\'' +
                ", largeImageURL='" + largeImageURL + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }

    protected Contact(Parcel in) {
        name = in.readString();
        company = in.readString();
        byte favoriteVal = in.readByte();
        favorite = favoriteVal == 0x02 ? null : favoriteVal != 0x00;
        smallImageURL = in.readString();
        largeImageURL = in.readString();
        email = in.readString();
        website = in.readString();
        phone = (Phone) in.readValue(Phone.class.getClassLoader());
        address = (Address) in.readValue(Address.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(company);
        if (favorite == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (favorite ? 0x01 : 0x00));
        }
        dest.writeString(smallImageURL);
        dest.writeString(largeImageURL);
        dest.writeString(email);
        dest.writeString(website);
        dest.writeValue(phone);
        dest.writeValue(address);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
