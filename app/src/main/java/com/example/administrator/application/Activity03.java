package com.example.administrator.application;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/26.
 */


public class Activity03 extends Activity{

    DisplayMetrics dm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity03_layout);
       dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int  height = dm.heightPixels;
        int dpi = dm.densityDpi;
        TextView t = (TextView) findViewById(R.id.a01_text1);
        t.setText("宽"+width+" 高"+height+" dpi"+dpi);
    }
}
