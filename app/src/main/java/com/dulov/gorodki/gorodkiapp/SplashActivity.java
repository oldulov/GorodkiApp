package com.dulov.gorodki.gorodkiapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by stack on 27.09.16.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation animLeft = AnimationUtils.loadAnimation (this, R.anim.move_left) ;
        Animation animRight = AnimationUtils.loadAnimation (this, R.anim.move_right) ;

        ImageView imageView = (ImageView) findViewById(R.id.imageViewSplash);
        imageView.setAnimation(animLeft);

        TextView textView = (TextView) findViewById(R.id.introView);
        textView.setAnimation(animRight);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);

    }
}
