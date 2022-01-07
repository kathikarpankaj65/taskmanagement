package com.example.taskmanagement;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    LiveData<Result> getMainActivityViewModel(String username, String password) {
        MutableLiveData<Result> mainActivityLiveData = new MutableLiveData<Result>();
        MainActivityThread mainActivityThread = new MainActivityThread(mainActivityLiveData, username, password);
        mainActivityThread.start();
        return mainActivityLiveData;
    }
}

class MainActivityThread extends Thread {
    Success<Integer> success;
    final MutableLiveData<Result> mainActivityLiveData;
    final String username, password;
    MainActivityThread(MutableLiveData<Result> mainActivityLiveData, String username, String password){
        this.mainActivityLiveData = mainActivityLiveData;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        try {
            mainActivityLiveData.postValue(new Loading());
            if (username == null || username.isEmpty()) {
                throw new UsernameException();
            }
            else if (password == null || password.isEmpty()) {
                throw new PasswordException();
            }
            Thread.sleep(2000);
            mainActivityLiveData.postValue(new Success<Integer>(5636));
        }
        catch (Exception e) {
            try {
                Thread.sleep(2000);
                mainActivityLiveData.postValue(new Error(e));
            }
            catch (Exception exception){
                exception.getMessage();
            }
        }
    }
}