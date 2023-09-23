package com.example.week5classes2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserRecyclerViewAdapter.IUserRecyclerInterface {
    /*
        RecyclerViews is an advanced version of ListView.
        It decouples the scrolling or direction of scrolling, which can be scrolled in any direction.
     */

    RecyclerView recyclerView;

    // There are different layout's like Horizontal, grid
    LinearLayoutManager layoutManager;
    ArrayList<User> users = new ArrayList<>();
    UserRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("Bob Smith", 45));
        users.add(new User("Alice Brown", 25));
        users.add(new User("Tom White", 21));
        users.add(new User("Bill Green", 28));
        users.add(new User("Eve Green", 30));

        recyclerView = findViewById(R.id.recyclerView);
        // This needs a separate adapter, which is different from ListViews adapter
        recyclerView.setHasFixedSize(true);

        // For this it's vertical, which means we can just scroll up or down
        // We can use other constructor, where orientation can be HORIZONTAL or VERTICAL
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        // Passing listener as this, as activity is implementing the interface
        adapter = new UserRecyclerViewAdapter(users, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void gotoUserDetails(User user) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
         startActivity(intent);
    }
}