package com.dulov.gorodki.gorodkiapp.subactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.dulov.gorodki.gorodkiapp.MainActivity;
import com.dulov.gorodki.gorodkiapp.R;

/**
 * Created by stack on 28.09.16.
 */

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //menu.removeItem(R.id.);
        return true;
    }
}