package com.dulov.gorodki.gorodkiapp.subactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.dulov.gorodki.gorodkiapp.BaseActivity;
import com.dulov.gorodki.gorodkiapp.R;

public class SendMessageActivity extends BaseActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void sendFeedback(View button) {


        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
        String feedback = feedbackField.getText().toString();

        final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        String feedbackType = feedbackSpinner.getSelectedItem().toString();


        final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        boolean bRequiresResponse = responseCheckbox.isChecked();

        // Take the fields and format the message contents
        String subject = formatFeedbackSubject(feedbackType);

        String message = formatFeedbackMessage(feedbackType, name,
                email, feedback, bRequiresResponse);

        // Create the message
        sendFeedbackMessage(subject, message);
    }


    protected String formatFeedbackSubject(String feedbackType) {

        String strFeedbackSubjectFormat = getResources().getString(
                R.string.feedbackmessagesubject_format);

        String strFeedbackSubject = String.format(strFeedbackSubjectFormat, feedbackType);

        return strFeedbackSubject;

    }

    protected String formatFeedbackMessage(String feedbackType, String name,
                                           String email, String feedback, boolean bRequiresResponse) {

        String strFeedbackFormatMsg = getResources().getString(
                R.string.feedbackmessagebody_format);

        String strRequiresResponse = getResponseString(bRequiresResponse);

        String strFeedbackMsg = String.format(strFeedbackFormatMsg,
                feedbackType, feedback, name, email, strRequiresResponse);

        return strFeedbackMsg;

    }


    protected String getResponseString(boolean bRequiresResponse)
    {
        if(bRequiresResponse==true)
        {
            return getResources().getString(R.string.feedbackmessagebody_responseyes);
        } else {
            return getResources().getString(R.string.feedbackmessagebody_responseno);
        }

    }

    public void sendFeedbackMessage(String subject, String message) {

        Intent messageIntent = new Intent(android.content.Intent.ACTION_SEND);

        String aEmailList[] = { "appfeedback@yourappwebsite.com" };
        messageIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);

        messageIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);

        messageIntent.setType("plain/text");
        messageIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);

        startActivity(messageIntent);
    }

}
