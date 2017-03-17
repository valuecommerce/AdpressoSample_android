package com.valuecommerce.adpresso.sample;

import com.adpresso.android.AdRequestNotifier;
import com.adpresso.android.AdpressoIconAdSet;
import com.adpresso.android.AdpressoIconView;
import com.adpresso.android.IconAdListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class IconAdActivity extends Activity implements IconAdListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_ad);

        // craete icon ads by layout
        addIconAdsByLayout();

        // create icon ads programmatically
        addIconAdsProgrammatically();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.icon_ad, menu);
        return true;
    }

    public void addIconAdsByLayout() {

        AdpressoIconView adView1 = (AdpressoIconView) findViewById(R.id.iconAdView1);
        AdpressoIconView adView2 = (AdpressoIconView) findViewById(R.id.iconAdView2);
        AdpressoIconAdSet set = new AdpressoIconAdSet(this, "Mjc3NzE%3D%0A");
        set.addRequestListener(this);
        set.add(adView1);
        set.add(adView2);
        set.load();
    }

    public void addIconAdsProgrammatically() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.icon_ad_linear_layout_code);

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        llp.setMargins(10, 20, 0, 0);

        LinearLayout.LayoutParams llp2 = new LinearLayout.LayoutParams(
                AdpressoIconView.getTextIconWidth(this), AdpressoIconView.getTextIconHeight(this));
        llp2.setMargins(10, 20, 0, 0);

        AdpressoIconView adView1 = new AdpressoIconView(this);
        AdpressoIconView adView2 = new AdpressoIconView(this);

        ll.addView(adView1, llp);
        ll.addView(adView2, llp2);

        AdpressoIconAdSet set = new AdpressoIconAdSet(this, "Mjc3NzE%3D%0A");
        set.addRequestListener(this);
        set.add(adView1);
        set.add(adView2);
        set.load();
    }

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
    public void onReceiveAd(AdRequestNotifier adRequestNotifier, int adCount) {
    }

}
