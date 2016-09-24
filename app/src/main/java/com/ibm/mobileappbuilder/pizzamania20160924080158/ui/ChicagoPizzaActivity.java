

package com.ibm.mobileappbuilder.pizzamania20160924080158.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.pizzamania20160924080158.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * ChicagoPizzaActivity list activity
 */
public class ChicagoPizzaActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.chicagoPizzaActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return ChicagoPizzaFragment.class;
    }

}

