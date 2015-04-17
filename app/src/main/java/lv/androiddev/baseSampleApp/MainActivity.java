package lv.androiddev.baseSampleApp;

import android.os.Bundle;
import lv.androiddev.BaseApp.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        layout = R.layout.activity_main;
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getFragmentTransaction(new PicturesFragment(), false).commit();
    }
}