package com.example.asus.roomfirsttry.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.roomfirsttry.Presenter;
import com.example.asus.roomfirsttry.R;
import com.example.asus.roomfirsttry.database.AppDatabase;
import com.example.asus.roomfirsttry.entity.User;
import com.example.asus.roomfirsttry.ui.firstquery.FirstFragment;
import com.example.asus.roomfirsttry.util.DataGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Presenter presenter;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase database = AppDatabase.getAppDatabase(this);

        DataGenerator.with(database).generateUsers();
        DataGenerator.with(database).generatePosts();
        DataGenerator.with(database).generateComments();

        presenter = new Presenter();

        Button query1 = findViewById(R.id.query1_butt);
        query1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText postId = findViewById(R.id.query1_et);
                if(!postId.getText().toString().equals("")) {
                    users = presenter.firstQueryResult(database, Integer.parseInt(postId.getText().toString()));

                    FirstFragment firstFragment = FirstFragment.newInstance(users);
                    setFragment(firstFragment);
                } else {
                    Toast.makeText(getApplicationContext(), "Please inter an User ID", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button query2 = findViewById(R.id.query2_butt);
        Button query3 = findViewById(R.id.query3_butt);
        Button query4 = findViewById(R.id.query4_butt);

    }

    private void setFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_container, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
