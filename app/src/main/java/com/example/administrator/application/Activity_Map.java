package com.example.administrator.application;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.*;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.util.Log;


import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Activity_Map extends Activity {

    MapView mMapView = null;
    BaiduMap mBaiduMap;
    LocationManager lm;
    LatLng point;
    OverlayOptions option;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_layout_map);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.mapview);





        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        String p = LocationManager.NETWORK_PROVIDER;


            l =lm.getLastKnownLocation(p);

        updateView(l);

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 8, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(Activity_Map.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Activity_Map.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updateView(l);
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    public void updateView(Location l)
    {
        if(l!=null)
        {
            point = new LatLng(l.getLongitude(), l.getLatitude());
            Log.e("111111",l.getLongitude()+"---"+ l.getLatitude());
           draw(point);
        }else{
            /*point = new LatLng(39.963175, 116.400244);
            Log.e("qwewq",32+"---"+43);*/
        }
    }

    public void draw(LatLng p){
        //构建Marker图标
        mMapView.removeAllViews();
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.zhibiao);
//构建MarkerOption，用于在地图上添加Marker
        option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
//在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);

    }

}

