package com.example.asus.roomfirsttry.ui.fourthfragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.roomfirsttry.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourthFragment extends Fragment {


    private int result;

    public FourthFragment() {
    }


    public static FourthFragment newInstance(int result) {

        Bundle args = new Bundle();

        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(args);
        args.putInt("result", result);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
            this.result = getArguments().getInt("result");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView number = view.findViewById(R.id.q4_text);
        number.setText(""+result);
    }
}
