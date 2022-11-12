package com.example.retrofit2_roomdatabase_recycileviewdemo_p1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Adapter.MyAdapter;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Database.CommentDatabase;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Model.Comment;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Comment> commentList;
    private MyAdapter myAdapter;
    private CommentRepository commentRepository;
    private CommentDatabase commentDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        commentList = new ArrayList<>();
        commentRepository = new CommentRepository(getApplication());
        commentDatabase   = CommentDatabase.getInstance(MainActivity.this);
        commentList = commentDatabase.commentDao().getAllComments();
        setAdapter();

        commentRepository.requestTestDataFromServer(this);
    }

    private void setAdapter() {
        MyAdapter myAdapter = new MyAdapter(this, commentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }

}