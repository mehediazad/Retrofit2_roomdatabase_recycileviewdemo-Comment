package com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Network;

import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
   @GET("comments")
   Call<List<Comment>> getCommentData();

}
