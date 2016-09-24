package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.ViewHolder;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.ChicagoPizzaDSSchemaItem;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.ChicagoPizzaDS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "ChicagoPizzaFragment" listing
 */
public class ChicagoPizzaFragment extends ListGridFragment<ChicagoPizzaDSSchemaItem>  {

    private Datasource<ChicagoPizzaDSSchemaItem> datasource;


    public static ChicagoPizzaFragment newInstance(Bundle args) {
        ChicagoPizzaFragment fr = new ChicagoPizzaFragment();

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
        return R.layout.chicagopizza_item;
    }

    @Override
    protected Datasource<ChicagoPizzaDSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = ChicagoPizzaDS.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(ChicagoPizzaDSSchemaItem item, View view, int position) {
        
        ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
        ImageView image = ViewHolder.get(view, R.id.image);
        if(item.picture != null){
            imageLoader.load(imageLoaderRequest()
                            .withResourceToLoad(item.picture)
                            .withTargetView(image)
                            .fit()
                            .build()
            );
            
        }
        else {
          imageLoader.load(imageLoaderRequest()
                          .withResourceToLoad(R.drawable.ic_ibm_placeholder)
                          .withTargetView(image)
                          .build()
          );
        }
        
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.type != null){
            title.setText(item.type);
            
        }
    }


    @Override
    public void showDetail(ChicagoPizzaDSSchemaItem item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), ChicagoPizzaDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}

