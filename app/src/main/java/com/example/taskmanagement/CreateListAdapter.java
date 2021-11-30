package com.example.taskmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreateListAdapter extends RecyclerView.Adapter<CreateViewHolder> {

    ArrayList<AdapterListViewHomePage> arrayList;
    Context context;
    CreateListAdapter(Context context, ArrayList<AdapterListViewHomePage> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public CreateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        return new CreateViewHolder(layoutInflater.inflate(R.layout.adapter_create_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CreateViewHolder holder, int position) {
        AdapterListViewHomePage adapterListViewHomePage=arrayList.get(position);
        ImageView imageView=holder.itemView.findViewById(R.id.list_image);
        TextView textView=holder.itemView.findViewById(R.id.textview_title);
        TextView textView1=holder.itemView.findViewById(R.id.textview_date_time);
        imageView.setImageResource(adapterListViewHomePage.getImage());
        textView.setText(adapterListViewHomePage.getFirst_title());
        textView1.setText(adapterListViewHomePage.getDate_time());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
