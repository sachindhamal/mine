
package com.ibm.mobileappbuilder.pizzamania20160924080158.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class IndianpizzaDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("types") public String types;
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
        dest.writeString(types);
        dest.writeValue(picture);
        dest.writeValue(price);
        dest.writeString(discription);
    }

    public static final Creator<IndianpizzaDSSchemaItem> CREATOR = new Creator<IndianpizzaDSSchemaItem>() {
        @Override
        public IndianpizzaDSSchemaItem createFromParcel(Parcel in) {
            IndianpizzaDSSchemaItem item = new IndianpizzaDSSchemaItem();

            item.id = in.readString();
            item.types = in.readString();
            item.picture = (Integer) in.readValue(null);
            item.price = (Integer) in.readValue(null);
            item.discription = in.readString();
            return item;
        }

        @Override
        public IndianpizzaDSSchemaItem[] newArray(int size) {
            return new IndianpizzaDSSchemaItem[size];
        }
    };

}


