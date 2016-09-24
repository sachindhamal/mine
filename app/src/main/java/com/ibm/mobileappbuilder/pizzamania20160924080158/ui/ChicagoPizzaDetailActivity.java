

package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ibmmobileappbuilder.ui.BaseDetailActivity;

/**
 * ChicagoPizzaDetailActivity detail activity
 */
public class ChicagoPizzaDetailActivity extends BaseDetailActivity {
  
  	@Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return ChicagoPizzaDetailFragment.class;
    }
}


