package com.example.week5classes2;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder> {
    // We don't know which view is clicked, we can use position as a variable
    // We should use interface which helps to interact with adapter and holder


    ArrayList<User> users;
    IUserRecyclerInterface mlistener;

    public UserRecyclerViewAdapter(ArrayList<User> data, IUserRecyclerInterface mlistener){
        this.users = data;
        this.mlistener = mlistener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This one creates a view based on a holder.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view, mlistener);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // This will binds the holder to a particular position
        User user = this.users.get(position);
        holder.textViewName.setText(user.name);
        holder.textViewAge.setText(user.age + " Years Old");
        holder.position = position;
        holder.user = user;
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    /* It needs to have ViewHolder */
    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName, textViewAge;
        View rootView;
        int position;
        User user;
        IUserRecyclerInterface mListener;
        public UserViewHolder(@NonNull View itemView, IUserRecyclerInterface mListener) {
            super(itemView);
            this.mListener = mListener;
            // We can instantiate the ViewHolder items here
            rootView = itemView; // If we want to store the root of the view
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewAge);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("demo", "onClick: item clicked "+ position + user);
                    mListener.gotoUserDetails(user);
                }
            });
            itemView.findViewById(R.id.buttonLike).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("demo", "onClick: Like for User " + user.name );
                }
            });
        }
    }

    interface IUserRecyclerInterface{
        void gotoUserDetails(User user);
    }

}