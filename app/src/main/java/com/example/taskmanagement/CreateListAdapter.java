package com.example.taskmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CreateListAdapter extends RecyclerView.Adapter<CreateViewHolder> {

    Context context;
    CreateListAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public CreateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        return new CreateViewHolder(layoutInflater.inflate(R.layout.adapter_create_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CreateViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
