

package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.pizzamania20160924080158.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * MENUFragment menu fragment.
 */
public class MENUFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public MENUFragment(){
        super();
    }

    // Factory method
    public static MENUFragment newInstance(Bundle args) {
        MENUFragment fragment = new MENUFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Neapolitan Pizza")
            .setIcon(R.drawable.jpg_pizzatypesmargherita112)
            .setAction(new StartActivityAction(NeapolitanPizzaActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Chicago Pizza")
            .setIcon(R.drawable.jpg_cc673)
            .setAction(new StartActivityAction(ChicagoPizzaActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("New York Style Pizza")
            .setIcon(R.drawable.jpg_pizzatypesgourmet358)
            .setAction(new StartActivityAction(NewYorkStylePizzaActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Indian Pizza")
            .setIcon(R.drawable.jpg_in951)
            .setAction(new StartActivityAction(IndianPizzaActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.menu_item;
    }
}

