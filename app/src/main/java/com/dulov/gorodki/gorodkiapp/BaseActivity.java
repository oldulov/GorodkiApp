package com.dulov.gorodki.gorodkiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dulov.gorodki.gorodkiapp.subactivity.AboutActivity;
import com.dulov.gorodki.gorodkiapp.subactivity.EventActivity;
import com.dulov.gorodki.gorodkiapp.subactivity.SendMessageActivity;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

/*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
*/
        switch (id) {
            case R.id.action_settings:
                Intent intent_event = new Intent(this, EventActivity.class);
                this.startActivity(intent_event);
                break;
            case R.id.nav_about:
                Intent intent_about = new Intent(this, AboutActivity.class);
                this.startActivity(intent_about);
                break;
            case R.id.nav_send:
                Intent intent_send = new Intent(this, SendMessageActivity.class);
                this.startActivity(intent_send);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Handle item selection
        switch (id) {
            case R.id.nav_event:
                Intent intent_event = new Intent(this, EventActivity.class);
                this.startActivity(intent_event);
                break;
            case R.id.nav_about:
                Intent intent_about = new Intent(this, AboutActivity.class);
                this.startActivity(intent_about);
                break;
            case R.id.nav_send:
                Intent intent_send = new Intent(this, SendMessageActivity.class);
                this.startActivity(intent_send);
                break;
            default:
                //return super.onOptionsItemSelected(item);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                break;
        }

        return true;

        /**
         if (id == R.id.nav_event) {
         // Handle the camera action
         } else if (id == R.id.nav_about) {

         } else if (id == R.id.nav_rank) {


         } else if (id == R.id.nav_share) {

         } else if (id == R.id.nav_send) {

         Intent i = new Intent(Intent.ACTION_SEND);
         i.setType("message/rfc822");
         i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ol.dulov@yandex.ru"});
         i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
         i.putExtra(Intent.EXTRA_TEXT   , "body of email");
         try {
         startActivity(Intent.createChooser(i, "Send mail..."));
         } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
         }
         return true;

         }
         **/


    }
}
