package com.example.khalessi.rechnerapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.khalessi.rechnerapp.R.id.ausgabe;

/**
 * Created by Alexandra Filbert on 21.11.17.
 */

class MyOnClickListener implements View.OnClickListener {


    private Button[] ziffernButtons;
    private TextView ausgabeText;
    private boolean kommaFlag = false;
    private View kommaButton;

    public MyOnClickListener(TextView ausgabeText, Button[] buttons) {


    }

    @Override
    public void onClick(View v) {
        String ausgabe = "";

        for (int i = 0; i < 10; i++) {

            if (v == ziffernButtons[i]) {
                ausgabe += "" + i;
                ausgabeText.setText(ausgabe);
            }
        }


        if (!kommaFlag && v == kommaButton) {
            ausgabe += ",";
            ausgabeText.setText(ausgabe);
            kommaFlag = true;
        }

    }

}
