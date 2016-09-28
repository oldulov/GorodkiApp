package com.dulov.gorodki.gorodkiapp.subactivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.dulov.gorodki.gorodkiapp.BaseActivity;
import com.dulov.gorodki.gorodkiapp.R;

/**
 * Created by stack on 28.09.16.
 */

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //menu.removeItem(R.id.);
        return true;
    }
}