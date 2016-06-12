package com.example.administrator.application;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Activity05_2 extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity05_2_view view = new Activity05_2_view(this);
        view.setOnTouchListener(view);
        setContentView(view);

    }
}
