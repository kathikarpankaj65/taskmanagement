package com.example.taskmanagement;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplashScreenActivityViewModel extends ViewModel {
    LiveData<Result> getSplashScreenActivityViewModel() {
        MutableLiveData<Result> splashScreenMutableLiveData = new MutableLiveData<Result>();
        SplashScreenActivityThread splashScreenActivityThread = new SplashScreenActivityThread(splashScreenMutableLiveData);
        splashScreenActivityThread.start();
        return splashScreenMutableLiveData;
    }
}

class SplashScreenActivityThread extends Thread {
    final MutableLiveData<Result> splashScreenMutableLiveData;
    SplashScreenActivityThread(MutableLiveData<Result> splashScreenMutableLiveData) {
        this.splashScreenMutableLiveData = splashScreenMutableLiveData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            splashScreenMutableLiveData.postValue(new Success<>(null));
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
}