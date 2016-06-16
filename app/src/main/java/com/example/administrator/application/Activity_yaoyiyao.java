package com.example.administrator.application;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/14.
 */
public class Activity_yaoyiyao extends Activity implements SensorEventListener{

    EditText jiasudu;
    EditText fangxiang;
    EditText tuoluoyi;
    EditText cichang;
    EditText zhongli;
    EditText xianxin;
    EditText wendu;
    EditText guang;
    EditText yali;

    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_yaoyiyao);
        fangxiang = (EditText) findViewById(R.id.fangxiang);
        jiasudu = (EditText) findViewById(R.id.jiasudu);
        tuoluoyi = (EditText) findViewById(R.id.tuoluoyi);
        cichang = (EditText) findViewById(R.id.cichang);
        zhongli = (EditText) findViewById(R.id.zhongli);
        xianxin = (EditText) findViewById(R.id.xianxin);
        wendu = (EditText) findViewById(R.id.wendu);
        guang = (EditText) findViewById(R.id.guang);
        yali = (EditText) findViewById(R.id.yali);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //光传感器
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_GRAVITY),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_PRESSURE),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        int sensorType = event.sensor.getType();
        StringBuilder sb = null;
        switch (sensorType){
            case Sensor.TYPE_ORIENTATION:
                sb = new StringBuilder();
                sb.append("绕z轴角度");
                sb.append(values[0]);
                sb.append("绕y轴角度");
                sb.append(values[1]);
                sb.append("绕x轴角度");
                sb.append(values[2]);
                fangxiang.setText(sb.toString());
                break;

            case Sensor.TYPE_GYROSCOPE:
                sb = new StringBuilder();
                sb.append("绕x轴角速度");
                sb.append(values[0]);
                sb.append("绕y轴角速度");
                sb.append(values[1]);
                sb.append("绕z轴角速度");
                sb.append(values[2]);
                tuoluoyi.setText(sb.toString());
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                sb = new StringBuilder();
                sb.append("x轴磁场强度");
                sb.append(values[0]);
                sb.append("y轴磁场强度");
                sb.append(values[1]);
                sb.append("z轴磁场强度");
                sb.append(values[2]);
                cichang.setText(sb.toString());
                break;

            case Sensor.TYPE_GRAVITY:
                sb = new StringBuilder();
                sb.append("x轴重力");
                sb.append(values[0]);
                sb.append("y轴重力");
                sb.append(values[1]);
                sb.append("z轴重力");
                sb.append(values[2]);
                zhongli.setText(sb.toString());
                break;

            case Sensor.TYPE_LINEAR_ACCELERATION:
                sb = new StringBuilder();
                sb.append("绕x轴线性加速度");
                sb.append(values[0]);
                sb.append("绕y轴线性加速度");
                sb.append(values[1]);
                sb.append("绕z轴线性加速度");
                sb.append(values[2]);
                xianxin.setText(sb.toString());
                break;

            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                sb = new StringBuilder();
                sb.append("当前温度");
                sb.append(values[0]);

                wendu.setText(sb.toString());
                break;

            case Sensor.TYPE_LIGHT:
                sb = new StringBuilder();
                sb.append("光强");
                sb.append(values[0]);
                guang.setText(sb.toString());
                break;
            case Sensor.TYPE_PRESSURE:
                sb = new StringBuilder();
                sb.append("压力");
                sb.append(values[0]);

                yali.setText(sb.toString());
                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onStop() {
        sm.unregisterListener(this);
        super.onStop();
    }
}
