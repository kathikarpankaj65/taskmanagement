package com.example.taskmanagement;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreateActivityViewModel extends ViewModel {
    LiveData<Result> getCreateActivityViewModel(String date, String time, String project, String tasks) {
        MutableLiveData<Result> createLiveData = new MutableLiveData<Result>();
        CreateThread createThread = new CreateThread(createLiveData, date, time, project, tasks);
        createThread.start();
        return createLiveData;
    }
}

class CreateThread extends Thread {
    Success<String> success;
    final MutableLiveData<Result> createLiveData;
    String date, time, project, tasks;

    CreateThread(MutableLiveData<Result> createLiveData, String date, String time, String project, String tasks) {
        this.createLiveData = createLiveData;
        this.date = date;
        this.time = time;
        this.project = project;
        this.tasks = tasks;
    }

    @Override
    public void run() {
        try {
            createLiveData.postValue(new Loading());
            if (date == null || date.isEmpty()) {
                throw new DateException();
            }
            String[] strings = date.split("-");
            int day = strings[0].length();
            int month = strings[1].length();
            int year = strings[2].length();
            if (!(day == 2 && month == 2 && year == 4)) {
                throw new DateException();
            }
            if (time == null || time.isEmpty()) {
                throw new TimeException();
            }
            String[] strings1 = time.split(":");
            int d = strings1[0].length();
            int f = strings1[1].length();
            if (!(d == 2 && f == 2)) {
                throw new TimeException();
            }
            if (project == null || project.isEmpty()) {
                throw new ProjectException();
            }
            if (tasks == null || tasks.isEmpty()) {
                throw new TasksException();
            }
            Thread.sleep(2000);
            createLiveData.postValue(new Success<String>("Data Save Successfully"));
        } catch (Exception e) {
            try {
                Thread.sleep(2000);
                createLiveData.postValue(new Error(e));
            } catch (Exception exception) {
                exception.getMessage();
            }
        }
    }
}