package com.example.week5classes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    /*
        ListView is android component that allows us to organize data in a scrollable list. And it needs an adapter which tells what to display.
        Each row is a layout. Android provides a default layouts and we can use it
     */

    ListView listView;
    String colors[] = {"Red","Green", "Blue", "Yellow", "Black", "Brown", "Purple", "Violet", "Gray", "Pink", "SkyBlue", "Orange", "Indigo", "Baby blue"};
    ArrayList<User> users = new ArrayList<>();
    // ArrayAdapter<String> adapter;
    // ArrayAdapter<User> adapter;
    UserAdapter adapter;
    int orderType = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<10;i++) {
            users.add(new User("Bob Smith", 45));
            users.add(new User("Alice Brown", 25));
            users.add(new User("Tom White", 21));
            users.add(new User("Bill Green", 28));
            users.add(new User("Eve Green", 30));
        }

        // Getting the listView from activity
        listView = findViewById(R.id.listView);
        // initializing the adapter
        // adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, colors);
        // android.R.layout.simple_list_item_1 => This needs a simple String
        // adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, users);
        // Adding adapter to the listView, so that listView can use the adapter
        // Note: We are sending the data to the adapter, and passing adapter to the listView
        //listView.setAdapter(adapter);


        adapter = new UserAdapter(this, R.layout.user_row_item,users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                /*
                // Log.d("demo", "onItemClick: "+position + ".Color is " + colors[position]);
                User u = (User) users.get(position);
                User u = adapter.getItem(position);
                // users.remove(u);
                adapter.remove(u);
                // adapter.notifyDataSetChanged();
                */
                orderType *= -1;
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return orderType * user1.getName().compareTo( user2.getName() );
                    }
                });
                // adapter.notifyDataSetChanged();
            }
        });
    }
}