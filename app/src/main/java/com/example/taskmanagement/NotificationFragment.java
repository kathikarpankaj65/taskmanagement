package com.example.taskmanagement;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationFragment extends Fragment implements Observer<Result> {

    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NotificationFragmentViewModel notificationFragmentViewModel=new NotificationFragmentViewModel();
        LiveData<Result> notificationFragmentMutableLiveData = notificationFragmentViewModel.getNotificationFragmentViewModel();
        notificationFragmentMutableLiveData.observe(getActivity(), this);
    }

    @Override
    public void onChanged(Result result) {
        if (result instanceof Loading) {
            progressBar = getActivity().findViewById(R.id.progressbar_notifications);
            progressBar.setVisibility(View.VISIBLE);
        }
        if (result instanceof Success) {
            progressBar.setVisibility(View.GONE);
            RecyclerView recyclerView = getActivity().findViewById(R.id.notification_fragment_recycle_view);
            Success<ArrayList<AdapterNotificationHomePage>> success=(Success) result;
            ArrayList<AdapterNotificationHomePage> arrayList = success.getT();
            recyclerView.setAdapter(new NotificationsAdapter(getActivity(), arrayList));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        else if (result instanceof Error) {
            progressBar.setVisibility(View.GONE);
            Error error = (Error) result;
            Toast.makeText(getActivity(), error.getException().getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}