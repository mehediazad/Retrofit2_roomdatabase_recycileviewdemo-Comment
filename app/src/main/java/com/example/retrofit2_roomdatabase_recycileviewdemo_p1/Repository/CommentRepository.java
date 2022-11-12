package com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Repository;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Database.CommentDatabase;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Model.Comment;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Network.Api;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Network.ApiCallingInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentRepository {
    private static CommentDatabase commentDatabase;
    private List<Comment> getAllComments;
    private Application application;
    private Api apiClient;

    public CommentRepository(Application application) {
        this.application = application;
        apiClient = ApiCallingInstance.getRetrofit().create(Api.class);
        commentDatabase = CommentDatabase.getInstance(application);

        getAllComments = commentDatabase.commentDao().getAllComments();
    }

    public List<Comment> getAllComments() {
        return getAllComments;
    }

    public void requestTestDataFromServer(Context context) {
        Call<List<Comment>> call = apiClient.getCommentData();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Size " + response.body().size(), Toast.LENGTH_SHORT).show();

                    // insert Room Database
                    commentDatabase.commentDao().insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(context, "something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
