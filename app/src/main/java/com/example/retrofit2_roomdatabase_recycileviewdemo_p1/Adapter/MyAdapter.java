package com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.Model.Comment;
import com.example.retrofit2_roomdatabase_recycileviewdemo_p1.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Comment> commentList;

    public MyAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView_postId;
        TextView textView_id;
        TextView textView_nameId;
        TextView textView_emailId;
        TextView textView_bodyId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_postId = itemView.findViewById(R.id.textView_postId);
            textView_id     = itemView.findViewById(R.id.textView_id);
            textView_nameId = itemView.findViewById(R.id.textView_nameId);
            textView_emailId= itemView.findViewById(R.id.textView_emailId);
            textView_bodyId = itemView.findViewById(R.id.textView_bodyId);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Comment comment = commentList.get(position);

        holder.textView_postId.setText("postId : "+String.valueOf(comment.getPostId()));
        holder.textView_id.setText("id : "+String.valueOf(comment.getId()));
        holder.textView_nameId.setText("name : "+comment.getName());
        holder.textView_emailId.setText("email : "+comment.getEmail());
        holder.textView_bodyId.setText("body : "+comment.getBody());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


}
