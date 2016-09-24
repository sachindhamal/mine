
package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.Item;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.EmptyDatasource;

public class NewYorkStylePizzaDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    public static NewYorkStylePizzaDetailFragment newInstance(Bundle args){
        NewYorkStylePizzaDetailFragment fr = new NewYorkStylePizzaDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public NewYorkStylePizzaDetailFragment(){
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

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.newyorkstylepizzadetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
}

