package com.example.asus.roomfirsttry.ui.thirdquery;


import android.os.Bundle;
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

import org.parceler.Parcels;

import java.util.List;


public class ThirdFragment extends Fragment {


    private List<Comment> comments;

    public ThirdFragment() {

    }

    public static ThirdFragment newInstance(List<Comment> comments) {

        Bundle args = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
        args.putParcelable("comments", Parcels.wrap(comments));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            this.comments = Parcels.unwrap(getArguments().getParcelable("comments"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerView(view);
    }

    private void setRecyclerView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.query3_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ThirdAdapter adapter = new ThirdAdapter();
        adapter.setComments(comments);
        recyclerView.setAdapter(adapter);
    }
}
