package com.example.taskmanagement;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class CreateFragmentViewModel extends ViewModel {
    LiveData<Result> getCreateFragmentViewModel() {
        MutableLiveData<Result> createFragmentMutableLiveData = new MutableLiveData<Result>();
        CreateFragmentThread createFragmentThread = new CreateFragmentThread(createFragmentMutableLiveData);
        createFragmentThread.start();
        return createFragmentMutableLiveData;
    }
}

class CreateFragmentThread extends Thread {
    Repository repository;
    final MutableLiveData<Result> createFragmentMutableLiveData;
    CreateFragmentThread(MutableLiveData<Result> createFragmentMutableLiveData) {
        this.createFragmentMutableLiveData = createFragmentMutableLiveData;
    }

    @Override
    public void run() {
        try {
            createFragmentMutableLiveData.postValue(new Loading());
            Thread.sleep(2000);
            repository = new Local();
            ArrayList<AdapterListViewHomePage> arrayList = repository.getArrayList();
            createFragmentMutableLiveData.postValue(new Success<ArrayList<AdapterListViewHomePage>>(arrayList));
        }
        catch (Exception e) {
            try {
                Thread.sleep(2000);
                createFragmentMutableLiveData.postValue(new Error(e));
            }
            catch (Exception exception){
                exception.getMessage();
            }
        }
    }
}