package com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Model.Comment;

import java.util.List;
@Dao
public interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Comment> commentList);

    @Query("SELECT * FROM comment")
    List<Comment> getAllComments();

    @Query("DELETE FROM comment")
    void deleteAll();
}
