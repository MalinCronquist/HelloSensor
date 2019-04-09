package com.example.HelloSensor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import com.example.inlamning1.R;


public class Accelerometer extends AppCompatActivity implements  SensorEventListener{

    private TextView xText, yText, zText, direction;
    private Sensor mySensor;
    private SensorManager SM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);


        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        direction = (TextView)findViewById(R.id.direction);
    }


    public void onAccuracyChanged (Sensor sensor, int accuracy){}

    public void onSensorChanged(SensorEvent event){
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if(event.values[0] < 0 ){
            direction.setText("Telefonen lutar åt höger.");
            getWindow().getDecorView().setBackgroundColor(Color.rgb(153, 255, 102));
        } else {
            direction.setText("Telefonen lutar åt vänster.");
            getWindow().getDecorView().setBackgroundColor(Color.rgb(255, 255, 153));


        }
    }
}
