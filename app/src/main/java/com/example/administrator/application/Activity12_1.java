package com.example.administrator.application;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity12_1 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BallView m = new BallView(this);
        setContentView(m);
        m.setOnTouchListener(m);
}
}
