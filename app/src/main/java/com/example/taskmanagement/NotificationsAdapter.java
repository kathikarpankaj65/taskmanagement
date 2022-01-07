package com.example.taskmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    ArrayList<AdapterNotificationHomePage> arrayList;
    Context context;
    NotificationsAdapter(Context context, ArrayList<AdapterNotificationHomePage> arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        return new NotificationViewHolder(layoutInflater.inflate(R.layout.adapter_notifications, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        AdapterNotificationHomePage adapterNotificationHomePage = arrayList.get(position);
        ImageView imageView = holder.itemView.findViewById(R.id.imageview_notifications);
        TextView textView = holder.itemView.findViewById(R.id.textview_title);
        //imageView.setImageResource(adapterNotificationHomePage.getImage());
        Glide.with(context)
                .load(adapterNotificationHomePage.getImage())
                .circleCrop()
                .into(imageView);
        textView.setText(adapterNotificationHomePage.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
