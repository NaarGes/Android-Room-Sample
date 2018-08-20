package com.example.asus.roomfirsttry.ui;


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
import com.example.asus.roomfirsttry.entity.User;

import org.parceler.Parcels;

import java.util.List;


public class FirstFragment extends Fragment {

    private List<User> users;

    public FirstFragment() {

    }

    public static FirstFragment newInstance(List<User> users) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putParcelable("users", Parcels.wrap(users));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            users = Parcels.unwrap(getArguments().getParcelable("users"));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.query1_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        FirstAdapter adapter = new FirstAdapter();
        adapter.setUsers(users);
        recyclerView.setAdapter(adapter);
    }
}
