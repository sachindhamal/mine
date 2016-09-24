
package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.Item;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.EmptyDatasource;

public class NeapolitanPizzaDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Item> implements ShareBehavior.ShareListener  {

    private Datasource<Item> datasource;
    public static NeapolitanPizzaDetailFragment newInstance(Bundle args){
        NeapolitanPizzaDetailFragment fr = new NeapolitanPizzaDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public NeapolitanPizzaDetailFragment(){
        super();
    }

    @Override
    public Datasource<Item> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = EmptyDatasource.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.neapolitanpizzadetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
        
        TextView view0 = (TextView) view.findViewById(R.id.view0);
        view0.setText("Traditional toppings");
        
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        Item item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, "Traditional toppings");
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

