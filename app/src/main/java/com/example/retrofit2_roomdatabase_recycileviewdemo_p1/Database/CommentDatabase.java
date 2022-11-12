package com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Model.Comment;

@Database(entities = {Comment.class}, version = 1,exportSchema = false)
public abstract class CommentDatabase extends RoomDatabase {
    //Create database instance

    private static volatile CommentDatabase INSTANCE;
    private static String DATABASE_NAME = "CommentDatabase";

    public synchronized static CommentDatabase getInstance( Context context) {
        if (INSTANCE == null){
            //Initialize Database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            ,CommentDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    //Create Dao
    public abstract CommentDao commentDao();
}
