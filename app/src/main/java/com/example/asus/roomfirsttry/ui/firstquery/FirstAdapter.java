package com.example.asus.roomfirsttry.ui.firstquery;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.roomfirsttry.R;
import com.example.asus.roomfirsttry.entity.User;

import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder> {

    private List<User> users;

    FirstAdapter() {

    }

    public void setUsers(List<User> users) {

        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first_fragment, parent, false);
        return new ViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(users.get(position));
    }

    @Override
    public int getItemCount() {

        if(users == null)
            return 0;
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView avatar;

        ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.q1_name);
            avatar = itemView.findViewById(R.id.q1_avatar);
        }

        void onBind(User user) {

            if(!user.getAvatarUrl().equals(""))
                Glide.with(itemView.getContext()).load(user.getAvatarUrl()).into(avatar);

            name.setText(user.getFirstName() + " " + user.getLastName());
        }
    }
}
