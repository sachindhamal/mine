package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.ViewHolder;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.Item;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.EmptyDatasource;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "NewYorkStylePizzaFragment" listing
 */
public class NewYorkStylePizzaFragment extends ListGridFragment<Item>  {

    private Datasource<Item> datasource;


    public static NewYorkStylePizzaFragment newInstance(Bundle args) {
        NewYorkStylePizzaFragment fr = new NewYorkStylePizzaFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected SearchOptions getSearchOptions() {
      SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
      return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.newyorkstylepizza_item;
    }

    @Override
    protected Datasource<Item> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = EmptyDatasource.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(Item item, View view, int position) {
    }


    @Override
    public void showDetail(Item item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), NewYorkStylePizzaDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}

