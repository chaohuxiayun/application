package com.example.administrator.application;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/15.
 */
public class Activityzhinanzhen extends Activity implements SensorEventListener{

    ImageView img;
    Bitmap b;
    SensorManager sm;
    float cd = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_zhinanzhen);
        img = (ImageView) findViewById(R.id.zhinanzhen);
        img.setImageResource(R.drawable.zhinanzhen);
      /*  b = BitmapFactory.decodeResource(getResources(),R.drawable.zhinanzhen);
        img.setImageBitmap(b);*/
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    }



    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        sm.unregisterListener(this);
        super.onPause();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int st = event.sensor.getType();
        switch (st){
            case Sensor.TYPE_ORIENTATION:
                float degree = event.values[0];
                RotateAnimation ra = new RotateAnimation(cd,-degree, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                ra.setDuration(200);
                img.startAnimation(ra);

                cd = -degree;
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
