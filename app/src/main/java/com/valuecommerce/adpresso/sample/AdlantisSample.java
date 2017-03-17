package com.valuecommerce.adpresso.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.adpresso.android.AdManager;
import com.adpresso.android.AdRequestNotifier;
import com.adpresso.android.AdpressoInterstitialAd;
import com.adpresso.android.InterstitialAdListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AdlantisSample extends Activity {
    private final static String VIEW_TYPE_BANNER_ADS = "banner ads";
    private final static String VIEW_TYPE_ICON_ADS = "icon ads";
    private final static String VIEW_TYPE_INTERSTITIAL_ADS = "interstitial ad";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView versionText = (TextView) findViewById(R.id.versionText);
        if (versionText != null) {
            versionText.setText(AdManager.sdkFullVersion());
        }

        // List view setup
        setupListView();
    }

    public void setupListView() {
        ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[] { VIEW_TYPE_BANNER_ADS,
                VIEW_TYPE_ICON_ADS, VIEW_TYPE_INTERSTITIAL_ADS, };

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                final String item = (String) arg0.getItemAtPosition(arg2);

                if (item == VIEW_TYPE_BANNER_ADS) {
                    showBannerAds();
                } else if (item == VIEW_TYPE_ICON_ADS) {
                    showIconAds();
                } else if (item == VIEW_TYPE_INTERSTITIAL_ADS) {
                    showInterstitial();
                }
            }

        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

    /* *
     * Show Banner Ads
     */
    public void showBannerAds() {
        Intent intent = new Intent(this, BannerAdsActivity.class);
        this.startActivity(intent);
    }

    /* *
     * Show Icon Ads
     */
    public void showIconAds() {
        Intent intent = new Intent(this, IconAdActivity.class);
        this.startActivity(intent);
    }

    /* *
     * Show Interstitial Ads
     */
    public void showInterstitial() {
        // interstitial ads
        InterstitialAdListener listener = new InterstitialAdListener() {
            @Override
            public void onFailedToReceiveAd(AdRequestNotifier adRequestNotifier) {
            }

            @Override
            public void onReceiveAd(AdRequestNotifier adRequestNotifier) {
            }

            @Override
            public void onTouchAd(AdRequestNotifier adRequestNotifier) {
            }

            @Override
            public void onDismissScreen(AdRequestNotifier adRequestNotifier) {
            }

            @Override
            public void onPresentScreen(AdRequestNotifier adRequestNotifier) {
            }
            
        };
        AdpressoInterstitialAd ad = new AdpressoInterstitialAd(this, "Mjc3NzA%3D%0A");
        ad.addRequestListener(listener);
        ad.show();
    }

}
