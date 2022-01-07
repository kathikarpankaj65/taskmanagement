package com.example.taskmanagement;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class NotificationFragmentViewModel extends ViewModel {
    LiveData<Result> getNotificationFragmentViewModel() {
        MutableLiveData<Result> notificationFragmentMutableLiveData = new MutableLiveData<Result>();
        NotificationFragmentThread notificationFragmentThread = new NotificationFragmentThread(notificationFragmentMutableLiveData);
        notificationFragmentThread.start();
        return notificationFragmentMutableLiveData;
    }
}

class NotificationFragmentThread extends Thread {
    Repository repository;
    Success<ArrayList<AdapterNotificationHomePage>> success;
    final MutableLiveData<Result> notificationFragmentMutableLiveData;
    NotificationFragmentThread(MutableLiveData<Result> notificationFragmentMutableLiveData) {
        this.notificationFragmentMutableLiveData = notificationFragmentMutableLiveData;
    }

    @Override
    public void run() {
        try {
            notificationFragmentMutableLiveData.postValue(new Loading());
            Thread.sleep(2000);
            repository = new Local();
            ArrayList<AdapterNotificationHomePage> arrayList = repository.getNotificationArrayList();
            success = new Success<ArrayList<AdapterNotificationHomePage>>(arrayList);
            notificationFragmentMutableLiveData.postValue(success);
        }
        catch (Exception e) {
            try {
                Thread.sleep(2000);
                notificationFragmentMutableLiveData.postValue(new Error(e));
            }
            catch (Exception exception){
                exception.getMessage();
            }
        }
    }
}