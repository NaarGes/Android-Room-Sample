package com.example.asus.roomfirsttry.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.roomfirsttry.R;
import com.example.asus.roomfirsttry.entity.Comment;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private List<Comment> comments;

    SecondAdapter() {

    }

    public void setComments(List<Comment> comments) {

        this.comments = comments;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second, parent, false);
        return new ViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(comments.get(position));
    }

    @Override
    public int getItemCount() {

        if(comments == null)
            return 0;
        return comments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        ViewHolder(View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.q2_text);

        }

        void onBind(Comment comment) {

            text.setText(comment.getComment());
        }
    }
}
