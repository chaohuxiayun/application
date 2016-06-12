package com.example.administrator.application;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/6/12.
 */

public class GetGupiaoActivity extends Activity{

    EditText ed1;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygupiao_layout);
        ed1 = (EditText) findViewById(R.id.gupiao_ed1);

        tv = (TextView) findViewById(R.id.gupiao_tv);
    }

    public void getgupiao(View view){
        Retrofit retrofit = new  Retrofit.Builder().baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetGuPiaoInterface gupiao  = retrofit.create(GetGuPiaoInterface.class);
        Call<GuPiao> c = gupiao.getgupiao("ccf924cd1c2bd7e36b3f4aa01f2457c9",ed1.getText().toString());
       /* c.enqueue(new Callback<GuPiao>() {
            @Override
            public void onResponse(Call<GuPiao> call, Response<GuPiao> response) {
                GuPiao g = response.body();
                tv.setText(g.getStockinfo().getCurrentPrice()+""+g.getStockinfo().getClosingPrice());

            }

            @Override
            public void onFailure(Call<GuPiao> call, Throwable t) {

            }
        });*/
        c.enqueue(new Callback<GuPiao>() {
            @Override
            public void onResponse(Call<GuPiao> call, Response<GuPiao> response) {
                GuPiao gp = response.body();
                tv.setText(gp.getRetData().getStockinfo().getName());
            }

            @Override
            public void onFailure(Call<GuPiao> call, Throwable t) {
                Log.e("132",t.getMessage());
            }
        });
    }

}

