
package com.ibm.mobileappbuilder.pizzamania20160924080158.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ChicagoPizzaDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("type") public String type;
    @SerializedName("picture") public Integer picture;
    @SerializedName("price") public Integer price;
    @SerializedName("discription") public String discription;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeValue(picture);
        dest.writeValue(price);
        dest.writeString(discription);
    }

    public static final Creator<ChicagoPizzaDSSchemaItem> CREATOR = new Creator<ChicagoPizzaDSSchemaItem>() {
        @Override
        public ChicagoPizzaDSSchemaItem createFromParcel(Parcel in) {
            ChicagoPizzaDSSchemaItem item = new ChicagoPizzaDSSchemaItem();

            item.id = in.readString();
            item.type = in.readString();
            item.picture = (Integer) in.readValue(null);
            item.price = (Integer) in.readValue(null);
            item.discription = in.readString();
            return item;
        }

        @Override
        public ChicagoPizzaDSSchemaItem[] newArray(int size) {
            return new ChicagoPizzaDSSchemaItem[size];
        }
    };

}


