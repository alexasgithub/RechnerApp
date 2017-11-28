package com.example.khalessi.rechnerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button[] ziffernButtons = new Button[10];
    private Button kommaButton, plusButton, minusButton, durchButton, malButton, gleichButton;
    private String ausgabe = "";
    private TextView ausgabeText;
    private boolean kommaFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
    }

    /**
     * Initialisiert die Buttons und hänge sie an den Listener an
     */
    private void initButtons() {

        ausgabeText = (TextView) findViewById(R.id.ausgabe);
        ziffernButtons[0] = (Button) findViewById(R.id.b0);
        ziffernButtons[1] = (Button) findViewById(R.id.b1);
        ziffernButtons[2] = (Button) findViewById(R.id.b2);
        ziffernButtons[3] = (Button) findViewById(R.id.b3);
        ziffernButtons[4] = (Button) findViewById(R.id.b4);
        ziffernButtons[5] = (Button) findViewById(R.id.b5);
        ziffernButtons[6] = (Button) findViewById(R.id.b6);
        ziffernButtons[7] = (Button) findViewById(R.id.b7);
        ziffernButtons[8] = (Button) findViewById(R.id.b8);
        ziffernButtons[9] = (Button) findViewById(R.id.b9);

        kommaButton = (Button) findViewById(R.id.bK);
        plusButton= (Button) findViewById(R.id.bPlus);
        minusButton = (Button) findViewById(R.id.bMinus);
        durchButton = (Button) findViewById(R.id.bDurch);
        malButton = (Button) findViewById(R.id.bMal);
        gleichButton = (Button) findViewById(R.id.bGleich);

        for (int i = 0; i < 10; i++) {
            ziffernButtons[i].setOnClickListener(btnListener);

        }

        kommaButton.setOnClickListener(btnListener);
        plusButton.setOnClickListener(btnListener);
        minusButton.setOnClickListener(btnListener);
        malButton.setOnClickListener(btnListener);
        durchButton.setOnClickListener(btnListener);
        gleichButton.setOnClickListener(btnListener);


    }

    /**
     * Ein Listener-Objekt, das bei allen View-Elementen registriert wird
     * und abhängig vom Ereignis die Zahl bzw. Komma in das Ausgabefeld schreibt
     */
    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
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

    };

}

