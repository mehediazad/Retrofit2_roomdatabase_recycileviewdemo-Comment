package com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCallingInstance {

    // set Url link
    private static final String URL_DATA ="https://jsonplaceholder.typicode.com/" ;

    public static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit ==null){
            retrofit=new retrofit2.Retrofit.Builder()
                    .baseUrl(URL_DATA)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();}
        return retrofit;
    }
    public Api api=retrofit.create(Api.class);
}
