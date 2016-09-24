

package com.ibm.mobileappbuilder.pizzamania20160924080158.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import java.util.ArrayList;
import java.util.List;
import ibmmobileappbuilder.util.StringUtils;

// IndianpizzaDSSchemaItem static data
public class IndianpizzaDSItems{

    public static List<IndianpizzaDSSchemaItem> ITEMS = new ArrayList<IndianpizzaDSSchemaItem>();
    static {
        // Add items.
        IndianpizzaDSSchemaItem item;
        item = new IndianpizzaDSSchemaItem();
        item.discription = "Regular pizza price – Rs. 60/-\nMedium pizza price – Rs. 120/-\nLarge pizza price – Rs. 230/-\nCheese Burst pizza price – Rs. 190/-";
        item.price = 50;
        item.picture = R.drawable.jpg_oggoqe07mn;
        item.types = "Simply Veg Pizza Prices";
        item.id = "57e64b79f222cb0300d489bd";
        addItem(item);
        item = new IndianpizzaDSSchemaItem();
        item.price = 170;
        item.picture = R.drawable.jpg_0rcpy7hpzh;
        item.types = "Simply Non Veg pizza prices";
        item.id = "57e64bcef222cb0300d489be";
        addItem(item);
    }
    public static void addItem(IndianpizzaDSSchemaItem item) {
        ITEMS.add(item);
    }
}


