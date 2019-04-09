package com.example.HelloSensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inlamning1.R;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button buttonAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        buttonAcc = (Button) findViewById(R.id.acc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompass();

            }
        });
        buttonAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAcc();

            }
        });

    }

    public void openCompass(){
        Intent intent = new Intent(this, Compass.class);
         //Intent intent = new Intent(this, test2.class);
        startActivity(intent);
    }

    public void openAcc(){
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }
}