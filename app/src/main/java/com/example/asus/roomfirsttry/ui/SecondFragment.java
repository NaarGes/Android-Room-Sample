package com.example.asus.roomfirsttry.ui;


import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.roomfirsttry.R;
import com.example.asus.roomfirsttry.entity.Comment;
import com.example.asus.roomfirsttry.entity.User;
import com.example.asus.roomfirsttry.ui.firstquery.FirstAdapter;
import com.example.asus.roomfirsttry.ui.firstquery.FirstFragment;

import org.parceler.Parcels;

import java.util.List;

public class SecondFragment extends Fragment {

    private List<Comment> comments;


    public SecondFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public static SecondFragment newInstance(List<Comment> comments) {

        Bundle args = new Bundle();
        SecondFragment fragment = new SecondFragment();
        args.putParcelable("comments", Parcels.wrap(comments));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            comments = Parcels.unwrap(getArguments().getParcelable("comments"));
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerView(view);
    }

    private void setRecyclerView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.query2_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SecondAdapter adapter = new SecondAdapter();
        adapter.setComments(comments);
        recyclerView.setAdapter(adapter);
    }

}
