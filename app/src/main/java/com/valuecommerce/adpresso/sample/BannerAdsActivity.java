package com.valuecommerce.adpresso.sample;

import com.adpresso.android.AdpressoView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BannerAdsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ads);
        AdpressoView adView = (AdpressoView) findViewById(R.id.adView);
        adView.setPublisherID("Mjc3NzI%3D%0A");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.banner_ads, menu);
        return true;
    }

}
