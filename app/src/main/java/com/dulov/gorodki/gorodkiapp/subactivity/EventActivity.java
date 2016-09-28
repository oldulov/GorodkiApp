package com.dulov.gorodki.gorodkiapp.subactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dulov.gorodki.gorodkiapp.BaseActivity;
import com.dulov.gorodki.gorodkiapp.MainActivity;
import com.dulov.gorodki.gorodkiapp.R;
import com.dulov.gorodki.gorodkiapp.SplashActivity;

/**
 * Created by stack on 28.09.16.
 */

public class EventActivity extends BaseActivity {

    private SeekBar seekBar;
    private TextView partieView, bitsView, gameView;
    private int TotalBits = 20;
    private int Parties = 1;


    private void getImageView ( LinearLayout layout){
        for (int i = 0; i < 14; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.mipmap.ic_launcher));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }

    }

    // A private method to help us initialize our variables.
    private void initializeVariables() {
        int totalbits = TotalBits;
        String gameType = "Eurogorodki";

        gameView = (TextView) findViewById(R.id.gameView);
        gameView.append(" " + gameType + " " + totalbits + " " + getString(R.string.bits));

        partieView = (TextView) findViewById(R.id.partieView);
        partieView.setText( String.valueOf(Parties));

        bitsView = (TextView) findViewById(R.id.bitsView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(totalbits);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                bitsView.setText(progress + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        initializeVariables();

        // Initialize the textview with '0'.
        bitsView.setText(seekBar.getProgress() + "/" + seekBar.getMax());

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        getImageView(layout);

        final Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                seekBar.setProgress(seekBar.getProgress() + 1);
                bitsView.setText(seekBar.getProgress() + "/" + seekBar.getMax());

                if (seekBar.getProgress() == TotalBits) {
                    if (Parties == 1) {
                        Parties = 2;
                        seekBar.setProgress(0);
                        partieView.setText(R.string.partie_type + " " + String.valueOf(Parties));

                    } else {
                        Toast.makeText(getApplicationContext(), "Partie is over!!!", Toast.LENGTH_SHORT).show();
                        AlertDialog alertDialog = new AlertDialog.Builder(EventActivity.this).create();
                        alertDialog.setTitle("Partie is over");
                        alertDialog.setMessage("Start once again?");
                        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        startActivity(new Intent(EventActivity.this, EventActivity.class));
                                        finish();
                                    }
                                });
                        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Go to Main menu",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        startActivity(new Intent(EventActivity.this, MainActivity.class));
                                        finish();
                                    }
                                });
                        alertDialog.show();
                    }
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //menu.removeItem(R.id.);
        return true;
    }
}