

package com.ibm.mobileappbuilder.pizzamania20160924080158.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import java.util.ArrayList;
import java.util.List;
import ibmmobileappbuilder.util.StringUtils;

// ChicagoPizzaDSSchemaItem static data
public class ChicagoPizzaDSItems{

    public static List<ChicagoPizzaDSSchemaItem> ITEMS = new ArrayList<ChicagoPizzaDSSchemaItem>();
    static {
        // Add items.
        ChicagoPizzaDSSchemaItem item;
        item = new ChicagoPizzaDSSchemaItem();
        item.discription = "The primary difference between deep-dish pizza and most other forms of pizza is that, as the name suggests, the crust is very deep, creating a very thick pizza that resembles a pie more than a flatbread. Although the entire pizza is very thick, in traditional Chicago-style deep-dish pizzas, the crust itself is thin to medium in thickness.";
        item.price = 150;
        item.picture = R.drawable.jpg_rf13kegecl;
        item.type = "Deep-dish pizza";
        item.id = "57e64940744eca030056c47b";
        addItem(item);
        item = new ChicagoPizzaDSSchemaItem();
        item.price = 350;
        item.picture = R.drawable.jpg_dvx05bpcfx;
        item.type = "Stuffed pizza";
        item.id = "57e64966f222cb0300d489b9";
        addItem(item);
    }
    public static void addItem(ChicagoPizzaDSSchemaItem item) {
        ITEMS.add(item);
    }
}


