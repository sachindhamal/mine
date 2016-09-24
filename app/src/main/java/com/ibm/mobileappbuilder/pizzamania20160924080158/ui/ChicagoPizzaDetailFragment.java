
package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.pizzamania20160924080158.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.ChicagoPizzaDSSchemaItem;
import com.ibm.mobileappbuilder.pizzamania20160924080158.ds.ChicagoPizzaDS;

public class ChicagoPizzaDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<ChicagoPizzaDSSchemaItem> implements ShareBehavior.ShareListener  {

    private Datasource<ChicagoPizzaDSSchemaItem> datasource;
    public static ChicagoPizzaDetailFragment newInstance(Bundle args){
        ChicagoPizzaDetailFragment fr = new ChicagoPizzaDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public ChicagoPizzaDetailFragment(){
        super();
    }

    @Override
    public Datasource<ChicagoPizzaDSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = ChicagoPizzaDS.getInstance(new SearchOptions());
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
        return R.layout.chicagopizzadetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final ChicagoPizzaDSSchemaItem item, View view) {
        if (item.type != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.type);
            
        }
        
        if(item.picture != null){
            ImageView view2 = (ImageView) view.findViewById(R.id.view2);
            ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
            imageLoader.load(imageLoaderRequest()
                            .withResourceToLoad(item.picture)
                            .withTargetView(view2)
                            .build()
            );
            
        }
        if (item.price != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.price.toString());
            
        }
    }

    @Override
    protected void onShow(ChicagoPizzaDSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        ChicagoPizzaDSSchemaItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.type != null ? item.type : "" ) + "\n" +
                    (item.price != null ? item.price.toString() : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

