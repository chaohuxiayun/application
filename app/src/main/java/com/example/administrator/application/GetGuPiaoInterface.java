
package com.example.administrator.application;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GetGuPiaoInterface {
    @GET("/apistore/stockservice/hkstock")
    Call<GuPiao> getgupiao(@Header("apikey") String apikey, @Query("stockid") String stockid);
}

