

package com.ibm.mobileappbuilder.pizzamania20160924080158.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import java.util.ArrayList;
import java.util.List;
import ibmmobileappbuilder.util.StringUtils;

// NeapolitanPizzaDSSchemaItem static data
public class NeapolitanPizzaDSItems{

    public static List<NeapolitanPizzaDSSchemaItem> ITEMS = new ArrayList<NeapolitanPizzaDSSchemaItem>();
    static {
        // Add items.
        NeapolitanPizzaDSSchemaItem item;
        item = new NeapolitanPizzaDSSchemaItem();
        item.picture = R.drawable.jpg_gehfqpewqr;
        item.price = 100;
        item.discription = "Features tomatoes, garlic, oregano, and extra virgin olive oil";
        item.type = "Pizza Marinara";
        item.id = "57e64880744eca030056c46f";
        addItem(item);
        item = new NeapolitanPizzaDSSchemaItem();
        item.discription = "Features tomatoes, sliced mozzarella, basil, and extra virgin olive oil.";
        item.price = 200;
        item.picture = R.drawable.jpg_vobp0ls0lg;
        item.type = "Pizza Margherita";
        item.id = "57e6489a744eca030056c474";
        addItem(item);
        item = new NeapolitanPizzaDSSchemaItem();
        item.price = 300;
        item.discription = "Features tomatoes, mozzarella from Campania, basil, and extra virgin olive oil.";
        item.picture = R.drawable.jpg_kg0yqgtcta;
        item.type = "Pizza Margherita extra";
        item.id = "57e648be744eca030056c477";
        addItem(item);
    }
    public static void addItem(NeapolitanPizzaDSSchemaItem item) {
        ITEMS.add(item);
    }
}


