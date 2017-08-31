package com.bork.tindog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView) findViewById(R.id.welcomeText);

        Button dogPicks = (Button) findViewById(R.id.picsButton);
            dogPicks.setOnClickListener(new View.OnClickListener(){
                @Override

                public void onClick(View view){
                    Intent intnt = new Intent(MainActivity.this, DogPics.class);
                    startActivity(intnt);
                }
            });
        Button preferencesbut = (Button) findViewById(R.id.prefencesButton);
        preferencesbut.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                Intent intnt = new Intent(MainActivity.this, MainPreferences.class);
                startActivity(intnt);
            }
        });

    }
}
